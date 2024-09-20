package rrpay.bug.kt.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import rrpay.bug.model.Comment
import rrpay.bug.model.Project
import rrpay.bug.model.User
import rrpay.bug.model.kt.enums.BugStatus
import rrpay.bug.model.kt.enums.BugType
import rrpay.bug.model.kt.enums.Priority
import java.nio.file.Path
import java.time.LocalDateTime

@Document(collection = "bug")
data class Bug(
    var summary: String,
    var description: String,
    var priority: Priority = Priority.NONE,
    var status: BugStatus = BugStatus.NEW,
) {
    constructor(
        summary: String,
        description: String,
        priority: Priority = Priority.NONE,
        status: BugStatus = BugStatus.NEW, type: BugType = BugType.SOFTWARE_BUG
    ) : this(
        summary,
        description,
        priority,
        status
    ) {
        this.type = BugType.SOFTWARE_BUG
    }

    @Id
    var id: ObjectId? = null
    var code: String = ""
    var project: Project? = null
    var reporter: User? = null
    var assignee: User? = null
    var dateCreated: LocalDateTime? = null
    var dateResolved: LocalDateTime? = null
    var dateClosed: LocalDateTime? = null
    var comments: List<Comment>? = null
    var workHistory: List<String>? = null
    var attachments: Set<Path>? = null
    var type: BugType? = null

}


