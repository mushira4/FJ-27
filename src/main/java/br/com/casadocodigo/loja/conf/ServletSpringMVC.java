package br.com.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfiguration.class, AppWebConfiguration.class, JPAConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
}
