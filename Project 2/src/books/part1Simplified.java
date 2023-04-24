
/**
 * This class reads and generates the texts files free of syntax errors
 */
package books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class part1Simplified {
	private  String[] arr1;
	private  String line="";
	private  String[] tempArrTitle=null;
	protected static int[] counter=new int[9];
	/**
	 * Method that reads the input text files
	 */
	public void filesArray1() {
		System.out.println("Greetings to the corrector and others");
		System.out.println("_____________________________________________________________________________________________");
		System.out.println("This program has been designed and written by Kevin Alfredo Jimenez Recinos                 |");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println();
Scanner sc = null;
System.out.println("This are the files that have been provided:");
		try {
			 sc = new Scanner(new FileInputStream("Assg3_Needed_Files/Part1_input_file_names.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The File was not found");
			
		}
		int a = Integer.parseInt(sc.nextLine());
		
		arr1 = new String[a];
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i]=sc.nextLine();
			System.out.println(i+" "+arr1[i]);
		}
		sc.close();
		
	}
	/**
	 * This method searches the files from source files and check which can be open to the corresponding names
	 * and the ones that cannot be open. Then uses if statements and flags too, check for syntax errors and
	 * if there is syntax error it throws its respective exception and writes in syntaxe error text file, and wrote
	 * the files on their respective category without syntax errors.
	 */
	public void filesArray2() {
		System.out.println("Openning files and detecting which cannot be open: ");
		Scanner sc = null;
		PrintWriter pw = null;
		
		
		//String[] arr3= {"title", "authors", "price", "isbn", "genre", "year"};
		String[] fileNames= {"Part1/Cartoons_Comics.csv.txt", "Part1/Hobbies_Collectibles.csv.txt", "Part1/Movies_TV_Books.csv.txt",
				"Part1/Music_Radio_Books.csv.txt","Part1/Nostalgia_Eclectic_Books.csv.txt", "Part1/Old_Time_Radio_Books.csv.txt", 
				"Part1/Sports_Sports_Memorabilia.csv.txt", "Part1/Trains_Planes_Automobiles.csv.txt"};
		for(int q=0; q<fileNames.length;q++) {
		new File(fileNames[q]).delete();
		
		}
		new File("Part1/syntax_error_file.txt").delete();		
		for(int i=0; i<arr1.length;i++) {
			String name = arr1[i];
			String tempName= "Assg3_Needed_Files/"+name;
		try {
			sc = new Scanner(new FileInputStream(tempName));
		
			pw = new PrintWriter(new FileOutputStream("Part1/syntax_error_file.txt",true));
			pw.println("Syntax error in file: "+name);
			pw.println("====================");
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The File \""+name+"\" does not exist");
			continue;
		}
		
		while(sc.hasNextLine()) { 
			boolean flagTitleMissing=false;boolean flagAuthorsMissing=false;boolean flagPriceMissing=false;
			boolean flagIsbnMissing=false;boolean flagGenreMissing=false;boolean flagYearMissing=false;
			boolean flagTooFewFields=false;boolean flagTooManyFields=false;boolean flagUnknownGenre=false;
			
			boolean ccb =false; boolean hcb=false; boolean mtv=false; boolean mrb=false; boolean neb=false;
			boolean otr =false; boolean ssm=false; boolean tpa=false;
		line=sc.nextLine();
		line=line.concat(" ");
		if(line.charAt(0)!='"') {
			String s = " ";
			line=s.concat(line);
		String[] test= line.split(",");
		if(test.length<6) {	
			flagTooFewFields=true;
		}
		else if(test.length==6) {
			
				int flag=0;
				
				if(test[0].equals(" ")||test[0].equals("")||test[1].equals(null)||test[0].isBlank()||test[0].isEmpty()) {
					flagTitleMissing=true;
				}
				if(test[1].equals(" ")||test[1].equals("")||test[1].equals(null)||test[1].isBlank()||test[1].isEmpty()) {
					flagAuthorsMissing=true;
				}
				if(test[2].equals(" ")||test[2].equals("")||test[1].equals(null)||test[2].isBlank()||test[2].isEmpty()) {
					flagPriceMissing=true;
				}
				if(test[3].equals(" ")||test[3].equals("")||test[1].equals(null)||test[3].isBlank()||test[3].isEmpty()) {
					flagIsbnMissing=true;
				}
				if(test[4].equals(" ")||test[4].equals("")||test[1].equals(null)||test[4].isBlank()||test[4].isEmpty()) {
					flagGenreMissing=true;
					flag++;
				}
				if(test[5].equals(" ")||test[5].equals("")||test[1].equals(null)||test[5].isBlank()||test[5].isEmpty()) {
					flagYearMissing=true;
				}
			 if(test[4].trim().equalsIgnoreCase("CCB")&&flag==0) {
					ccb=true;
				}
			 else if(test[4].trim().equalsIgnoreCase("HCB")&&flag==0) {
					hcb=true;		
				}
			 else if(test[4].trim().equalsIgnoreCase("MTV")&&flag==0) {
					mtv=true;		
				}
			 else if(test[4].trim().equalsIgnoreCase("MRB")&&flag==0) {
					mrb=true;
				}
			 else if(test[4].trim().equalsIgnoreCase("NEB")&&flag==0) {
					neb=true;
				}
			 else if(test[4].trim().equalsIgnoreCase("OTR")&&flag==0) {
					otr=true;
				}
			 else if(test[4].trim().equalsIgnoreCase("SSM")&&flag==0) {
					ssm=true;
				}

			 else if(test[4].trim().equalsIgnoreCase("TPA")&&flag==0) {
					tpa=true;
				}
			 else if (ccb==false&&hcb==false&&mtv==false&&mrb==false&&neb==false&&otr==false&&ssm==false&&tpa==false&&flag==0){
					flagUnknownGenre=true;
				}
			}
			
		if(test.length>6) {
				flagTooManyFields=true;
			}
		if(flagTitleMissing==true|| flagAuthorsMissing==true || flagPriceMissing==true||flagIsbnMissing==true
				|| flagGenreMissing==true||flagYearMissing==true||flagTooFewFields==true||flagTooManyFields==true||
					flagUnknownGenre==true) {
			try {
				pw = new PrintWriter(new FileOutputStream("Part1/syntax_error_file.txt",true));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			if(flagTitleMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"title");
				}
			}
			if(flagAuthorsMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"authors");
				}
			}
			if(flagPriceMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"price");
				}
			}
			if(flagIsbnMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"ISBN");
				}
			}
			if(flagGenreMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"genre");
				}
			}
			if(flagYearMissing==true) {
				try{throw new MissingFieldException();
				}
				catch(MissingFieldException e) {
					pw.println(e.getMessage()+"year");
				}
			}
			if(flagTooFewFields==true) {
				try{throw new TooFewFieldsException();
				}
				catch(TooFewFieldsException e) {
					pw.println(e.getMessage());
				}
			}
			if(flagTooManyFields==true) {
				try{throw new TooManyFieldsException();
				}
				catch(TooManyFieldsException e) {
					pw.println(e.getMessage());
				}
			}
			if(flagUnknownGenre==true) {
				try{throw new UnknownGenreException();
				}
				catch(UnknownGenreException e) {
					pw.println(e.getMessage());
				}
			}
				pw.print("Record: ");
				String tempPrint2 = Arrays.toString(test);
				pw.println(tempPrint2.replace(tempPrint2.substring(tempPrint2.length() - 1), "").replace(tempPrint2.substring(0,1),""));
				pw.println();
				pw.close();
				counter[8]+=1;
			}
			if(flagTitleMissing==false&& flagAuthorsMissing==false && flagPriceMissing==false&&flagIsbnMissing==false
					&& flagGenreMissing==false&&flagYearMissing==false&&flagTooFewFields==false&&flagTooManyFields==false&&
					flagUnknownGenre==false) {
					if(ccb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[0],true));
							counter[0]+=1;
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
					else if(hcb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[1],true));
							counter[1]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(mtv==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[2],true));
							counter[2]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(mrb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[3],true));
							counter[3]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(neb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[4],true));
							counter[4]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(otr==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[5],true));
							counter[5]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(ssm==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[6],true));
							counter[6]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}else if(tpa==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[7],true));
							counter[7]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					String tempPrint2 = Arrays.toString(test);
					pw.println(tempPrint2.replace(tempPrint2.substring(tempPrint2.length() - 1), "").replace(tempPrint2.substring(0,1),""));
					pw.close();
				}
		}
			else {
				String s = " ";
			int t = line.indexOf("\"",1);
			tempArrTitle= new String [1];
			tempArrTitle[0]= line.substring(0, t+1);
			String temp2= line.substring(t);
			int p= temp2.indexOf(",",0);
			String temp3= temp2.substring(p+1);
			
			temp3=s.concat(temp3);
			String[] test= temp3.split(",");
			
			
			if(test.length<5) {	
				flagTooFewFields=true;
			}
			
			
			else if(test.length==5) {
				
				String v=tempArrTitle[0].trim().substring(1, tempArrTitle[0].length()-1);
				
				int flag=0;
				
				if(v.equals("\" \"")||v.equals("\"\"")||v.equals(null)||v.isBlank()||v.isEmpty()) {
					flagTitleMissing=true;
				}
				if(test[0].equals(" ")||test[0].equals("")||test[1].equals(null)||test[0].isBlank()||test[0].isEmpty()) {
					flagAuthorsMissing=true;
				}
				if(test[1].equals(" ")||test[1].equals("")||test[1].equals(null)||test[1].isBlank()||test[1].isEmpty()) {
					flagPriceMissing=true;
				}
				if(test[2].equals(" ")||test[2].equals("")||test[1].equals(null)||test[2].isBlank()||test[2].isEmpty()) {
					flagIsbnMissing=true;
					flag++;
				}
				if(test[3].equals(" ")||test[3].equals("")||test[1].equals(null)||test[3].isBlank()||test[3].isEmpty()) {
					flagGenreMissing=true;
					
				}
				if(test[4].equals(" ")||test[4].equals("")||test[1].equals(null)||test[4].isBlank()||test[4].isEmpty()) {
					flagYearMissing=true;
				}
			 if(test[3].trim().equalsIgnoreCase("CCB")&&flag==0) {
					ccb=true;
				}
				if(test[3].trim().equalsIgnoreCase("HCB")&&flag==0) {
					hcb=true;		
				}
				if(test[3].trim().equalsIgnoreCase("MTV")&&flag==0) {
					mtv=true;		
				}
				if(test[3].trim().equalsIgnoreCase("MRB")&&flag==0) {
					mrb=true;
				}
				if(test[3].trim().equalsIgnoreCase("NEB")&&flag==0) {
					neb=true;
				}
				if(test[3].trim().equalsIgnoreCase("OTR")&&flag==0) {
					otr=true;
				}
				if(test[3].trim().equalsIgnoreCase("SSM")&&flag==0) {
					ssm=true;
				}
				if(test[3].trim().equalsIgnoreCase("TPA")&&flag==0) {
					tpa=true;
				}
				if (ccb==false&&hcb==false&&mtv==false&&mrb==false&&neb==false&&otr==false&&ssm==false&&tpa==false&&flag==0){
					flagUnknownGenre=true;
				}
			}
			if(test.length>5) {
				flagTooManyFields=true;
			}
			if(flagTitleMissing==true|| flagAuthorsMissing==true || flagPriceMissing==true||flagIsbnMissing==true
					|| flagGenreMissing==true||flagYearMissing==true||flagTooFewFields==true||flagTooManyFields==true||
						flagUnknownGenre==true) {
				try {
					pw = new PrintWriter(new FileOutputStream("Part1/syntax_error_file.txt",true));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(flagTitleMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"title");
					}
				}
				if(flagAuthorsMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"authors");
					}
				}
				if(flagPriceMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"price");
					}
				}
				if(flagIsbnMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"ISBN");
					}
				}
				if(flagGenreMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"genre");
					}
				}
				if(flagYearMissing==true) {
					try{throw new MissingFieldException();
					}
					catch(MissingFieldException e) {
						pw.println(e.getMessage()+"year");
					}
				}
				if(flagTooFewFields==true) {
					try{throw new TooFewFieldsException();
					}
					catch(TooFewFieldsException e) {
						pw.println(e.getMessage());
					}
				}
				if(flagTooManyFields==true) {
					try{throw new TooManyFieldsException();
					}
					catch(TooManyFieldsException e) {
						pw.println(e.getMessage());
					}
				}
				if(flagUnknownGenre==true) {
					try{throw new UnknownGenreException();
					}
					catch(UnknownGenreException e) {
						pw.println(e.getMessage());
					}
				}
					pw.print("Record: ");
					String tempPrint2 = Arrays.toString(test);
					String tempPrint3= Arrays.toString(tempArrTitle);
					pw.println(tempPrint3.replace(tempPrint3.substring(tempPrint3.length() - 1), "").replace(tempPrint3.substring(0,1),"")+", "+tempPrint2.replace(tempPrint2.substring(tempPrint2.length() - 1), "").replace(tempPrint2.substring(0,1),""));
					pw.println();
					pw.close();
					counter[8]+=1;
				}
				if(flagTitleMissing==false&& flagAuthorsMissing==false && flagPriceMissing==false&&flagIsbnMissing==false
					&& flagGenreMissing==false&&flagYearMissing==false&&flagTooFewFields==false&&flagTooManyFields==false&&
					flagUnknownGenre==false) {
					if(ccb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[0],true));
							counter[0]+=1;
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
					else if(hcb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[1],true));
							counter[1]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(mtv==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[2],true));
							counter[2]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(mrb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[3],true));
							counter[3]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(neb==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[4],true));
							counter[4]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(otr==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[5],true));
							counter[5]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					else if(ssm==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[6],true));
							counter[6]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}else if(tpa==true) {
						try {
							pw = new PrintWriter(new FileOutputStream(fileNames[7],true));
							counter[7]+=1;
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
					}
					String tempPrint2 = Arrays.toString(test);
					String tempPrint3= Arrays.toString(tempArrTitle);
					pw.println(tempPrint3.replace(tempPrint3.substring(tempPrint3.length() - 1), "").replace(tempPrint3.substring(0,1),"")+", "+tempPrint2.replace(tempPrint2.substring(tempPrint2.length() - 1), "").replace(tempPrint2.substring(0,1),""));
					pw.close();
				}
		}
		}
		}
					sc.close();
					pw.close();
	}

}
