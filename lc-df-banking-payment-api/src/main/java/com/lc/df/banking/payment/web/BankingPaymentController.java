package com.lc.df.banking.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.df.banking.payment.service.api.BankingPaymentService;

import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryRequest;
import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryResponse;

@RestController
public class BankingPaymentController {
	
	
	@Autowired
	BankingPaymentService service;
	
	/*@PostMapping("/confirmPayment")
	public @ResponseBody String confirmPaymentRequest(@RequestBody String request)throws Exception{
		return request;
		
	}
	
	@PostMapping("/cancelPayment")
	public @ResponseBody String cancelPaymentRequest(@RequestBody String request)throws Exception{
		return request;
	}
	
	@PostMapping("/deposit")
	public @ResponseBody String depositRequest(@RequestBody String request)throws Exception{
		return request;
	}
	
	@PostMapping("/fundTransfer")
	public @ResponseBody String fundTransferRequest(@RequestBody String request)throws Exception{
		return request;
	}

	@PostMapping("/withdraw")
	public @ResponseBody String withdrawRequest(@RequestBody String request)throws Exception{
		return request;
	}*/
	
	@PostMapping("/getPaymentHistory")
	public @ResponseBody GetPaymentHistoryResponse getPaymentHistoryRequest(@RequestBody GetPaymentHistoryRequest request)throws Exception{
		
		GetPaymentHistoryResponse response = new GetPaymentHistoryResponse();
		
		response = service.getPaymentHistory();
		
		return response;
	}
	
	/*@PostMapping("/initialQuickRegistration")
	public @ResponseBody String getinitialQuickRegistrationRequest(@RequestBody String request)throws Exception{
		return request;
	}

	@PostMapping("/getQuickRegistrationDetails")
	public @ResponseBody String getQuickRegistrationDetailsRequest(@RequestBody String request)throws Exception{
		return request;
	}
	
	@PostMapping("/finalizeQuickRegistrationDeposit")
	public @ResponseBody String finalizeQuickRegistrationDepositRequest(@RequestBody String request)throws Exception{
		return request;
	}*/
}
