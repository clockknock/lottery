package com.itheima.lottery.lottery.utils

import com.itheima.lottery.lottery.bean.BallHistory
import kotlin.reflect.KProperty

/**
 * @author 钟未鸣
 * @date 2018/6/23
 */
object String2List {
    operator fun getValue(ballHistory: BallHistory, property: KProperty<*>): List<String>? {
        return ballHistory.red?.split(",")
    }

    operator fun setValue(ballHistory: BallHistory, property: KProperty<*>, list: List<String>?) {

    }
}