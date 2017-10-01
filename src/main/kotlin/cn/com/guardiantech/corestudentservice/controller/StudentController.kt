package cn.com.guardiantech.corestudentservice.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/student"), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
class StudentController {
    @Value("\${gcheck.defaultEmailDomain}")
    lateinit var defualtEmailDomain: String


}