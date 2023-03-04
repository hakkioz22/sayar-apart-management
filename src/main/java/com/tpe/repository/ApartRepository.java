package com.tpe.repository;

import com.tpe.domain.Apart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartRepository extends JpaRepository<Apart,Long>{

    boolean existByTenantName(String tenantName);
}
