
/**
 * This class takes the files created in part one, and check for semantic errors
 * if there is semantic errors it throws its corresponding Exception and writes in 
 * semantic error text file, and takes the good text files and creates an array of books 
 * corresponding to its own genre, and wites it in a binary(serialization) file.
 */
package books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class part2Optimized extends part1Simplified {
	private static String str="";
	protected static int[] finalCounter={0,0,0,0,0,0,0,0,0};
	protected static String[] fileNamesPart2=new String[9];
	protected static String[] fileNamesDisplay=new String[9];
	//private Book book;
	private Book[] bookArr;
	/**
	 * The filesArray3() method reads the syntax error free text files, and checks for semantic errors, and
	 * throws the exceptions needed, after that it puts the good text files on a Book[] which will be serialized.
	 * To create this Book array the updateArray(Book[] arr, int capacity,Book b) method will be used and then, this 
	 * object array is serialized
	 */
	public void filesArray3() {
		String[] arrPart2={"Cartoons_Comics.csv.txt", "Hobbies_Collectibles.csv.txt", "Movies_TV_Books.csv.txt"
				, "Music_Radio_Books.csv.txt", "Nostalgia_Eclectic_Books.csv.txt", "Old_Time_Radio_Books.csv.txt"
				, "Sports_Sports_Memorabilia.csv.txt", "Trains_Planes_Automobiles.csv.txt"};
		
		String[] arrPart2Temp={"Cartoons_Comics.csv", "Hobbies_Collectibles.csv", "Movies_TV_Books.csv"
				, "Music_Radio_Books.csv", "Nostalgia_Eclectic_Books.csv", "Old_Time_Radio_Books.csv"
				, "Sports_Sports_Memorabilia.csv", "Trains_Planes_Automobiles.csv"};
		String []tempFileNames=new String[9];
		for(int s=0; s<arrPart2Temp.length;s++) {
			tempFileNames[s]="Part2/"+arrPart2Temp[s]+".ser";
		}
		tempFileNames[8]="Part2/semantic_error_file.txt";
		for(int s=0; s<tempFileNames.length;s++) {
			new File(tempFileNames[s]).delete();
			
		}
		new File(tempFileNames[8]).delete();
		System.out.println();
		System.out.println("This is the size(number of lines) and name of the files for part 1: ");
		for(int i=0; i<arrPart2.length;i++) {
		System.out.println(arrPart2[i]+": "+counter[i]);
		}
		System.out.println("Number of syntax errors: "+ counter[8]);
		Scanner sc = null;
		PrintWriter pw = null;
		fileNamesPart2[8]="Part2/semantic_error_file.txt";
		fileNamesDisplay[8]="semantic_error_file.txt";
		
		for(int i=0; i<arrPart2.length;i++) {
			bookArr=new Book[1];
				String name = arrPart2[i];
				int t = name.indexOf(".",1);
				String name2= name.substring(0, t+1);
				String tempName= "Part1/"+name;
				String tempNameSer = "Part2/"+name2+"csv.ser";
				String tempNameSer2=name2+"csv.ser";
				fileNamesPart2[i]=tempNameSer;
				fileNamesDisplay[i]=tempNameSer2;
			
				try {
					sc = new Scanner(new FileInputStream(tempName));
					pw = new PrintWriter(new FileOutputStream("Part2/semantic_error_file.txt",true));
					pw.println("Syntax error in file: "+name);
					pw.println("====================");
					pw.close();
				} catch (FileNotFoundException e) {
					System.out.println("The File \""+name+"\" does not exist");
					continue;
				}
				while(sc.hasNextLine()) {
					str=sc.nextLine();
					boolean flagYear=false;
					boolean flagIsbn10=false;
					boolean flagIsbn13=false;
					boolean flagIsbn2=false;
					boolean flagPrice=false;
					String[] check = str.split(",");
					int p = check.length;
					long a = 0;
					int b = 0;
					int type=0;
					/**
					 * Checks is year is one of the valid values
					 */
					try {
						String st1 = check[p-1].trim();
					a = Long.parseLong(st1);
					} catch(InputMismatchException e) {	
						flagYear=false;
					}
					if (a>=1995&&a<=2010) {
						flagYear=true;
					}
					/**
					 * Check's if id different type of ISBN are valid
					 */
						String isbn = check[p-3].trim();
						type = isbn.length();
						if(type==10||type==13) {
						 
								if(type==10) {								
									int sum = 0;									 
							        for (int x = 0; x < isbn.length(); x++) {
							            char ch = isbn.charAt(x);					
							            if (Character.isDigit(ch)) {
							            	
							            	sum=sum+(10-x)*Character.getNumericValue(ch);
							            }
							            else if(ch=='X') {
							            	sum +=(10-x)*10;
							            }
							            else {
							                flagIsbn10=false;
							                flagIsbn2=true;
							                break;
							            }
							        } 
								if(flagIsbn2==false) {
									int x = sum%11;
									if (x==b) {
										
										flagIsbn10=true;
										flagIsbn13=true;
									}
									else {
										flagIsbn10=false;
										flagIsbn13=false;
									}
								}
						}
								else if(type==13){
									int sum = 0;									 
						        for (int x = 0; x < isbn.length(); x++) {
						            char ch = isbn.charAt(x);					
						            if (Character.isDigit(ch)) {
						            	if(x%2==0) {
						            	sum=sum+Character.getNumericValue(ch);
						            	}
						            	if(x%2!=0) {
						            		sum=sum+(3*Character.getNumericValue(ch));
						            	}
						            	}
						            else if(ch=='X') {
						            	if(x%2==0) {
						            		sum += 10;
							            	}
						            	
						            	if(x%2!=0) {
						            		sum += (3*10);
						            	}
						            }
						            else {
						                flagIsbn13=false;
						                flagIsbn2=true;
						                break;
						            }
						        } 
									if(flagIsbn2==false) {
										int x = sum%10;
										if (x==b) {
											flagIsbn13=true;
											flagIsbn10=true;
										}
										else {
											flagIsbn13=false;
											flagIsbn10=false;
										}
									}
								}
							
						}
						else if(type!=10||type!=13) {
							flagIsbn13=false;
							flagIsbn10=false;
							type=-1;
						}
					/**
					 * Check's if price is valid
					 * 
					 */
						double price=0;
						try {
							price = Double.parseDouble(check[p-4].trim());
						}
						catch(InputMismatchException  e) {
							flagPrice=false;
						}
						if(price>0) {
							flagPrice=true;
						}
						else if(price<0) {
							flagPrice=false;
						}
					if(flagYear==false||flagPrice==false||flagIsbn10==false||flagIsbn13==false) {
						try {
							pw= new PrintWriter(new FileOutputStream("Part2/semantic_error_file.txt",true));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						if(flagYear==false) {
							try{
								throw new BadYearException();
							}
							catch(BadYearException e){
								pw.println(e.getMessage());
							}
						}
						if(flagPrice==false) {
							try{
								throw new BadPriceException();
							}
							catch(BadPriceException e){
								pw.println(e.getMessage());
							}
						}
						if(flagIsbn10==false&&type==10) {
							try{
								throw new BadIsbn10Exception();
							}
							catch(BadIsbn10Exception e){
								pw.println(e.getMessage());
							}
						}
						if(flagIsbn13==false&&type==13) {
							try{
								throw new BadIsbn13Exception();
							}
							catch(BadIsbn13Exception e){
								pw.println(e.getMessage());
							}
						}
						if(flagIsbn13==false&&flagIsbn10==false&&type==-1) {
							try{
								throw new BadIsbn10Exception();
							}
							catch(BadIsbn10Exception e){
								pw.println(e.getMessage());
							}
							try{
								throw new BadIsbn13Exception();
							}
							catch(BadIsbn13Exception e){
								pw.println(e.getMessage());
							}
						}
						String tempPrint = Arrays.toString(check);
						finalCounter[8]+=1;
						pw.println("Record: "+tempPrint.replace(tempPrint.substring(tempPrint.length() - 1), "").replace(tempPrint.substring(0,1),""));
						pw.println();
						pw.close();
					}
					if(flagYear==true&&flagPrice==true&&flagIsbn10==true&&flagIsbn13==true) {
						finalCounter[i]+=1;
						if(str.charAt(0)!='"') {
							String[] test= str.split(",");
							Book book = new Book(test[0].trim(),test[1].trim(),Double.parseDouble(test[2].trim()),test[3].trim(),test[4],Integer.parseInt(test[5].trim()));
							updateArray(bookArr, finalCounter[i],book);
						}
						else {
							String[] tempArrT=null;
							int t1 = str.indexOf("\"",1);
							tempArrT= new String [1];
							tempArrT[0]= str.substring(0, t1+1);
							String temp2= str.substring(t1);
							int p1= temp2.indexOf(",",0);
							String temp3= temp2.substring(p1+1);
							String[] test= temp3.split(",");
							Book book = new Book(tempArrT[0].trim(),test[0].trim(),Double.parseDouble(test[1].trim()),test[2].trim(),test[3].trim(),Integer.parseInt(test[4].trim()));
							updateArray(bookArr, finalCounter[i],book);
						}
					}	
				}
				FileOutputStream fileOut=null;
				ObjectOutputStream oos =null;
				try {
					fileOut = new FileOutputStream(tempNameSer,true);
					oos = new ObjectOutputStream(fileOut);
					oos.writeObject(bookArr);
					oos.close();
					fileOut.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.out.println();
		System.out.println("This is the size(number of lines) and name of the files for part 2: ");
		for(int j=0; j<finalCounter.length;j++) {
			System.out.println(fileNamesDisplay[j]+": "+finalCounter[j]);
		}
	}
	/**
	 * The updateArray(Book[] arr, int capacity,Book b) method, creates a temporary array that copies original array,
	 * and adds the new book created in that iteration.
	 * @param arr is a book[] that was created with different book objects
	 * @param capacity is the counter of the type of books
	 * @param b is the new
	 * @return
	 */
	public Book[] updateArray(Book[] arr, int capacity,Book b) {
		Book[] tempArr1= new Book[capacity];
		for(int i=0; i<arr.length;i++) {
			tempArr1[i]=arr[i];
		}
		tempArr1[capacity-1]=b;
		bookArr=tempArr1;
		return bookArr;
		}
}