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
        registration.addUrlPatterns(
                "/user/myUI",//用户模块
                "/bbs/note/*","/bbs/comment",//论坛模块
                "/cart/*",//购物车模块
                "/order/*"//订单模块
        )
        //设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue")//添加默认参数
        registration.setName("loginFilter")//设置优先级
        registration.order = 1//设置优先级
        return registration
    }

    @Bean
    fun cartFilterRegistration(): FilterRegistrationBean<*> {
        val registration = FilterRegistrationBean<WebFilter>()
        registration.filter = WebFilter()//添加过滤器
        registration.addUrlPatterns("/cart/*")//设置过滤路径，/*所有路径
//        registration.addInitParameter("name", "alue")//添加默认参数
        registration.setName("cartFilter")//设置优先级
        registration.order = 1//设置优先级
        return registration
    }



}