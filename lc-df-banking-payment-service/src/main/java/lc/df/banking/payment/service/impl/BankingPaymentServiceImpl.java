package lc.df.banking.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import lc.df.banking.payment.service.api.BankingPaymentService;
import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryResponse;

public class BankingPaymentServiceImpl implements BankingPaymentService {

	
	@Autowired
	BankingPaymentRepo repository;
	
	@Override
	public GetPaymentHistoryResponse getPaymentHistory() {
		
		return null;
	}

}
