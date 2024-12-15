package rrpay.bug.dto;

import rrpay.bug.model.enums.Role;

public record UserDto(String loginName ,
                      Role role ) {
}
