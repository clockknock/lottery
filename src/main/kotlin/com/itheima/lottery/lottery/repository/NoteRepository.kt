package com.itheima.lottery.lottery.repository

import com.itheima.lottery.lottery.bean.Note
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
interface NoteRepository :JpaRepository<Note,String>