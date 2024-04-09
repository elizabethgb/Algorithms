package prog;

import java.util.Arrays;

public class Quinto {
	
	public static String[] dirReduc(String[] arr) {
		int cleanings = 0; //times of reductions
		for (int i=1; i<arr.length; i++) {
			//looking for the previous element not cleaned (replaced with "")
			int j = i-1;
			while (j>=0 && arr[j].equals("")) {
				j--;
			}
			if (j == -1) { //there aren't previous elements to compare
				continue;
			}
			String prev = arr[j];

			//checking if a cleaning has to be done
			if ((prev.equals("NORTH") && arr[i].equals("SOUTH")) ||
					(prev.equals("SOUTH") && arr[i].equals("NORTH")) ||
					(prev.equals("EAST")  && arr[i].equals("WEST")) ||
					(prev.equals("WEST")  && arr[i].equals("EAST"))) {
				arr[i] = "";
				arr[j] = "";
				cleanings++;
			}
		}
		
		String[] resp = new String[arr.length-(2*cleanings)]; //new array with less elements
		int j = 0; //for resp
		for (int i=0; i<arr.length; i++) { //for arr
			if (!arr[i].equals("")) { //copying just the elements not cleaned
				resp[j] = arr[i];
				j++;
			}
		}
        return resp;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
		System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})));
	}

}
