package rrpay.bug.model.enums;

public enum BugStatus {
    NEW,ASSIGNED,ACTIVE,TEST,VERIFIED,CLOSED,REJECTED,DEFERRED,NEED_INFO
}

/*
 * TODO: the permissible set of states for the finite state machine (FSM) of Bug:-
 * defect / bug life cycle:
 * New
 * Assigned
 * Active --> Rejected or Deferred
 * Test --> Reopened --> Active
 * Verified
 * Closed
 */