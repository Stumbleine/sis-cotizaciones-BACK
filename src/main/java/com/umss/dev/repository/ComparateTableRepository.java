package com.umss.dev.repository;

import javax.transaction.Transactional;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.ComparateTable;

@Repository
public interface ComparateTableRepository  extends JpaRepository<ComparateTable, Integer>{

	@Modifying
	@Transactional
	@Query(value ="UPDATE price_quotation r set r.id_comparate_table=:idTable where r.id_price_quotation=:idQuotation",nativeQuery = true)
	void upDatePrice(@Param("idTable") int idTable,@Param("idQuotation") int idQuotation);
	
}
