package rrpay.bug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rrpay.bug.model.Bug;

import java.util.List;

@Repository
public interface BugRepository extends MongoRepository<Bug, String> {
    List<Bug> findByCode(String code);
    void deleteByCode(String code);
}