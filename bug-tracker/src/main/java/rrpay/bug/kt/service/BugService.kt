package rrpay.bug.kt.service

interface BugService {

      getBugs():List<BugDTO>

      createBug(BugDTO bug):Bug

     getBugsByCode(String code): List<BugDTO>

     getOneBugByCode(String code): BugDTO

      deleteBug(String code):void

      deleteAllBugs():Unit

      updateBugDescription(String code, String description):String
}