package com.supra.annot.soap;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.supra.annot.common.util.ApplicationProperties;
import com.supra.annot.common.util.CommonConstants;
import com.supra.annot.common.util.CommonUtil;
import com.supra.annot.common.util.WebServiceConstants;
import com.supra.annot.service.SupraService;
import com.supra.supra.service.Shiporder;
import com.supra.supra.service.ShiporderRequest;
import com.supra.supra.service.ShiporderResponse;






@Endpoint
@DependsOn("ApplicationProperties")
public class SupraEndPoint {

	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);
	private static final Logger logger = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_ERROR);
	
	public static  String locationUri = "";

	@Autowired
	SupraService supraService;

	
	@PostConstruct
	public void initialize(){
		locationUri = ApplicationProperties.props.get("esb.host")+ApplicationProperties.props.get("supra.loc.url");
	}
	
	
	

	@PayloadRoot(namespace = WebServiceConstants.SUPRA_APPLICANTINFO_NAMESPACE, localPart = "shiporderRequest")
	@ResponsePayload
	public ShiporderResponse  applicantInfoRequest(@RequestPayload ShiporderRequest request) throws Exception {
		System.out.println("shiporder="+request);
		ShiporderResponse response = new ShiporderResponse();
		int result = supraService.saveShiporder(request);
		response.setResponseCode(result);
		response.setResponseDesc( CommonUtil.getSuccessOrFailureMessageWithId(result));
		
		return response;
	}
	
	
}
