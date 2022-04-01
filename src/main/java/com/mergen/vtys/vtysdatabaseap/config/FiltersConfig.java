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
                "/user/users", "/user/users/*", "/user/*", "/user/*/*", "/user/new", "/user/update/*","/user/remove/*",
                "/company/companies", "/company/companies/*", "/company/new", "/company/update/*", "/company/remove/*",
                "/branch/branches", "/branch/branches/*", "/branch/new", "/branch/update/*", "/branch/remove/*",
                "/activityevaluation/evaluations", "/activityevaluation/evaluations/*", "/activityevaluation/new", "/activityevaluation/update/*", "/activityevaluation/remove/*",
                "/activity/activities", "/activity/activities/*", "/activity/new", "/activity/update/*", "/activity/remove/*",
                "/activetouser/activetousers", "/activetouser/activetousers/*","/activetouser/user/*","/activetouser/activity/enrolled/*","/activetouser/new","/activetouser/update/*","/activetouser/remove/*,",
                "/userdetail/userdetails", "/userdetail/userdetails/*", "/userdetail/new", "/userdetail/update/*", "/userdetail/remove/*" ,
                "/department/find/branch:*"


        );
        return registrationBean;
    }
}

    