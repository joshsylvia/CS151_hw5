
public class Connnect4 {

	public static void main(String[] args) {
		if (Integer.parseInt(args[0]) < Integer.parseInt(args[1])) {
			System.out.println("Incorrect run"); 
			System.exit(0);
			}
		if ( args.length == 2 ) {
			Connect4GUI connect = new Connect4GUI(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		} else {
			System.out.println("Please enter command in this format: java -jar Connect4.jar  <boardsize> <numToWin>");
		}
	}
}