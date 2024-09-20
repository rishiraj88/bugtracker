package rrpay.bug.kt.repo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import rrpay.bug.kt.model.Bug

@Repository
interface BugRepository:MongoRepository<Bug,String> {
     findByCode(code:String): List<Bug>

     deleteByCode(code:String):Unit

}