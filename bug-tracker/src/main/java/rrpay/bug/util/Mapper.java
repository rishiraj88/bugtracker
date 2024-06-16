package rrpay.bug.util;

import rrpay.bug.dto.BugDTO;
import rrpay.bug.model.Bug;

public class Mapper {
    public static Bug dtoToEntity(BugDTO dto) {
        Bug entity = new Bug();

        return entity;
    }

    public static BugDTO entityToDto(Bug entity) {
        BugDTO dto = new BugDTO();

        return dto;
    }
}
