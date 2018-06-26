package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.Note
import com.itheima.lottery.lottery.bean.User
import com.itheima.lottery.lottery.service.NoteService
import com.itheima.lottery.lottery.service.impl.NoteServiceImpl
import com.itheima.lottery.lottery.utils.UUIDUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.text.DateFormat
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Controller
@RequestMapping("/bbs")
class BbsController {

    @RequestMapping("/index")
    fun index(): String {
        return "bbs"
    }

    @PostMapping("/note/")
    fun save(note: Note, request: HttpServletRequest, model: Model): String {

        note.id = UUIDUtil.getId()
        note.ip = request.remoteAddr
        note.time = DateFormat.getDateInstance().format(Date())
        noteService.save(note)
        return "redirect:/bbs/index"

    }

    @Autowired
    lateinit var noteService: NoteService

}