package com.itheima.lottery.lottery.service

import com.itheima.lottery.lottery.bean.Comment

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
interface CommentService {
    fun save(comment:Comment)
    fun findById(id:Int):Comment?

}