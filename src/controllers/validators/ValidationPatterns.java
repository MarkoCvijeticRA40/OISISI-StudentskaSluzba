package controllers.validators;

import java.text.SimpleDateFormat;

public class ValidationPatterns {
	
	// REGEX
	public static final String anything = "\\S.+";
	public static final String onlyAlphabets = "[a-zA-Z]+";
	public static final String onlyAlphabetsWithWhiteSpace = "\\S[a-zA-Z\s]+";
	public static final String email = "[a-z]+[a-z0-9.]*[a-z0-9]+@[a-z]+[a-z.]*[a-z]+\\.[a-z]+";
	public static final String phoneNumber = "0[1-9]{2}/[0-9-]+";
	public static final String idCardNumber = "[0-9]{9}";
	public static final String number = "[1-9][0-9]*";
	public static final String houseNumber = "[1-9][0-9]*[a-zA-z]*";
	public static final String indexNumber = "[A-Z]+ [0-9]+/[0-9]+";
	public static final String enrollmentYear = "[1-9][0-9]{3}";
	// smerBR/BR
	//DATE
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
}
