package prog;

public class Primero {

	public static int powInt(int a, int b) {
		int resp = 1;
		for (int i=1; i<=b; i++) {
			resp *= a;
		}
		return resp;
	}
	
	public static boolean isNarcissistic(int number) {
	      int i = 1;
	      int digits = 0;
	      while (number/i >= 1) {
	        i *= 10;
	        digits++;
	      }
	      int sum = 0;
	      int aux = number;
	      i = 1;
	      while (i<=digits && sum<=number) {
	        sum += powInt(aux%10,digits);
	        aux /= 10;
	        i++;
	      }
	      return (sum == number);
	    }

	public static void main(String[] args) {
		System.out.println(isNarcissistic(112));

	}

}
