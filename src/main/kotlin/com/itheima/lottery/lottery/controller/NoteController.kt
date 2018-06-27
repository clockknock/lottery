package com.itheima.lottery.lottery.controller

import com.itheima.lottery.lottery.bean.Comment
import com.itheima.lottery.lottery.bean.Note
import com.itheima.lottery.lottery.bean.User
import com.itheima.lottery.lottery.service.CommentService
import com.itheima.lottery.lottery.service.NoteService
import com.itheima.lottery.lottery.utils.UUIDUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.text.DateFormat
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * @author 钟未鸣
 * @date 2018/6/24
 */
@Controller
@RequestMapping("/bbs")
class NoteController {

    @RequestMapping("/index")
    fun index(model: Model): String {
        val notes = noteService.findAll()
        model.addAttribute("notes", notes)
        return "bbs"
    }

    @PostMapping("/note/")
    fun save(note: Note, request: HttpServletRequest, session: HttpSession, model: Model): String {
        val user = session.getAttribute("user") as User
        note.id = UUIDUtil.getId()
        note.username = user.username
        note.ipaddress = request.remoteAddr
        note.time = DateFormat.getDateInstance().format(Date())

        noteService.save(note)
        return "redirect:/bbs/index"
    }

    @GetMapping("/note/{id}")
    fun getNote(@PathVariable id: String, model: Model): String {
        val note = noteService.findById(id)
        model.addAttribute("note", note)

        return "bbs-detail"
    }

    @PostMapping("/comment")
    fun addComment(nid: String, comment: Comment, request: HttpServletRequest, model: Model):
            String {
        val user = request.session.getAttribute("user") as User
        comment.username = user.username
        comment.ipaddress = request.remoteAddr
        comment.time = DateFormat.getDateInstance().format(Date())
        val note: Note = noteService.findById(nid)
        comment.nid = note

        commentService.save(comment)
        return "redirect:/bbs/note/" + note.id

    }

    @Autowired
    lateinit var noteService: NoteService
    @Autowired
    lateinit var commentService: CommentService

}