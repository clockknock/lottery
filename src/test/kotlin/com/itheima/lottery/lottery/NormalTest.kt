package com.itheima.lottery.lottery

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
    fun testGetBalls() {
        val user = UserServiceImpl().findByUsernameAndPassword("zs", "123")
        println(user)
    }

}