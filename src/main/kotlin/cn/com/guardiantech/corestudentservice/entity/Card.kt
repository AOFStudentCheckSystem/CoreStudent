package cn.com.guardiantech.corestudentservice.entity

import javax.persistence.*

@Entity
class Card (
        @Id
        @Column(length = 64)
        var cardSecret: String,

        @ManyToOne
        @JoinColumn(name = "student_id")
        var owner: Student
)