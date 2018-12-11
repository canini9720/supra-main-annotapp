package com.supra.annot.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class Application  implements WebApplicationInitializer  {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/*");

		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(applicationContext);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		Dynamic wsServlet = servletContext.addServlet("wsServlet", messageDispatcherServlet);
		wsServlet.setLoadOnStartup(2);
		wsServlet.addMapping("/wsservice/*");
		
	
		
		servletContext.addListener(new ContextLoaderListener(applicationContext));
	}

	private AnnotationConfigWebApplicationContext buildApplicationContext() {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("com.supra.annot.config");
		return webApplicationContext;
	}
}
