package com.itheima.lottery.lottery.service

import com.itheima.lottery.lottery.bean.Note

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
interface NoteService{
    fun save(note: Note)

    fun findById(id:String):Note

    fun findAll():List<Note>
}