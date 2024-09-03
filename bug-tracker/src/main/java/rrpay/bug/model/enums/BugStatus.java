package rrpay.bug.model.enums;

public enum BugStatus {
  OPEN, IN_PROGRESS,RESOLVED,NEED_INFO,CLOSED
}

/*
 * TODO: to implement a finite state machine (FSM) corresponding to this state model:-
 * defect / bug life cycle:
 * New
 * Assigned
 * Active --> Rejected or Deferred
 * Test --> Reopened --> Active
 * Verified
 * Closed
 */