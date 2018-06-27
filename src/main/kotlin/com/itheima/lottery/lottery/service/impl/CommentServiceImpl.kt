package com.itheima.lottery.lottery.service.impl

import com.itheima.lottery.lottery.bean.Comment
import com.itheima.lottery.lottery.repository.CommentRepository
import com.itheima.lottery.lottery.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 钟未鸣
 * @date 2018/6/27
 */
@Service
class CommentServiceImpl : CommentService {
    override fun findById(id: Int): Comment? {
        return commentRepository.findById(id).get()
    }

    override fun save(comment: Comment) {
        commentRepository.saveAndFlush(comment)

    }

    @Autowired
    lateinit var commentRepository: CommentRepository

}