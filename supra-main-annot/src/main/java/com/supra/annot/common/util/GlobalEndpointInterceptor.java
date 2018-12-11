package com.supra.annot.common.util;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.saaj.SaajSoapMessage;



@Component
public class GlobalEndpointInterceptor implements EndpointInterceptor {

    
	
	private static final Logger logger = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_ERROR);
	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);

	 @Override
	    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
	        return true;
	    }

	    @Override
	    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
	        return true;
	    }

	    @Override
	    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
	    	 SaajSoapMessage response = (SaajSoapMessage) messageContext.getResponse();
	    	 alterSoapEnvelope(response); 
	         return true;
	    }
	    private void alterSoapEnvelope(SaajSoapMessage soapResponse) {
	        try {
	          SOAPMessage soapMessage = soapResponse.getSaajMessage();
	          SOAPPart soapPart = soapMessage.getSOAPPart();
	          SOAPBody body = soapMessage.getSOAPBody();
	          SOAPFault soapFault = body.getFault();
	          
	          String faultCode = CommonConstants.STR_ZERO;
	          String faultMessage = CommonConstants.EXC_SERVER_ERROR;
	          System.out.println("soapFault 1="+soapFault);
	          if(soapFault != null){
			    	
			    	String faultMsg = soapFault.getFaultString();
			    	System.out.println("faultMsg 2="+faultMsg);
			    	
			    	if(faultMsg != null && !faultMsg.isEmpty()){
			    		
			    		String faultMsgs[] = faultMsg.split("-");
			    		System.out.println("faultMsgs 3="+faultMsgs);
			    		if(faultMsgs!=null){
			    			for(String msg:faultMsgs){
				    			System.out.println("\tmsg="+msg);
				    		}	
			    		}
			    		
			    		System.out.println("faultMsgs.length="+faultMsgs.length);
			    		System.out.println("faultMsgs[2].trim()="+faultMsgs[2].trim());
			    		if(faultMsgs.length > 1 && ExceptionUtil.SUPRASERVICES_EXCEPTION.equals(faultMsgs[2].trim())){
			    			System.out.println("inside if 1");
			    			faultCode = faultMsgs[0];
			    			faultMessage = faultMsgs[1];
			    			System.out.println("faultMsgs[0]=="+faultMsgs[0]);
			    			System.out.println("faultMsgs[1]=="+faultMsgs[1]);
			    			
			    			loggerInfo.info("SOAP FAULT : "+soapFault.getFaultString());
			    			
			    		}else if(faultMsg.contains(CommonConstants.DB_EXC_ORA_NO_DATA_FOUND)
			    				|| faultMsg.contains(CommonConstants.EXC_NO_DATA_FOUND_JPA_STR)){
			    			System.out.println("inside if 2");
			    			logger.error("SOAP FAULT : "+soapFault.getFaultString());
			    			
			    			faultCode = ExceptionBusinessConstants.NO_DATA_FOUND;
			    			faultMessage = ExceptionUtil.getErrorMessageFromProps(ExceptionBusinessConstants.NO_DATA_FOUND, ExceptionUtil.EXCEPTION_BUSINESS);
			    			
			    		}else{
			    			System.out.println("inside if 3");
			    			logger.error("SOAP FAULT : "+soapFault.getFaultString());
			    			System.out.println("soapFault.getFaultString()="+soapFault.getFaultString());
			    			
			    			faultCode = CommonConstants.STR_ZERO;
			    			faultMessage = CommonConstants.EXC_SERVER_ERROR;
			    		}
			    	}
		    	}
		    	System.out.println("final faultCode="+faultCode);
		    	System.out.println("final faultMessage="+faultMessage);
		    	soapFault.setFaultCode(faultCode);
		    	soapFault.setFaultString(faultMessage);
	        } catch (SOAPException e) {
	        	logger.error("SOAPException : ", e);
	        }
	      }

	    @Override
	    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
	    }
}