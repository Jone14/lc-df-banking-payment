package com.lc.df.banking.payment.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
		registration.addUrlMappings("/payment/*");
		return registration;
	}

	@Bean(name = "getPaymentHistory")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema raceHorseServiceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PaymentServicePortType10");
		wsdl11Definition.setLocationUri("/payment");
		wsdl11Definition.setTargetNamespace("http://services.ladbrokes.co.uk/service/Banking/Payment/Payment/1.1");
		wsdl11Definition.setSchema(raceHorseServiceSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema raceHorseServiceSchema() {
		return new SimpleXsdSchema(
				new ClassPathResource("/ServiceSchema/Banking/Payment/Payment/1.1/PaymentService.xsd"));

	}

}
