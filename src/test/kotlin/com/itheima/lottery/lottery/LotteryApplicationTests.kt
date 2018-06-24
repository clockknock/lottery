package com.itheima.lottery.lottery

import com.itheima.lottery.lottery.service.BallHistoryService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class LotteryApplicationTests {

	@Test
    fun genRedList(){
        val histories = historyService.findAll()
        println(histories.size)
    }

	@Test
	fun contextLoads() {

	}

    @Autowired
    lateinit var historyService: BallHistoryService

}
