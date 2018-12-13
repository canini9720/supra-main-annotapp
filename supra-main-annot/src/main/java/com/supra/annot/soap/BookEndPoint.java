package com.supra.annot.soap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.supra.annot.common.util.CommonConstants;
import com.supra.annot.common.util.CommonUtil;
import com.supra.annot.common.util.WebServiceConstants;
import com.supra.annot.service.BookService;
import com.supra.supra.service.BookRequest;
import com.supra.supra.service.BookResponse;






@Endpoint
@DependsOn("ApplicationProperties")
public class BookEndPoint {

	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);
	private static final Logger logger = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_ERROR);
	
	
	@Autowired
	BookService bookService;

	

	@PayloadRoot(namespace = WebServiceConstants.SUPRA_APPLICANTINFO_NAMESPACE, localPart = "bookRequest")
	@ResponsePayload
	public BookResponse  bookRequest(@RequestPayload BookRequest request) throws Exception {
		System.out.println("book="+request);
		BookResponse response = new BookResponse();
		int result=bookService.saveBookOrder(request);
		response.setResponseCode(result);
		response.setResponseDesc( CommonUtil.getSuccessOrFailureMessageWithId(result));
		
		return response;
	}
	
	
}
