package assignment05;

/**
 *
 * @author CS 140
 *
 */
public class Person {
	private String firstNames;
	private String lastNames;
	private int ssn;
	/**
	 *
	 * @param firstNames
	 * @param lastNames
	 * @param ssn
	 */
	public Person(String fstNames, String lstNames, String ssnString) {
		firstNames = fstNames;
		lastNames = lstNames;
		var str = ssnString.trim().replace("-","");
		while(str.charAt(0) == '0') {
			str = str.substring(1);
		}
		try {
			ssn = Integer.parseInt(str);
		} catch(NumberFormatException ex) {
			System.out.println("Bad format for the SSN, use only digits or use '-' separators");
			throw new IllegalArgumentException("This entry is not acceptable: " + ssnString);
		}
	}
	/**
	 *
	 * @return
	 */
	public String getFirstNames() {
		return firstNames;
	}
	/**
	 *
	 * @return
	 */
	public String getLastNames() {
		return lastNames;
	}
	/**
	 *
	 * @return
	 */
	public String getSSN() {
// either
//		String str = String.format("%09d", ssn);
//		return str.substring(0,3) + "-" + str.substring(3,5) + "-" + str.substring(5);
// or
		return String.format("%03d-%02d-%04d", ssn/1000000,ssn%1000000/10000, ssn%10000);

	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(firstNames);
		sb.append(" ");
		sb.append(lastNames);
		sb.append(" (");
		sb.append(getSSN());
		sb.append(")");
		return sb.toString();
	}

}
