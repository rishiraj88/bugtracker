package rrpay.bug.dto;

import lombok.NoArgsConstructor;
import rrpay.bug.model.User;

@NoArgsConstructor
public class CommentDTO {
  private String text;
  private User author;

}
