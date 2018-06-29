package com.itheima.lottery.lottery

import com.itheima.lottery.lottery.bean.CartItem
import com.itheima.lottery.lottery.service.impl.UserServiceImpl
import com.itheima.lottery.lottery.utils.BallUtil
import com.itheima.lottery.lottery.utils.MD5Util
import org.junit.Test

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
class NormalTest {

    @Test
    fun testSubstring(){
        val strings = arrayOf("01", "02", "03", "04", "05")
        val item = CartItem(strings, "10")
        val toString = item.reds.toList().toString()
        println(toString)
        val substring = toString.substring( 1,toString.length-1)
        println(substring)
    }

    @Test
    fun testGetBalls() {
        val user = UserServiceImpl().findByUsernameAndPassword("zs", "123")
        println(user)
    }

}