package rrpay.bug.dto

import rrpay.bug.model.User

data class CommentDTO(
    val text: String,
    val author: User)
