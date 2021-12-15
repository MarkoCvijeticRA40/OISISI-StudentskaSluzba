package controllers.validators;

public class ProfessorFormValidator extends BaseFormValidator {
	
	public ProfessorFormValidator() {
		inputFieldsValidationState.put("firstName", false);
		inputFieldsValidationState.put("lastName", false);
		inputFieldsValidationState.put("dateOfBirth", false);
		inputFieldsValidationState.put("address", false);
		inputFieldsValidationState.put("phoneNumber", false);
		inputFieldsValidationState.put("email", false);
		inputFieldsValidationState.put("officeAddress", false);
		inputFieldsValidationState.put("title", false);
		inputFieldsValidationState.put("yearsOfService", false);
	}
	
	public boolean validateInput(String inputName, String inputValue) {
		switch(inputName) {
			case "firstName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyLattersWithCapitalWord);
			case "lastName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyLattersWithCapitalWord);
			case "dateOfBirth":
				return validateDate(inputName, inputValue, ValidationPatterns.dateFormat);
			case "officeAddress":
			case "address":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.address);
			case "phoneNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.phoneNumber);
			case "email":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.email);
			case "title":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyLetters);
			case "idCardNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.idCardNumber);
			case "yearsOfService":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.yearsOfService);
			default:
				return false;
		}
	}
}
