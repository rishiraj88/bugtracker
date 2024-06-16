package rrpay.bug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import rrpay.bug.model.Bug;

public interface BugRepository extends MongoRepository<Bug,String> {
    public Bug findByCode(String code);

    public void deleteByCode(String code);
}