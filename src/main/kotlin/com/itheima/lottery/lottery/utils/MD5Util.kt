package com.itheima.lottery.lottery.utils

import org.springframework.beans.factory.annotation.Value
import java.security.NoSuchAlgorithmException
import java.security.MessageDigest
import kotlin.experimental.and


/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
object MD5Util {

    //加盐操作
    fun encodeSalt(pwd: String,salt:String): String {
        return encode(pwd + salt)
    }


    /**
     * 获取MD5加密
     *
     * @param password
     * 需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    fun encode(password: String): String {
        try {
            val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
            val digest: ByteArray = instance.digest(password.toByteArray())//对字符串加密，返回字节数组
            val sb = StringBuffer()
            for (b in digest) {
                val i: Int = b.toInt() and 0xff//获取低八位有效值
                var hexString = Integer.toHexString(i)//将整数转化为16进制
                if (hexString.length < 2) {
                    hexString = "0$hexString"//如果是一位的话，补0
                }
                sb.append(hexString)
            }
            return sb.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}