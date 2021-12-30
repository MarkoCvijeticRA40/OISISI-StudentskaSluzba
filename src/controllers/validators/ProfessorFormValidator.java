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
		inputFieldsValidationState.put("idCardNumber", false);
		inputFieldsValidationState.put("yearsOfService", false);
	}
	
	public void validateInput(String inputName, String inputValue) {
		switch(inputName) {
			case "firstName":
				validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
				break;
			case "lastName":
				validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabets);
				break;
			case "dateOfBirth":
				validateDate(inputName, inputValue, ValidationPatterns.dateFormat);
				break;
			case "officeAddressStreet":
			case "addressStreet":
				validateWithRegex(inputName, inputValue, ValidationPatterns.anything);
				break;
			case "officeAddressCity":
			case "addressCity":
			case "officeAddressCountry":
			case "addressCountry":
				validateWithRegex(inputName, inputValue, ValidationPatterns.onlyAlphabetsWithWhiteSpace);
				break;
			case "officeAddressHouseNumber":
			case "addressHouseNumber":
				validateWithRegex(inputName, inputValue, ValidationPatterns.number);
				break;
			case "phoneNumber":
				validateWithRegex(inputName, inputValue, ValidationPatterns.phoneNumber);
				break;
			case "email":
				validateWithRegex(inputName, inputValue, ValidationPatterns.email);
				break;
			case "idCardNumber":
				validateWithRegex(inputName, inputValue, ValidationPatterns.idCardNumber);
				break;
			case "yearsOfService":
				validateWithRegex(inputName, inputValue, ValidationPatterns.number);
				break;
		}
	}
}
