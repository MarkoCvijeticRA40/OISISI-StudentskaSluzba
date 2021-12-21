package controllers.validators;

public class ProfessorFormValidator extends BaseFormValidator {
	
	public ProfessorFormValidator() {
		inputFieldsValidationState.put("firstName", false);
		inputFieldsValidationState.put("lastName", false);
		inputFieldsValidationState.put("dateOfBirth", false);
		inputFieldsValidationState.put("addressStreet", false);
		inputFieldsValidationState.put("addressHouseNumber", false);
		inputFieldsValidationState.put("addressCity", false);
		inputFieldsValidationState.put("addressCountry", false);
		inputFieldsValidationState.put("phoneNumber", false);
		inputFieldsValidationState.put("email", false);
		inputFieldsValidationState.put("officeAddressStreet", false);
		inputFieldsValidationState.put("officeAddressHouseNumber", false);
		inputFieldsValidationState.put("officeAddressCity", false);
		inputFieldsValidationState.put("officeAddressCountry", false);
		inputFieldsValidationState.put("title", false);
		inputFieldsValidationState.put("yearsOfService", false);
	}
	
	public boolean validateInput(String inputName, String inputValue) {
		switch(inputName) {
			case "firstName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
			case "lastName":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
			case "dateOfBirth":
				return validateDate(inputName, inputValue, ValidationPatterns.dateFormat);
			case "officeAddressStreet":
			case "addressStreet":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.anything);
			case "officeAddressCity":
			case "addressCity":
			case "officeAddressCountry":
			case "addressCountry":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabetsWithWhiteSpace);
			case "officeAddressHouseNumber":
			case "addressHouseNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.number);
			case "phoneNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.phoneNumber);
			case "email":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.email);
			case "title":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
			case "idCardNumber":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.idCardNumber);
			case "yearsOfService":
				return validateWithRegex(inputName, inputValue, ValidationPatterns.number);
			default:
				return false;
		}
	}
}
