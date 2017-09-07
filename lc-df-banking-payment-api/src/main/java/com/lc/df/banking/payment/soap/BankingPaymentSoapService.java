package com.lc.df.banking.payment.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lc.df.banking.payment.service.api.BankingPaymentService;

import uk.co.ladbrokes.services.service.commonmessage._2.ServiceError;
import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryRequest;
import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryResponse;

@Endpoint
public class BankingPaymentSoapService {

	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	private static final String NAMESPACE_URI = "http://services.ladbrokes.co.uk/service/Banking/Payment/Payment/1.1";

	@Autowired
	BankingPaymentService service;

	@Autowired
	BankingPaymentErrorLogger errorLogger;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHorseRequest")
	@ResponsePayload
	public GetPaymentHistoryResponse getPaymentHistory(@RequestPayload GetPaymentHistoryRequest request)
			throws Exception {
		slf4jLogger.info("RaceHorseSoapService:getHorse():");
		GetPaymentHistoryResponse response = new GetPaymentHistoryResponse();
		try {
			response = service.getPaymentHistory();
			if (null == response) {
				ServiceError serviceError = new ServiceError();
				errorLogger.handleError(new BankingPaymentServiceException(1, ""), serviceError, "service");
				return response;
			}
		} catch (Exception e) {
			ServiceError serviceError = new ServiceError();
			errorLogger.handleError(new BankingPaymentServiceException(1, ""), serviceError, "service");
			return response;
		}
		return response;
	}
}
