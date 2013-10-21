import java.util.Random;
import java.util.Arrays;


public class stackTester { 

    public static void main(String[] args) {

	IntStack is = new IntStack(10);
	Random gen = new Random();
	//fill the array with ints at each spot
	is.push(4);is.push(5);is.push(6);is.push(7);is.push(8);
	is.push(9);is.push(10);
	int output = is.pop();
      	System.out.println(output);
     
	//this is the test for printstack:
	System.out.println("116: The stack is: " + is.printstack());

	//this is the test for peek of the stack:
	int test = is.ranPeek();
	System.out.println("test of peek at random depth: " + test);

	//test for reverse
        int[] test2 = is.reverse();
      	System.out.println("reverse: " + Arrays.toString(test2));
	
	//tests for ascending/descending
	is.sortdescending();
	int [] outputall = is.popAll();
	System.out.println("descending is: " + Arrays.toString(outputall));
	for(int i=0; i<8; i++) { is.push(gen.nextInt(40)); }
	is.sortascending();
	outputall = is.popAll();
	System.out.println("ascending is: " + Arrays.toString(outputall));
	
	//tests for popall:
	is.push(3);
	is.push(2);
	is.push(1);
	outputall = is.popAll();
	System.out.println("popAll is: " + Arrays.toString(outputall));

	//tests for print:
	is.push(3);
        is.push(2);
	is.push(1);
	is.print();

	/*tests for sort fucntions*/
	is.sortdescending();
	while(!is.isEmpty() )
	    {
	       int output2 = is.pop();
		System.out.println(output2);
	    }

	//tests for popall:
	is.push(3);
	is.push(2);
	is.push(1);
	int[] outputall2 = is.popAll();


	//test for number count
	is.popAll();
	is.push(1);
	is.push(1);
	is.push(1);
	is.push(2);
	is.push(4);
	int num = 1;
	int one = is.numberCount(num);
	System.out.println("Number of "+num+"'s: "+ one); //should print out 3 (yay it works!)

	//test for posprinter 
	is.posprinter();


    }//close main

}//close public class
