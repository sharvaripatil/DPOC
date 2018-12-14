package com.a4tech.shipping.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.a4tech.shipping.model.NormalLoadConfiguration;

@Component
public class NormalLoadValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NormalLoadConfiguration.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {

		ValidationUtils.rejectIfEmpty(error, "districtName", "normalLoad.districtName.empty");
		ValidationUtils.rejectIfEmpty(error, "ratedLoad", "normalLoad.ratedLoad.empty");
		ValidationUtils.rejectIfEmpty(error, "normalLoad", "normalLoad.normalLoad.empty");
	}

}
