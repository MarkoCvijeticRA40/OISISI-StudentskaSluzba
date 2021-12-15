package controllers.validators;

import java.text.SimpleDateFormat;

public class ValidationPatterns {
	
	// REGEX
	public static final String onlyLetters = "[a-zA-Z]+";
	public static final String onlyLattersWithCapitalWord = "[A-Z][a-z]+";
	public static final String address = "[a-zA-Z\s]+\s[0-9]+,\s[a-zA-Z\s]+,\s[a-zA-Z\s]+";
	public static final String email = "[a-z]+[a-z0-9.]*@[a-z]+[a-z.]*\\.[a-z]+";
	public static final String phoneNumber = "0[1-9]{2}[0-9]{6,7}";
	public static final String idCardNumber = "[0-9]{9}";
	public static final String yearsOfService = "[1-9][0-9]*";
	
	//DATE
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
}
