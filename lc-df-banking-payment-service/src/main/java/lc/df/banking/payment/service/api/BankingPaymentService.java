package lc.df.banking.payment.service.api;

import uk.co.ladbrokes.services.service.technical.ims.imspaymentwrapper._1.GetPaymentHistoryResponse;

public interface BankingPaymentService {

	GetPaymentHistoryResponse getPaymentHistory();

}
