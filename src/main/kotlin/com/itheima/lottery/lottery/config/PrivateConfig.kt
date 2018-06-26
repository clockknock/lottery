package com.itheima.lottery.lottery.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer


/**
 * @author 钟未鸣
 * @date 2018/6/24
 *
 * value可指定多个配置文件的所在位置
 * 加上encoding = "utf-8"属性防止中文乱码,不能为大写的"UTF-8"
 */

@Configuration
@PropertySource(value= ["classpath:private.properties"]
        , ignoreResourceNotFound = true,
        encoding ="utf-8")
class PrivateConfig {

    /**
     * PropertySourcesPlaceholderConfigurer这个bean，
     * 这个bean主要用于解决@value中使用的${…}占位符。
     * 假如你不使用${…}占位符的话，可以不使用这个bean。
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }
}