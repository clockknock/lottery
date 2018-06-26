package com.itheima.lottery.lottery.utils

import java.util.*

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
object BallUtil {
    //格式符%02d中2d前面的前导符0表示输出数据时,若左边有多余位,则补0
    fun randomRed(): ArrayList<String> {
        val set: TreeSet<Int> = TreeSet()

        val random = Random()
        while (set.size < 6) {
            set.add(random.nextInt(33) + 1)
        }

        val balls = ArrayList<String>()
        set.forEach {
            balls.add(String.format("%02d", it))
        }

        return balls
    }

    fun randomBlue(): String {
        return String.format("%02d", Random().nextInt(33) + 1)
    }
}