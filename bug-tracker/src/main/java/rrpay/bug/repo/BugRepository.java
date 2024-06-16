package rrpay.bug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import rrpay.bug.model.Bug;

import java.util.List;

public interface BugRepository extends MongoRepository<Bug,String> {
    public List<Bug> findByCode(String code);

    public void deleteByCode(String code);
}
