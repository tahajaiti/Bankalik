package util;

import java.util.regex.Pattern;

public final class AccountValidator {

	private static final Pattern CODE_PATTERN = Pattern.compile("^CPT-\\d{5}$");

	private AccountValidator() {
	}

	public static boolean isValidCode(String code) {
		return code != null && CODE_PATTERN.matcher(code).matches();
	}

	public static boolean isValidUsername(String username) {
		return username != null && !username.trim().isEmpty();
	}

}
