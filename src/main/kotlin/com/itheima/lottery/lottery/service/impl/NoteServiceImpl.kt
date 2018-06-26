package com.itheima.lottery.lottery.service.impl

import com.itheima.lottery.lottery.bean.Note
import com.itheima.lottery.lottery.repository.NoteRepository
import com.itheima.lottery.lottery.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Service
class NoteServiceImpl :NoteService {
    override fun save(note: Note) {
        noteRepository.save(note)
    }

    override fun findAll(): List<Note> {
        return noteRepository.findAll()
    }

    @Autowired
    lateinit var noteRepository: NoteRepository

}