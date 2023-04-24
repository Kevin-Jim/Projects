import java.util.Scanner;

 // -----------------------------------------------------
 // Assignment (1)
 // Question: (Part 2, class Ladder And Snake)
 // Written by: (Kevin Alfredo Jimenez Recinos, ID: 40245703)
 // -----------------------------------------------------
/**
 * General comment:
 * The driver class displays what are the user input options and verify the users input as well.
 * In this case the input of the user is the number of players of the user.
 * This is the class with the main method thus this calls the object from the LadderAndSnake class.
 */
/** 
 * @author Kevin Alfredo Jimenez Recinos ID:40245703
 * This is the driver class of the game, it asks and check the users input then creates an object from the 
 * LadderAndSnake Class.
 */
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Greetings to all players, the game \"Ladders and Snakes\" will start soon!");
		System.out.println("_____________________________________________________________________________________________");
		System.out.println("This program has been designed and written by Kevin Alfredo Jimenez Recinos                 |");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("*********************************************************************************************");
	    System.out.println("|  #  >> Game options                                                                       |");
	    System.out.println("*********************************************************************************************");
	    System.out.println("|  1  >> TO quit choose a number of players less thant two                                  |");
	    System.out.println("|  2  >> To play the game, select two players                                               |");
	    System.out.println("|  3  >> If more than two players, it will start this version of the game with two players  |");
	    System.out.println("*********************************************************************************************");
		System.out.println();
		/**
		 * First we gave the user a welcome message and specified the options that he has in this case the 
		 * number of players is min/max 2.
		 * The following is an algorithm that checks the users input, such as making sure he chooses a integer 
		 * number of players, or different messages for asking for an integer number of players will be asked.
		 * When the user inputs an acceptable message the game is initialized and ends with a salutation message.
		 */
		boolean flag1=false;
		System.out.print("Please enter an integer number of players (there is a min/max of 2 players): ");
		String x =sc.nextLine();
		while(flag1==false) {
		int size =x.length();
			for(int i=0;i<size;i++) {
					if(x.charAt(i)>='0'&& x.charAt(i)<='9') {
						flag1=true;
					}
					else {
						System.out.println("This is not an integer, please try again");
						flag1=false;
						System.out.print("Please enter an integer number of players (there is a min/max of 2 players): ");
						x =sc.nextLine();
						break;
					}
			}
		}
		
		int numberOfPlayers=Integer.parseInt(x);
		System.out.println();
		
		LadderAndSnake LAS = new LadderAndSnake(numberOfPlayers);
		
		LAS.play();
		if(numberOfPlayers>=2) {
		System.out.println("\n\nEnd Of The Game.\n\nThank you for playing my Ladders and Snakes game, come back soon!");
		}
		sc.close();
		

	}

}
