package controllers.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public abstract class BaseFormValidator {
	
	protected HashMap<String, Boolean> inputFieldsValidationState;
	
	public BaseFormValidator() {
		inputFieldsValidationState = new HashMap<>();
	}
	
	protected boolean validateWithRegex(String inputName, String inputValue, String regex) {
		boolean result = inputValue.matches(regex);
		inputFieldsValidationState.replace(inputName, result);
		return result;
	}
	
	protected boolean validateDate(String inputName, String inputValue, SimpleDateFormat dateFormat) {
		try {
			dateFormat.parse(inputValue);
			inputFieldsValidationState.replace(inputName, true);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	public boolean isAllValid() {
		for (Boolean value : inputFieldsValidationState.values()) {
			if (!value)
				return false;
		}
		return true;
	}
	
	public void setValidator(boolean state) {
		for (String key : inputFieldsValidationState.keySet())
			inputFieldsValidationState.replace(key, state);
	}
}
