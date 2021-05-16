package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}
