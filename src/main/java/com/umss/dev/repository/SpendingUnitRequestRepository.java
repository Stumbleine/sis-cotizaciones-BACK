package com.umss.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import com.umss.dev.entity.RequestDetail;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.BusinessSubTotal;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;

@Repository
public interface SpendingUnitRequestRepository extends JpaRepository<SpendingUnitRequest, Integer>{

	@Query(value = "SELECT DISTINCT empresa.name \r\n"
			+ "FROM business empresa,price_qoutation_detail detalle,spending_unit_request pedido,price_quotaton_request solicitud,price_quotation cotizacion,comparate_tables cuadro \r\n"
			+ "WHERE	pedido.id_spending_unit_request=:id  \r\n"
			+ "AND pedido.id_spending_unit_request= solicitud.id_spending_unit_request \r\n"
			+ "AND solicitud.id_price_quotation_request=cotizacion.id_price_quotation_request \r\n"
			+ "AND cotizacion.id_comparate_table=cuadro.id_comparate_table\r\n"
			+ "AND cotizacion.id_price_quotation=detalle.id_price_quotation \r\n"
			+ "AND cotizacion.id_business=empresa.id_business;	",nativeQuery = true)
	List<String> listNameBusiness(@Param("id")int id);
	
	
	@Query(value = "SELECT  detalle.total_price\r\n"
			+ "FROM business empresa,price_qoutation_detail detalle,spending_unit_request pedido,price_quotaton_request solicitud,price_quotation cotizacion,comparate_tables cuadro \r\n"
			+ "WHERE	pedido.id_spending_unit_request=:id  \r\n"
			+ "AND pedido.id_spending_unit_request= solicitud.id_spending_unit_request \r\n"
			+ "AND solicitud.id_price_quotation_request=cotizacion.id_price_quotation_request \r\n"
			+ "AND cotizacion.id_comparate_table=cuadro.id_comparate_table\r\n"
			+ "AND cotizacion.id_price_quotation=detalle.id_price_quotation \r\n"
			+ "AND cotizacion.id_business=empresa.id_business AND empresa.name=:name",nativeQuery = true)
	List<Integer> listSubTotal(@Param("id")int id,@Param("name")String name); 
}
