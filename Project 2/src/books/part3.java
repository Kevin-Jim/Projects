
/**
 * This class deserialize the Array of book objects of different categories and, has the code that
 * displays them in an interactive way as asked.
 */
package books;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class part3 extends part2Optimized implements Serializable{
	
	
	private static int count=finalCounter[0];
	private static String names=fileNamesDisplay[0];
	private static Book[] b=null;
	private Scanner sc1 = new Scanner(System.in);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is just a default Array of Books selected but the user can change to the
	 * the array of books that he desires
	 */
	public void defaultBook() {
		FileInputStream fis=null;
			ObjectInputStream ois=null;
			Book[] b1 =null;
		try {
			
			fis = new FileInputStream(fileNamesPart2[0]);
			ois= new ObjectInputStream(fis);
			b1= (Book[]) ois.readObject();
			fis.close();
			ois.close();
			
			b=b1;
			count=finalCounter[0];
			names=fileNamesDisplay[0];
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	}
	/**
	 * This is the subMenu to choose what file the user wants to see
	 */
	public void subMenu() {
	
		
		System.out.println("-----------------------------");
		System.out.println("        File Sub-Menu        ");
		System.out.println("-----------------------------");
		System.out.println("1 Cartoons_Comics_Books.csv.ser "+"("+finalCounter[0]+" records)\r\n"
				+ "2 Hobbies_Collectibles_Books.csv.ser ("+finalCounter[1]+" records)\r\n"
				+ "3 Movies_TV.csv.ser "+"("+finalCounter[2]+" records)\r\n"
				+ "4 Music_Radio_Books.csv.ser "+"("+finalCounter[3]+" records)\r\n"
				+ "5 Nostalgia_Eclectic_Books.csv.ser "+"("+finalCounter[4]+" records)\r\n"
				+ "6 Old_Time_Radio.csv.ser "+"("+finalCounter[5]+" records)\r\n"
				+ "7 Sports_Sports_Memorabilia.csv.ser "+"("+finalCounter[6]+" records)\r\n"
				+ "8 Trains_Planes_Automobiles.csv.ser "+"("+finalCounter[7]+" records)\r\n"
				+ "9 Exit\r\n"
				+ "------------------------------\r\n"
				+ "Enter Your Choice:");
		

		FileInputStream fis=null;
		ObjectInputStream ois=null;
		boolean flag=false;
		String inputCode="";
		inputCode=sc1.next();
		while(flag==false){
			
		if(inputCode.trim().equals("1")) {
				Book[] b1 =null;
				try {
					fis = new FileInputStream(fileNamesPart2[0]);
					ois= new ObjectInputStream(fis);
					b1= (Book[]) ois.readObject();
					fis.close();
					ois.close();
					b=b1;
					count=finalCounter[0];
					names=fileNamesDisplay[0];
					flag=true;
					break;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					}	
			
		}
		else if(inputCode.trim().equals("2")) {
			Book[] b2 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[1]);
				ois= new ObjectInputStream(fis);
				b2= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b2;
				count=finalCounter[1];
				names=fileNamesDisplay[1];
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		}
		else if(inputCode.trim().equals("3")) {
			Book[] b3 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[2]);
				ois= new ObjectInputStream(fis);
				b3= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b3;
				count=finalCounter[2];
				names=fileNamesDisplay[2];
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		
		}
		else if(inputCode.trim().equals("4")) {
			Book[] b4 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[3]);
				ois= new ObjectInputStream(fis);
				b4= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b4;
				count=finalCounter[3];
				names=fileNamesDisplay[3];
				flag=true;
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		
		}
		else if(inputCode.trim().equals("5")) {
			Book[] b5 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[4]);
				ois= new ObjectInputStream(fis);
				b5= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b5;
				count=finalCounter[4];
				names=fileNamesDisplay[4];
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		
		}
		else if(inputCode.trim().equals("6")) {
			Book[] b6 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[5]);
				ois= new ObjectInputStream(fis);
				b6= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b6;
				count=finalCounter[5];
				names=fileNamesDisplay[5];
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		
		}
		else if(inputCode.trim().equals("7")) {
			Book[] b7 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[6]);
				ois= new ObjectInputStream(fis);
				b7= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b7;
				count=finalCounter[6];
				names=fileNamesDisplay[6];
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}	
		
		}
		else if(inputCode.trim().equals("8")) {
			Book[] b8 =null;
			try {
				fis = new FileInputStream(fileNamesPart2[7]);
				ois= new ObjectInputStream(fis);
				b8= (Book[]) ois.readObject();
				fis.close();
				ois.close();
				b=b8;
				count=finalCounter[7];
				names=fileNamesDisplay[7];
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			flag=true;
		}
		else if (inputCode.trim().equals("9")) {
			flag=true;	
		}
		else if(flag==false) {
			
			System.out.println("Your input was not one the options, please try again");
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println("        File Sub-Menu        ");
			System.out.println("-----------------------------");
			System.out.println("1 Cartoons_Comics_Books.csv.ser "+"("+finalCounter[0]+" records)\r\n"
					+ "2 Hobbies_Collectibles_Books.csv.ser "+"("+finalCounter[1]+" records)\r\n"
					+ "3 Movies_TV.csv.ser "+"("+finalCounter[2]+" records)\r\n"
					+ "4 Music_Radio_Books.csv.ser "+"("+finalCounter[3]+" records)\r\n"
					+ "5 Nostalgia_Eclectic_Books.csv.ser "+"("+finalCounter[4]+" records)\r\n"
					+ "6 Old_Time_Radio.csv.ser "+"("+finalCounter[5]+" records)\r\n"
					+ "7 Sports_Sports_Memorabilia.csv.ser "+"("+finalCounter[6]+" records)\r\n"
					+ "8 Trains_Planes_Automobiles.csv.ser "+"("+finalCounter[7]+" records)\r\n"
					+ "9 Exit\r\n"
					+ "------------------------------\r\n"
					+ "Enter Your Choice:");
			inputCode=sc1.next();
			
		}
		
		
		}
		
	}
	/**
	 * The Menu() method, contains the other subparts of this class that make the interactive display
	 * to the user this the method that checks if the user wants to exit the program
	 */
	public void Menu() {
		boolean flagExit=false;
		boolean flagMenu=false;
		defaultBook();
		Scanner sc2 = new Scanner(System.in);
		
		String mainMenu="";
		while(flagExit==false){
			System.out.println("-----------------------------\r\n"
							+  "         Main Menu\r\n"
					+ "-----------------------------\r\n"
					+ "v View the selected file: "+names+" ("+count+")\r\n"
					+ "s Select a file to view\r\n"
					+ "x Exit\r\n"
					+ "-----------------------------");
			mainMenu=sc2.nextLine();
		if(mainMenu.trim().equals("v")) {
			displayRecords();
			
		}
		else if(mainMenu.trim().equals("s")) {
		subMenu();
		}
		else if(mainMenu.trim().equals("x")) {
			flagExit=true;
			System.out.println("Thank you for visiting our records");
			sc1.close();
			System.exit(0);
		}
		else {
			System.out.println("This is not one of the options please try again");
			
			
			
		}
		}
	
	}
		
	
	/**
	 * The displayRecords() method is the one that allows the user to navigate inside the Array of Books chosen by the user 
	 * and displays them to the user.
	 */
	public void displayRecords() {
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Please select a positive or negative integer(such as...,-2,-1,+1,+2,..) to display a range of records, or \"0\" to return to the Main Menu.");
		String str ="";
		boolean flag1=false;
		boolean flagTry=false;
		boolean flag3=false;
		boolean flagExit=false;
		int n = 0;
		long x =0;
		long p=0;
		 while(flagExit==false){
			 str =sc3.nextLine();
			 if(str.length()==1) {
				 if(str.charAt(0)=='0') {
					 
					 flagExit=true;
					flag1=false;
						flagTry=false;
						flag3=false;
					 break;
				 }
				 else {
					 flag1=false;
						flag3=false;
					 flagTry=true;
					 
				 }
			 }
			 if(str.length()>1) {
			 for(int i=1; i<str.length();i++){
				 
					 if(str.charAt(0)=='+') {
						 n=1;
					 }
					 else if(str.charAt(0)=='-') {
						 n=2;
					 }
					 else if((str.charAt(0)!='+')||(str.charAt(0)!='-')) {
						 flag1=false;
							flag3=false;
						 flagTry=true;
						 break;
					 }
					 if(Character.isDigit(str.charAt(i))) {
						 flag1=true;
					 }
					 if(Character.isDigit(str.charAt(i))==false) {
						 flag1=false;
						 flagTry=true;
						 break;
					 }
				 }
			 }
			 if(n==1&&flag1==true) {
				flag3= true;
				x=Long.parseLong(str.substring(1, str.length()));
				long check = b.length-p;
				if(x==1) {
					for(int i=(int) p; i<(x+p);i++) {
						System.out.println(b[i].toString());
						flagTry=false;
					}
				}
				else if(x>check) {
					
					for(int i=(int) p; i<b.length;i++) {
						System.out.println(b[i].toString());
					}
					System.out.println("EOF has been reached");
					p=b.length-1;
					flagTry=false;
				}
				else if(x<=check) {
					
					for(int i=(int) p; i<(x+p);i++) {
						System.out.println(b[i].toString());
						flagTry=false;
					}
					p+=x-1;
				}
				flag1=false;
			}
			 else if(n==2&&flag1==true) {
				flag3= true;
				x=Long.parseLong(str.substring(1, str.length()));
				long check = p;
				if(x==1) {
					for(int i=(int) p; i<(x+p);i++) {
						System.out.println(b[i].toString());
						flagTry=false;
					}
				}
				else if(x==check+1) {
					
					for(int i=0; i<=p;i++) {
						System.out.println(b[i].toString());
					}
					p=0;
					flagTry=false;
				}
				else if(x>check) {
					System.out.println("BOF has been reached");
					for(int i=0; i<=p;i++) {
						System.out.println(b[i].toString());
					}
					p=0;
					flagTry=false;
				}
				
				else if(x<=check) {
					int f= (int) (p-x+1);
					for(int i=f; i<=p;i++) {
						System.out.println(b[i].toString());
					}
					p=f;
					flagTry=false;
				}
				flag1=false;
			}
			 if(flagTry==true){
				System.out.println("This is not a valid number, please try again");
				System.out.println("Please select a positive or negative integer(such as...,-2,-1,+1,+2,..) to display a range of records, or \"0\" to return to the Main Menu.");
				
			}
			 if(flag3==true) {
				System.out.println();
				System.out.println("The Objects were displayed");
				System.out.println("Please select a positive or negative integer(such as...,-2,-1,+1,+2,..) to display a range of records, or \"0\" to return to the Main Menu.");
			}
		 }
	}
}