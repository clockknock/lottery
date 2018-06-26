package com.itheima.lottery.lottery

import com.itheima.lottery.lottery.repository.BallHistoryRepository
import com.itheima.lottery.lottery.service.BallHistoryService
import com.itheima.lottery.lottery.service.UserService
import com.itheima.lottery.lottery.service.impl.UserServiceImpl
import com.itheima.lottery.lottery.utils.MD5Util
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.security.MessageDigest

@RunWith(SpringRunner::class)
@SpringBootTest
class LotteryApplicationTests {

    @Test
    fun testNote() {
        val user = userService.findByUsernameAndPassword("zs", "123")
        println(user)
    }

    @Autowired
    lateinit var userService: UserService


}
