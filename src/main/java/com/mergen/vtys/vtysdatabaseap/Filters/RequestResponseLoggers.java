package com.mergen.vtys.vtysdatabaseap.Filters;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;


@Component
@Slf4j
//@Order(1)
public class RequestResponseLoggers implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        MyCustomHttpRequestWrapper requestWrapper = new MyCustomHttpRequestWrapper((HttpServletRequest) request);
        String uri = requestWrapper.getRequestURI();
        log.info("Request URI: {} ", uri);
        log.info("Request Method: {} ", requestWrapper.getMethod());
        String requestData = new String(requestWrapper.getByteArray());

        if("/user/post".equalsIgnoreCase(uri))   //  Request Body özel bilgileri şifreleme
        {
            User user = objectMapper.readValue(requestData, User.class);
            user.setPassword("*****");
            requestData = objectMapper.writeValueAsString(user);
        }

        log.info("Request Body: {} ", requestData);
        MyCustomHttpResponseWrapper responseWrapper = new MyCustomHttpResponseWrapper((HttpServletResponse) response);
        chain.doFilter(requestWrapper,responseWrapper);
        String responseResult = new String(responseWrapper.getBaos().toByteArray());

        if("/user/post".equalsIgnoreCase(uri))   // Response Body özel bilgileri şifreleme
        {
            User user = objectMapper.readValue(responseResult, User.class);
            user.setPassword("*****");
            responseResult = objectMapper.writeValueAsString(user);
        }

        log.info("Response status - {}", responseWrapper.getStatus());
        log.info("Response Body - {}", responseResult);

    }

    @Getter
    private class MyCustomHttpRequestWrapper extends HttpServletRequestWrapper {

        private byte[] byteArray;

        public MyCustomHttpRequestWrapper(HttpServletRequest request) {
            super(request);
            try {
                byteArray = IOUtils.toByteArray(request.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException("Issue while reading request stream");
            }
        }

        @Override
        public ServletInputStream getInputStream() throws IOException
        {return new MyDelegatingServletInputStream(new ByteArrayInputStream(byteArray));}
    }

    @Getter
    private class MyCustomHttpResponseWrapper extends HttpServletResponseWrapper {

        private ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        public MyCustomHttpResponseWrapper(HttpServletResponse response) {super(response);}

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyDelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), printStream));
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(new TeeOutputStream(super.getOutputStream(), printStream));
        }
    }
}
