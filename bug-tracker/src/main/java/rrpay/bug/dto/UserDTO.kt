package rrpay.bug.dto

import rrpay.bug.model.kt.enums.Role

data class UserDTO(val  loginName:String = "rraj",
                   val role: Role = Role.ADMIN)
