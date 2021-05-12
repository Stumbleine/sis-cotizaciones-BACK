package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.ComparativeTableOfQuotes;

@Repository
public interface ComparativeTableOfQuotesRepository extends JpaRepository<ComparativeTableOfQuotes, Integer>{ 

}
