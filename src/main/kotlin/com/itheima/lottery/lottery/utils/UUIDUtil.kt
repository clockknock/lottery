package com.itheima.lottery.lottery.utils

import java.util.UUID



/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
object UUIDUtil {
    /**
     * 随机生成id
     * @return
     */
    fun getId(): String {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase()
    }

    /**
     * 生成随机码
     * @return
     */
    fun getCode(): String {
        return getId()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(getId())
    }
}