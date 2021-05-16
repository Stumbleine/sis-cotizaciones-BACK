package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umss.dev.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer>{

}
