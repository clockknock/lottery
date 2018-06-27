package com.itheima.lottery.lottery.repository

import com.itheima.lottery.lottery.bean.Comment
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
interface CommentRepository : JpaRepository<Comment,Int>