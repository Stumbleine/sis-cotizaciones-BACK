package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umss.dev.entity.SpendingUnitRequest;

@Repository
public interface SpendingUnitRequestRepository extends JpaRepository<SpendingUnitRequest, Integer>{

}
