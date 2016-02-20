package br.com.casadocodigo.loja.controllers.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");

		Product product = (Product) object;
		if (product.getNumberOfPages() < 30) {
			errors.rejectValue("numberOfPages", "field.number.value.minValue");
		}
	}

}
