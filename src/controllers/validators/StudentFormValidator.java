package controllers.validators;

public class StudentFormValidator extends BaseFormValidator {

	public StudentFormValidator () {
		inputFieldsValidationState.put("firstName", false);
		inputFieldsValidationState.put("lastName", false);
		inputFieldsValidationState.put("dateOfBirth", false);
		inputFieldsValidationState.put("addressStreet", false);
		inputFieldsValidationState.put("addressHouseNumber", false);
		inputFieldsValidationState.put("addressCity", false);
		inputFieldsValidationState.put("addressCountry", false);
		inputFieldsValidationState.put("phoneNumber", false);
		inputFieldsValidationState.put("email", false);
		inputFieldsValidationState.put("indexNumber", false);
		inputFieldsValidationState.put("enrollmentYear", false);
	}
	
	public boolean validateInput(String inputName, String inputValue) {
		switch(inputName) {
			case "firstName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
			case "lastName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
			case "dateOfBirth":
				return validateDate(inputName, inputValue, ValidationPatterns.dateFormat);
			case "addressStreet":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.anything);
			case "addressCity":
			case "addressCountry":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabetsWithWhiteSpace);
			case "addressHouseNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.number);
			case "phoneNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.phoneNumber);
			case "email":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.email);
			case "enrollmentYear":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.number);
			case "indexNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.indexNumber);
			default:
				return false;
		}
	
	}
	
}
