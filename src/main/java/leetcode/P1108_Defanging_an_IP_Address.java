package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1108_Defanging_an_IP_Address {

	public static void main(String[] args) {
		P1108_Defanging_an_IP_Address obj = new P1108_Defanging_an_IP_Address();
		String answer = obj.defangIPaddr("1.1.1.1");
		System.out.println(answer);
	}

	public String defangIPaddr(String address) {
		Pattern pattern = Pattern.compile("\\.");
		Matcher matcher = pattern.matcher(address);
		address = matcher.replaceAll("[.]");

		return address;
	}

}
