package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.ComparateTable;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.input.ComparateTableInput;
import com.umss.dev.output.BusinessSubTotal;
import com.umss.dev.output.ComparateTableOutput;
import com.umss.dev.repository.ComparateTableRepository;
import com.umss.dev.repository.SpendingUnitRepository;
import com.umss.dev.repository.SpendingUnitRequestRepository;

@Service
public class ComparateTableService {
	@Autowired
	private ComparateTableRepository comparateTableRepository;
	@Autowired
	private SpendingUnitRequestRepository spendingUnitRepository;
	private ModelMapper mapper;
	
	public ComparateTableService(ComparateTableRepository comparateTableRepository, ModelMapper mapper) {
		super();
		this.comparateTableRepository = comparateTableRepository;
		this.mapper = mapper;
	}
	
	public void saveComparateTable(ComparateTableInput listPriceQuotation) {
		ComparateTable comparateTable = new ComparateTable();
		comparateTableRepository.save(comparateTable);
	
		for(int i=0;i< listPriceQuotation.getIdPriceQuotation().size();i++) {
			
			comparateTableRepository.upDatePrice(comparateTable.getIdComparateTable(), listPriceQuotation.getIdPriceQuotation().get(i));
		}
	}
	
	public ComparateTableOutput getComparateTable(int id) {
		ComparateTableOutput comparateTableOutput=new ComparateTableOutput();
		try {
			
			SpendingUnitRequest spendingUnit=spendingUnitRepository.findById(id).get();
			comparateTableOutput.setDetail(spendingUnit.getRequestDetail());
			List<String> nameBusiness=spendingUnitRepository.listNameBusiness(id);
			
			if(nameBusiness.isEmpty()) {
				comparateTableOutput=null;
			}
			else {
				List<BusinessSubTotal> businessSubTotals=new ArrayList<BusinessSubTotal>();
				
				for(int i=0;i<nameBusiness.size();i++) {
			
					BusinessSubTotal resp=new BusinessSubTotal();
					resp.setNameBusiness(nameBusiness.get(i));
					resp.setSubTotal(spendingUnitRepository.listSubTotal(id, nameBusiness.get(i)));
					businessSubTotals.add(resp);
					
				}
				
				comparateTableOutput.setComparateTableOutputs(businessSubTotals);
			}
			
		} catch (Exception e) {
			comparateTableOutput=null;
		}
				
		return comparateTableOutput;	
	}
}
