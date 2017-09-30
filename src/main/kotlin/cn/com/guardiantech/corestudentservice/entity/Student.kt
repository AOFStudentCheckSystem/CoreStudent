package cn.com.guardiantech.corestudentservice.entity

import cn.com.guardiantech.corestudentservice.util.NoArg
import javax.persistence.*


/**
 * Created by DE_DZ_TBH on 2017/5/26.
 */

@Entity
@NoArg
class Student(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,

        @Column(unique = true, length = 16, nullable = false)
        var idNumber: String,

        @Column(nullable = false, length = 64)
        var lastName: String,

        @Column(nullable = false, length = 64)
        var firstName: String,

        @Column(length = 64)
        var preferredName: String = "",

        @Column(unique = true, length = 64)
        var email: String? = null,

        var studentType: Short = 0,

        var dorm: String = "",

        var grade: Int = 0
) {
    @OneToMany(mappedBy = "owner", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    var cards: MutableSet<Card> = hashSetOf()

    fun addCards(cds: Set<Card>) {
        cards.addAll(cards)
        cds.forEach {
            it.owner = this
        }
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        if (idNumber != other.idNumber) return false
        if (lastName != other.lastName) return false
        if (firstName != other.firstName) return false
        if (preferredName != other.preferredName) return false
        if (email != other.email) return false
        if (studentType != other.studentType) return false
        if (dorm != other.dorm) return false
        if (grade != other.grade) return false
        if (cards !== other.cards) return false

        return true
    }
}