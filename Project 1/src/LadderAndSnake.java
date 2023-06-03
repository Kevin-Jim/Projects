
/**
 * @author Kevin
 * General comment:
 * The LadderAndSnake class is where all the methods for this game to work can be found. This game was designed in a
 * multiple players, but was limited only to two maximum. Disclaimer the methods of this class are able to handle
 * any amount of players, meaning that it can be more than 2 players but has been restricted to two players.
 * Therefore we have to create a parameterized constructor that will take the number of players and if it is above
 * two players set the game and start it with two players. Different methods were created, such as throwing a 
 * random dice, picking players order, creating a 2d array for the board to display the position of the players, etc. 
 * All the methods and more were then used in the play method which is the inner logic of the game, and makes sure to
 * follow all the rules in the snake and ladder game.
 */
public class LadderAndSnake {
	private static int players;
	private static boolean flag;
	private static String[][] board;
	private static int diceRoll;
	private static int [][] snakes;
	private static int[][] ladders;
	private  static String[][] nbPlayers;
	private static int[] sumMemory;
	private static int [] positions;
	private static int start;
	private static int end;
	private static int  nbTries;
	/**
	 * This parameterized constructor has been created to initialize the different arrays
	 * and variables that each player will use to save their progress in the game, in other 
	 * words it will give the length to the array and the name of the players and will save
	 * the numbers of players that will play.
	 * Moreover it will also check for the number of players and do the different cases
	 * that was asked such as when more less or equal to 2 players.
	 * @param This take the number of players as a parameter
	 */
	LadderAndSnake(int nbPlay){
		LadderAndSnake.players = nbPlay;
		int i=0;
		if(players==2) {
			System.out.println(players +" players have been selected to play the game.");
			nbPlayers=new String [players][4];
			positions=new int[players];
			sumMemory=new  int[players];
			for( i=0;i<players;i++) {
				nbPlayers[i][0]="P"+(i+1);
				nbPlayers[i][2]="0";
				sumMemory[i]=0;
				nbTries=1;
			}
			System.out.println();
				for( i=0;i<players;i++) {
				System.out.println("This is Player "+(i+1)+" named: "+nbPlayers[i][0]);
				}
			}
		if(players<2) {
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit.");
			flag=true;
		}
			if(players>2) {	
				System.out.print("Initialization was attempted for " + players+ " member of players; however, be carefoul a too large amount of players");
				System.out.print("will make the game difficult to finish is better to choose between 4-6 players");
					System.out.println();
				nbPlayers=new String [players][4];
				positions=new int[players];
				sumMemory=new  int[players];
					for(i=0;i<players;i++) {
					nbPlayers[i][0]="P"+(i+1);
					nbPlayers[i][2]="0";
					sumMemory[i]=0;
					nbTries=1;
					}
					System.out.println();
					for( i=0;i<players;i++) {
						System.out.println("This is Player "+(i+1)+" named: "+nbPlayers[i][0]);
						}	
			}
	}
/**
 * This method uses the random from the math function to give us a random number from 1 to 6.
 * @return the diceRoll. 
 */
	public static int flipDice() {
		 diceRoll = (int)(Math.random()*6 )+1;
		return diceRoll;	
	}
	/**
		 * The Board method uses if statements and for loops to create a 2D array which
		 * is the board of this game it uses the odd and even rows to put the numbers in the
		 * board in the correct order as in the game board sample.
		 * @returns the board of the game which all of the squares in the correct order
		 */
	public static void Board() {	
		board = new String[10][10];
		int i = 0;
		int rows=0;
		while(rows<10) {
			if( rows%2==0) { 
				for( i=rows;i<board.length;i++) {
				board[i][0]=""+i+"";		
			
					for(int j=0;j<board.length;j++) {
						if(j<9) {
							board[i][j]=i+""+(j+1);
						}
						else {
					board[i][j]=(i+1)+"0";
						}
					}
				}
			}
			if(rows%2!=0) {
				for( i=rows;i<rows+1;i++) { 
					board[i][0]=""+(i+1)+"0";
						for(int j=1;j<10;j++) 
							board[rows][j]=i+""+(10-j);
								}
				}
				++rows;
				i=rows;
				}
	}					
		/**
		 * The printBoard Method will print the table with the numbers and the players position, and print all
		 * the numbers in the board array.
		 * @return the printed board with the player positions, with the help of the printPlayers method,
		 * that updated each players position in function of their sum(this will be explained after)
		 */
	public static void printBoard() {
		boolean difBoard=false;
		Board();
		for(int a=0;a<players;a++) { 
		printPlayers(a);
			if(sumMemory[a]==100) {
			difBoard=true;
			}
		}
		if(difBoard==true) {
			for( int x=9;x>=9;x--) {
				System.out.println();
				System.out.printf("%5s","| "+board[9][0]+" |");
				for(int y=1;y<board.length;y++)
					System.out.printf("%5s","| "+board[x][y]+" |");
					for( x=8;x>=0;x--) {
						System.out.println();
						for(int y=0;y<board.length;y++)
							System.out.printf("%5s","| "+board[x][y]+" |");
					}
				}
		}
		if(difBoard==false) {
			for( int x=9;x>=9;x--) {
				System.out.printf("%5s","|"+board[9][0]+" |");
				for(int y=1;y<board.length;y++)
					System.out.printf("%5s","| "+board[x][y]+" |");
					for( x=8;x>=0;x--) {
						System.out.println();
						for(int y=0;y<board.length;y++)
							System.out.printf("%5s","| "+board[x][y]+" |");
					}
				}
			}
		System.out.println();
	}
	/**
	 * The play() method is the core of this game, it uses the methods that were written in this class
	 * and uses them in the play() method, this where the logic of the game (put the checkSnakes, checkLadders, if one
	 * player lands in another player, and other methods in a logical way so the game works as it is intended)
	 * are arranged in a easier way and helps to see how the game works in the inside. Thus this method is the
	 * one who contains the while loops and verify that the boolean flag of the game remains false until a player
	 * wins.
	 * @returns the players actions after he throws his dice and ends when a player reaches square 100
	 */
	public void play() {
		while(flag==false) {
				System.out.println();
			System.out.println("First we have to pick the player that starts, it's time to roll the dice!");
			arrangePlayers(0, players);
			IdentifyDuplicates(0,players);
				for(int i=1;i<=6;i++) {
					String sta="D"+i;
					if(searchStart(sta,0,players)!=-1) {
						defineOrderOfDuplicates(searchStart(sta,0,players),searchEnd(sta,0,players),searchEnd(sta,0,players));
					}
				}
				System.out.println("This is the final list for players position the one in the bottom starts:");
				System.out.println();
				for(int i=0; i<nbPlayers.length;i++) {
					System.out.println("Name of the Players: "+nbPlayers[i][0]+" || Dice they picked: "+ nbPlayers[i][1]);
				}
				System.out.println();
				System.out.println("The number of tries it took to decide the number of players was: "+(nbTries));
				System.out.println();
				System.out.println("Now the players can start to play in the board...Let's get ready to roll!");
			Board();
			while(flag==false) {
					for(int i=nbPlayers.length-1;i>=0;i--) {
						if(flag==false) {
							Displacement(i);
								System.out.println();
						setSnakes();
						checkSnakes(i);
						setLadders();
						checkLadders(i);
						startFromBeginning(i);
						printBoard();
						}
					}
					if(flag==false) {
						System.out.println();
						System.out.println("Game not over, flipping again");
					}
				}
			}
	}
	/**
	 * The method Displacement updates the sum after a player throws its dice.
	 * As well it checks for the sum is equal or more to 100 and 
	 * @param The int x parameter is the corresponding position of the player in the array
	 * SumMemory and the other arrays created for the player.
	 */
	public static void Displacement(int x) {
		int diceNumber= flipDice();
		sumMemory[x]=(sumMemory[x]+diceNumber);
		nbPlayers[x][3]= ""+(sumMemory[x]);
		if(sumMemory[x]<100) {
		System.out.println("\n"+nbPlayers[x][0]+" has rolled a " + diceNumber+", please move to"
				+ " square "+sumMemory[x]);
		}
		 if(sumMemory[x]==100) { 
			 System.out.println("\n"+nbPlayers[x][0]+" has rolled a " + diceNumber+", thus you have won the"
			 		+ " game please move to"
			 		+ "\nsquare "+ sumMemory[x]+ " to claim your victory!");
			 flag=true;
		 }
		 if(sumMemory[x]>100) {
			 int diff=sumMemory[x]-100;
			 sumMemory[x]=100-diff;
			 System.out.println("\n"+ nbPlayers[x][0] +" you just rolled a "+diceNumber+" meaning you went above the square 100 "
			 		+ "\nyou will have to move backward "+ diff+ " position(s) after you reach \nthe square 100, thus move to square "
					 + sumMemory[x]);
		 }
	}
	/**
	 * This method setSnakes() set a 2d Array with the number of snakes such [#Snakes][2]
	 * the 2 representing the head and tail of the snakes.
	 * Thus this setSnakes method sets 
	 */
	public static void setSnakes() {
		snakes = new int [8][2];
		snakes[0][0]=16;
		snakes[0][1]=6;
		snakes[1][0]=48;
		snakes[1][1]=30;
		snakes[2][0]=62;
		snakes[2][1]=19;
		snakes[3][0]=64;
		snakes[3][1]=60;
		snakes[4][0]=93;
		snakes[4][1]=68;
		snakes[5][0]=95;
		snakes[5][1]=24;
		snakes[6][0]=97;
		snakes[6][1]=76;
		snakes[7][0]=98;
		snakes[7][1]=78;
	}
	/**
	 * The method checkSnakes(int x), check if the sumMemory[x] of player x, is equal to one
	 * of the head of the snakes.
	 * If that is the case the sumMemory[x] is updated to the tail of the snake.
	 * @param x is the the position of a player in his array sumMemmory and nbPlayers.
	 */
	public static void checkSnakes(int x) {
		for(int i=0;i<snakes.length;i++) {
			if(snakes[i][0]==sumMemory[x]) {
				System.out.println("Oh no you just fell in a snake in square "+sumMemory[x]+"!");
				sumMemory[x]=snakes[i][1];
				nbPlayers[x][3]=""+sumMemory[x];
				System.out.println("You will move to square "+sumMemory[x]+", better luck next time!");
				System.out.println();
			}
		}	
	}
		/**
		 * This method setLadders() set a 2d Array with the number of ladders such [#Ladders][2]
		 * the 2 representing the bottom and top of the ladders. 
		 */
	public static void setLadders() {
			ladders = new int [9][2];
			ladders[0][0]=1;
			ladders[0][1]=38;
			ladders[1][0]=4;
			ladders[1][1]=14;
			ladders[2][0]=9;
			ladders[2][1]=31;
			ladders[3][0]=21;
			ladders[3][1]=42;
			ladders[4][0]=28;
			ladders[4][1]=84;
			ladders[5][0]=36;
			ladders[5][1]=44;
			ladders[6][0]=51;
			ladders[6][1]=67;
			ladders[7][0]=71;
			ladders[7][1]=91;
			ladders[8][0]=80;
			ladders[8][1]=100;
	}
	/**
	 * The method checkLadders(int x), check if the sumMemory[x] of player x, is equal to one
	 * of the ladders bottom.
	 * If that is the case the sumMemory[x] is updated to the top of the ladder.
	 * @param x is the the position of a player in his array sumMemmory and nbPlayers.
	 */
	public static void checkLadders(int x) {
		for(int i=0;i<ladders.length-1;i++) {
			if(ladders[i][0]==sumMemory[x]) {
				System.out.println("You just found a ladder in square "+sumMemory[x]+"!");
				sumMemory[x]=ladders[i][1];
				nbPlayers[x][3]=""+sumMemory[x];
				System.out.println("You will move to square "+sumMemory[x]+", keep it up!");
				System.out.println();
			}
				if(sumMemory[x]==80) {
					System.out.println("You just found a ladder in square "+sumMemory[x]+"!");
					sumMemory[x]=ladders[8][1];
					nbPlayers[x][3]=""+sumMemory[x];
					System.out.println("You will move to square "+sumMemory[x]+" and claim your victory!");
					flag=true;
				}
		}
	}	
	/**
	 * This arrangePlayers(int x, int y) method makes the players to throw a dice and 
	 * sorts them from the one with the lowest dice in the top and the one with the 
	 * highest dice in the bottom.
	 * @param x is the start position of the array
	 * @param y is the end position of the array
	 */
	public static void arrangePlayers(int x, int y) {
			for(int i=x;i<y;i++) {
				int dice = flipDice();
				nbPlayers[i][1]=""+dice+"";
				positions[i]=dice;		
			}
			 int temp = 0;
			 String temp1="";
	         for(int i=x; i <y; i++){  
	                 for(int j=(x+1); j < y; j++){  
	                          if(positions[j-1] > positions[j]){   
	                                 temp = positions[j-1];  
	                                 positions[j-1] = positions[j];  
	                                 positions[j] = temp;  
	                                 	for(int b = 0; b < 3; b++)
	                                 	{
	                                 		temp1 = nbPlayers[(j-1)][b];
	                                 		nbPlayers[j-1][b] = nbPlayers[j][b];
	                                 		nbPlayers[j][b] = temp1;
	                                 	}
	                         }  
	                 }  
	         }
	         System.out.println();
	         System.out.println("Players sorted from the one with lowest dice number to the one with the highest dice.");
	         System.out.println();
	         for( int i=x;i<y;i++) {
			 System.out.println("Player "+ nbPlayers[i][0]+" Has rolled the dice and got: "+ positions[i] );
	         }
	         System.out.println();
	}
	/**
	 * This method crosses from the start until the end positions of the array, and put a mark in 
	 * all the duplicated dice rolls.
	 * @param x1 is the start position of the array
	 * @param y1 is the end position of the array
	 */
	public static void IdentifyDuplicates(int x1, int y1) {
		for(int c=x1;c<y1-1;c++) {
 		   for(int d=y1;d>(c+1);d--) {
 			   if(nbPlayers[c][1].equals(nbPlayers[d-1][1])) {
 				  for(int x =c;x<d;x++) {
 					 nbPlayers[x][2]="D"+nbPlayers[c][1];
 				  }
 			   }
 		   }
		}
	}
	/**
	 * This method defineOrderOfDuplicates() is a recursive method to define the order of which player
	 * will start when they have repeated dices. This method was not only designed for 2 players but for any
	 * amount of players making sure every Player is ordered in function of the die he gets in comparison with
	 * the other players that got the same die in their same try. Thus this method call itself until make sure 
	 * that everyone got their just place in the game. 
	 * @param a is the searchStart() which searches for the start position of the repeated dices.
	 * @param b is the searchEnd() which searches for the position end position of the repeated dices. 
	 * @param c has the same value of b but it remains untouched through the recursive steps this allows 
	 * the recursive method to pass over a complete section of repeated dice numbers.
	 */
	public static void defineOrderOfDuplicates(int a, int b, int c) {
		System.out.println();
			System.out.println("It seems there remains players with duplicated dices");
			nbTries++;
			arrangePlayers(a,b);
			for(int i=a;i<b;i++) {
				for(int d=b;d>(i+1);d--) {
					if((nbPlayers[i][1].equals(nbPlayers[d-1][1]))) {
						for(int x =i;x<d;x++) {
		 					  nbPlayers[x][2]="D"+(nbPlayers[i][1]+nbTries);
		 					 a=searchStart(nbPlayers[x][2],0,players);
		 					 b=searchEnd(nbPlayers[x][2],0,players);
						}
			 			 		defineOrderOfDuplicates(a,b,c);
					}
				}
			}
			if(b<c&&a!=b) {
				a=b;
				b=c;
				for(int i=a;i<b;i++) { 
					for(int d=b;d>(i+1);d--) {
						if((nbPlayers[i][1].equals(nbPlayers[d-1][1]))&&(nbPlayers[i][2].equals(nbPlayers[d-1][2]))) {
							for(int x =i;x<d;x++) {
			 					 nbPlayers[x][2]="D"+(nbPlayers[i][1]+nbTries+"D");	 					  
			 					 a=searchStart(nbPlayers[x][2],0,players);
			 					 b=searchEnd(nbPlayers[x][2],0,players);
			 				  }
				 			 		defineOrderOfDuplicates(a,b,c);
						}
					}
				}
			}
			else{
				System.out.println("There is no more players with equals dices in this section of the rolled dices");	
			}
	}
	/**
	 * This method searches a string in the nbPlayers[][] array from left to right, and gives the position of the string.
	 * @param sta is what this method is searching in the array, in this case Di, where i is the number of the die that was repeated.
	 * @param x is the start of the array in this case normally it is 0, start position.
	 * @param y is the length of the array.
	 * @return position of the string or returns -1 if it doesn't found the string.
	 */
	public static int searchStart(String sta,int x, int y) {	
		
		for(int i=x;i<y;i++){    
            if(nbPlayers[i][2].equals(sta)){  
            	start=i;  	
                return start;    
            }    
        }
		return -1;    
	}
	/**
	 * This method searches a string in the nbPlayers[][] array from right to left, and gives the position of the string.
	 * @param en is what this method is searching in the array, in this case Di, where i is the number of the die that was repeated.
	 * @param x is the start of the array in this case normally it is 0, start position.
	 * @param y is the length of the array.
	 * @return position of the string or returns -1 if it doesn't found the string.
	 */
	public static int searchEnd(String en, int x, int y) {	
		for(int j=nbPlayers.length-1;j>0;j--){    
            if(nbPlayers[j][2].equals(en)){  
            	end=j+1;
                return end;    
            }    
        }
		return -1;   
	}
	/**
	 * This method will check if his new sumMemory[] is equal to another player sumMemory[], 
	 * if that is the case it will give the player that was in the square, a sumMemory of 0
	 * and also update it's nbPlayers[i][3] array to 0. 
	 * @param x is the position in the sumMemory[] array that has just played it's turn. 
	 */
	public static void startFromBeginning( int x) {
		int i=0;
		int j=0;
			for(i=0;i<players;i++) {
				if(x!=i) {
					if(sumMemory[x]==sumMemory[i]) {
						sumMemory[i]=0;
						nbPlayers[i][3]="0";
						Board();
						System.out.println("Player "+ nbPlayers[i][0]+" will start from the beginning "
								+ "as he has lost his position to player " +nbPlayers[x][0]);
						System.out.println();
						for ( i = 0; i < board.length; i++) {
				            for ( j = 0; j < board[i].length; j++) {
				                if (board[i][j].equals(""+nbPlayers[x][3]+"")) {
				                	board[i][j]=nbPlayers[x][0];
				                }
				            }
						}
					}
				}
			}
	}
	/**
	 * This method updates players position in the board, then this method is used in the printBoard method.
	 * @param x is the position of the player in the sumMemory[] array.
	 */
	public static void printPlayers(int x) {
		int i=0;
		int j=0;
		if(sumMemory[x]<10) {
			for(j=0;j<9;j++) {
				if (board[0][j].equals("0"+nbPlayers[x][3]+"")) {
					board[0][j]=nbPlayers[x][0];
				}
			}
		}
		else
		for ( i = 0; i < board.length; i++) {
            for ( j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(""+nbPlayers[x][3]+"")) {
                	board[i][j]=nbPlayers[x][0];
                } 
            }
		}
	}
}
