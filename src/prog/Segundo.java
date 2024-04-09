package prog;

public class Segundo {
	
	public static String spinWords(String sentence) {
		
		//split the sentence in an array
		String[] words = sentence.split(" ");
		for (int i=0; i<words.length; i++) {
			String word = words[i];
			int length = word.length();
			if (length >= 5) {
				//reverse the word
				
				//option one:
				/*StringBuilder aux = new StringBuilder();
				for (int j=length-1; j>=0; j--) {
					aux.append(String.valueOf(word.charAt(j)));
				}*/
				
				//option two:
				StringBuilder aux = new StringBuilder(word);
				aux.reverse();
				words[i] = aux.toString();
			}	
		}
		
		//re-join the sentence
		StringBuilder resp = new StringBuilder();
		for (String word : words) {
			resp.append(word);
			resp.append(" ");
		}
		
		return resp.toString().substring(0, resp.length()-1);
	 }

	public static void main(String[] args) {
		System.out.println(spinWords("Abcde Bcde Cdefg Defghi Ef Fghijkl Ghi"));
		//System.out.println(spinWords("Welcome"));
		//System.out.println(spinWords("Hey fellow warriors"));

	}

}
