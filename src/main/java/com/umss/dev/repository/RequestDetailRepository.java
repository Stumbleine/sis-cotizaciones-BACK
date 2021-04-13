package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umss.dev.entity.RequestDetail;

@Repository
public interface RequestDetailRepository extends JpaRepository<RequestDetail, Integer> {

}
