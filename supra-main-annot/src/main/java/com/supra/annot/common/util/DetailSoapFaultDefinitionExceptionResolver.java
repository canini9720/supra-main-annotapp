package com.supra.annot.common.util;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("code");
    private static final QName DESCRIPTION = new QName("description");
    private static final Logger logger = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_ERROR);
	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
      //  logger.warn("Exception processed ", ex);
    	//System.out.println("SAOP exp resolver cutomized");
    	String faultCode = CommonConstants.STR_ZERO;
    	String faultMessage = CommonConstants.EXC_SERVER_ERROR;
    	String faultMsg =ex.getMessage();
        if (ex instanceof RuntimeException) {
            SoapFaultDetail detail = fault.addFaultDetail();
            if(faultMsg != null && !faultMsg.isEmpty()){
            	String faultMsgs[] = faultMsg.split("-");
            	if(faultMsgs.length > 1 && ExceptionUtil.SUPRASERVICES_EXCEPTION.equals(faultMsgs[2].trim())){
	    			faultCode = faultMsgs[0];
	    			faultMessage = faultMsgs[1];
	    			loggerInfo.info("SOAP FAULT : "+faultMsg);
	    		}else if(faultMsg.contains(CommonConstants.DB_EXC_ORA_NO_DATA_FOUND)|| faultMsg.contains(CommonConstants.EXC_NO_DATA_FOUND_JPA_STR)){
	    			logger.error("SOAP FAULT : "+faultMsg);
	    			faultCode = ExceptionBusinessConstants.NO_DATA_FOUND;
	    			faultMessage = ExceptionUtil.getErrorMessageFromProps(ExceptionBusinessConstants.NO_DATA_FOUND, ExceptionUtil.EXCEPTION_BUSINESS);
	    		}else{
	    			logger.error("SOAP FAULT : "+faultMsg);
	    			faultCode = CommonConstants.STR_ZERO;
	    			faultMessage = CommonConstants.EXC_SERVER_ERROR;
	    		}
            }
           detail.addFaultDetailElement(CODE).addText(faultCode);
           detail.addFaultDetailElement(DESCRIPTION).addText(faultMessage);
        }else{
        	logger.error("SOAP FAULT : "+faultMsg);
        	SoapFaultDetail detail = fault.addFaultDetail();
        	detail.addFaultDetailElement(CODE).addText(CommonConstants.STR_ZERO);
            detail.addFaultDetailElement(DESCRIPTION).addText(CommonConstants.EXC_SERVER_ERROR);
        }
    }

}