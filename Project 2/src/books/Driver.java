
/**
 * @author Kevin
 * This is the driver class that implements the do_part1(), do_part2(), and
 * do_part3() methods. And that creates objects from the different classes 
 * implemented get the files, check exceptions, create binary files, read 
 * binary files, and the interactive code to navigate the objects
 */
package books;
public class Driver {
	/**
	 * This is the first part method
	 */
public static void do_part1() {
	part1Simplified p1 = new part1Simplified();
	p1.filesArray1();
		p1.filesArray2();
	}
	/**
	 * This is the second method for part Two
	 */
	public static void do_part2() {
		part2Optimized p2 = new part2Optimized();
	p2.filesArray3();
	}
	/**
	 * This is the third method for part 3
	 */
	public static void do_part3() {
		part3 p3= new part3();
		p3.Menu();
	}

	public static void main(String[] args) {
		 
			  do_part1(); // validating syntax, partition book records based on genre.
			  do_part2(); // validating semantics, read the genre files each into arrays of Book objects,
			  // then serialize the arrays of Book objects each into binary files.
			 do_part3(); // reading the binary files, deserialize the array objects in each file, and
			  } // then provide an interacive program to allow the user to navigate the arrays.

}
