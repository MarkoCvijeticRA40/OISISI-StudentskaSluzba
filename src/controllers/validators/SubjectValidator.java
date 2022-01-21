package controllers.validators;

public class SubjectValidator extends BaseFormValidator {
	
	public SubjectValidator() {
		inputFieldsValidationState.put("id", false);
		inputFieldsValidationState.put("name", false);
		inputFieldsValidationState.put("esbp", false);
	}
	
	public boolean validateInput(String inputName, String inputValue) {
		switch(inputName) {
			case "id":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.anything);
			case "name": 
				return validateWithRegex(inputName, inputValue, ValidationPatterns.anything);
			case "esbp":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.number);
			default:
				return false;
		}
	}
	
}
