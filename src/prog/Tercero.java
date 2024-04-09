package prog;

public class Tercero {
	
	public static String whoLikesIt(String... names) {
        int numElements = names.length;
        StringBuilder resp = new StringBuilder();
        final String individualLike = " likes this";
        final String multipleLike = " like this";
        switch (numElements) {
        	case 0:
        		resp.append("no one")
        			.append(individualLike);
        		break;
        	case 1:
        		resp.append(names[0])
        			.append(individualLike);
        		break;
        	case 2:
        		resp.append(names[0]).append(" and ").append(names[1])
        			.append(multipleLike);
        		break;
        	case 3:
        		resp.append(names[0]).append(", ").append(names[1]).append(" and ").append(names[2])
        			.append(multipleLike);
        		break;
        	default:
        		resp.append(names[0]).append(", ").append(names[1]).append(" and ").append(numElements-2).append(" others")
        			.append(multipleLike);
        }
        return resp.toString();
    }

	public static void main(String[] args) {
		System.out.println(whoLikesIt());
		System.out.println(whoLikesIt("Peter"));
		System.out.println(whoLikesIt("Jacob", "Alex"));
		System.out.println(whoLikesIt("Max", "John", "Mark"));
		System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));

	}

}
