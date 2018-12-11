package com.supra.annot.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.supra.annot.common.util.ApplicationProperties;
import com.supra.annot.common.util.GlobalEndpointInterceptor;
import com.supra.annot.common.util.WebServiceConstants;







@Component
@EnableWs
@Configuration
@DependsOn("ApplicationProperties")
public class WebServiceConfig extends WsConfigurerAdapter {
	
	public static  String locationUri = "";
	
	@PostConstruct
	public void initialize(){
		locationUri = ApplicationProperties.props.get("esb.host")+ApplicationProperties.props.get("supra.loc.url");
	}
	
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		super.addInterceptors(interceptors);
		interceptors.add(new GlobalEndpointInterceptor());
	}
	//@Bean
    /*Not Used
     * public SoapFaultMappingExceptionResolver exceptionResolver(){
        SoapFaultMappingExceptionResolver exceptionResolver = new DetailSoapFaultDefinitionExceptionResolver();

        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
        exceptionResolver.setDefaultFault(faultDefinition);

        Properties errorMappings = new Properties();
        errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
        errorMappings.setProperty(ValidationException.class.getName(), SoapFaultDefinition.SERVER.toString());
        exceptionResolver.setExceptionMappings(errorMappings);
        exceptionResolver.setOrder(1);
        return exceptionResolver;
    }*/

	@Bean(name = "supraSample")
	public DefaultWsdl11Definition applicantInfoWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("supraSamplePort");
		wsdl11Definition.setLocationUri(locationUri);
		wsdl11Definition.setTargetNamespace(WebServiceConstants.SUPRA_APPLICANTINFO_NAMESPACE);
		wsdl11Definition.setSchema(applicantInfoSchema());
		return wsdl11Definition;
	}

	
	@Bean
	public XsdSchema applicantInfoSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/sample.xsd"));
	}
}

