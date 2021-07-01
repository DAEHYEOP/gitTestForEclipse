package kr.co.jhta.web.test;


import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@RestController
public class ImportController {
	
	@GetMapping("/importTest")
	public String iam() {
		StringBuffer sb = new StringBuffer();
		String jsonPrintString = null;
		
		String apiUrl = "https://www.yourdomain.com/payments/complete";
		
		IamportClient client = new IamportClient("{7987320737412100}", "{9bfa8059602c7c7945e1af6edb4d483b7e03168d44b3ad1d63db181b1412d689e5969aee5da1a0b9}", true);
		
		try {
			IamportResponse<Payment> paymentResponse = client.paymentByImpUid("imp_123412341234");
			
			//TODO : 처리 로직
		} catch (IamportResponseException e) {
			System.out.println(e.getMessage());
			
			switch(e.getHttpStatusCode()) {
			case 401 :
				//TODO : 401 Unauthorized 
				break;
			case 404 :
				//TODO : imp_123412341234 에 해당되는 거래내역이 존재하지 않음
			 	break;
			case 500 :
				//TODO : 서버 응답 오류
				break;
			}
		} catch (IOException e) {
			//서버 연결 실패
			e.printStackTrace();
		}

		return apiUrl;
	}

}
