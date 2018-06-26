package com.itheima.lottery.lottery.filter

import javax.servlet.ServletException
import javax.servlet.FilterConfig
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletResponse
import javax.servlet.ServletRequest
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.apache.catalina.filters.RemoteIpFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * @author 钟未鸣
 * @date 2018/6/26
 */
@Configuration
class ConfigurationFilter {
    @Bean
    fun remoteIpFilter(): RemoteIpFilter {
        return RemoteIpFilter()
    }

    @Bean
    fun testFilterRegistration(): FilterRegistrationBean<*> {
        val registration = FilterRegistrationBean<LoginFilter>()
        registration.filter = LoginFilter()//添加过滤器
        registration.addUrlPatterns("/user/myUI","/bbs/note/")//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue")//添加默认参数
        registration.setName("MyFilter")//设置优先级
        registration.order = 1//设置优先级
        return registration
    }


}