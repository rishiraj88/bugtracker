package rrpay.bug.dto;

import rrpay.bug.model.User;

record CommentDTO (
   String text,
  User author
  ){}
