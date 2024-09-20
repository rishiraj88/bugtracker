package rrpay.bug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rrpay.bug.kt.model.Bug;

import java.util.List;

@Repository
public interface BugRepository extends MongoRepository<Bug,String> {
    public List<Bug> findByCode(String code);

    public void deleteByCode(String code);
}
