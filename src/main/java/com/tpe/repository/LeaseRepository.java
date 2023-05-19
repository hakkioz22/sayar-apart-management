package com.tpe.repository;

import com.tpe.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    Lease findByLeaserName(String leaserName);
    Lease findBySocialSecurityNumber(String socialSecurityNumber);
    Lease findByLeaserPhone(String leaserPhone);
}
