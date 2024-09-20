package rrpay.bug.dto

import rrpay.bug.model.kt.enums.Role

data class UserDTO(
    var loginName: String = "rraj",
    var role: Role = Role.ADMIN
)
