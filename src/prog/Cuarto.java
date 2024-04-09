package prog;

import java.math.BigInteger;

public class Cuarto {
	
	public static String incrementString(String str) {
		int i = str.length()-1;
		while (i >= 0 && Character.isDigit(str.charAt(i))) {
			i--;
		}
		String resp;
		if (i == str.length()-1) {
			resp = str.concat("1");
		} else {
			StringBuilder format = new StringBuilder("%0"); //"%010d"
			format.append(str.length()-1-i).append("d");
			BigInteger num = new BigInteger(str.substring(i+1));
			num = num.add(BigInteger.ONE);
			resp = new StringBuilder(str.substring(0, i+1))
					.append(String.format(format.toString(), num))
					.toString();
		}
	    return resp;
	  }

	public static void main(String[] args) {
		System.out.println(incrementString("00123"));
		System.out.println(incrementString("foobar000"));
		System.out.println(incrementString("foobar001"));
		System.out.println(incrementString(""));
		System.out.println(incrementString("foo99"));
		System.out.println(incrementString("00000000000010379788349801487222163837"));

	}

}
