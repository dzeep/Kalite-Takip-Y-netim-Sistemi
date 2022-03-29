package com.mergen.vtys.vtysdatabaseap.config;

import com.mergen.vtys.vtysdatabaseap.Filters.RequestResponseLoggers;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {

    @Bean
    FilterRegistrationBean<RequestResponseLoggers> createLoggers (RequestResponseLoggers requestResponseLoggers)
    {
        FilterRegistrationBean<RequestResponseLoggers> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestResponseLoggers);

        registrationBean.addUrlPatterns(  // Yazılan path'lere göre logging yapılmasını sağlar.
                "/user/users", "/user/users/*", "/user/*", "/user/*/*", "/user/post", "/user/put/*","/user/delete/*",
                "/company/companies", "/company/companies/*", "/company/post", "/company/put/*", "/company/delete/*",
                "/branch/branches", "/branch/branches/*", "/branch/post", "/branch/put/*", "/branch/delete/*",
                "/activityevaluation/evaluations", "/activityevaluation/evaluations/*", "/activityevaluation/post", "/activityevaluation/put/*", "/activityevaluation/delete/*",
                "/activity/activities", "/activity/activities/*", "/activity/post", "/activity/put/*", "/activity/delete/*",
                "/activetouser/activetousers", "/activetouser/activetousers/*","/activetouser/user/*","/activetouser/activity/enrolled/*","/activetouser/post","/activetouser/put/*","/activetouser/delete/*,",
                "/userdetail/userdetails", "/userdetail/userdetails/*", "/userdetail/post", "/userdetail/update/*", "/userdetail/delete/*"
        );
        return registrationBean;
    }
}

    