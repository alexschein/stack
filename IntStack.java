import java.util.Random;

import java.util.Arrays;

public class IntStack {
    int[] stack;
    int top;
    Random gen = new Random();

     public IntStack(int size) {
	top=0;
	stack = new int[size];//make size that your stack can be--takes in param
    }
    
     boolean isEmpty() {
	return top==0;
    }

    void push(int num) {
	stack[top++]=num;
    }

    //peak at a random depth
    //alexschein
     int ranPeek() {
	 //pick random depth spot from stack array
	 int ran = gen.nextInt(top);
	 //return the number that is in the spot at ran
	 return stack[ran];
	
    }
    
     int pop() {
	return stack[--top];//
    }

    //Author: Anna Hirschorn
    // this method pops all the ints in the array
     int[] popAll(){
	if(isEmpty()) return new int[] {};
	return combine(new int[]{pop()}, popAll());
    }
    
    //combine method used in popall
    /*from javarevisted online*/
    public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    int peek() {
	return stack[top-1];//show the top spot
    }
   
    /*
     *author: Emma
     */
    void sortdescending() {
	//sort the stack
	Arrays.sort(stack, 0, top);
    }
     
    void sortascending() {
	//create a temporary array:
	int[] ascending = new int[stack.length];

	//sort in descending order:
	sortdescending();

	//put into the ascending array in reverse:
	for (int i=0; i<top; i++){
	    ascending[i] = stack[(top - 1) - i];
	}

	//set stack to be that array:
	stack = ascending;
    }

    public static void main(String[] args) {
	//	int num = Integer.parseInt(args[0]);

	IntStack is = new IntStack(10);
	Random gen = new Random();
	//fill the array with ints at each spot
	is.push(4);is.push(5);is.push(6);is.push(7);is.push(8);
	is.push(9);is.push(10);
	int output = is.pop();
      	System.out.println(output);
     
	//this is the test for peek of the stack:
	int test = is.ranPeek();
	System.out.println("test of peek at random depth: " + test);

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

	/*tests for sort fucntions*/
	//	is.sortdescending();
	
	//	is.sortascending();
	//	while(!is.isEmpty()){
	//   is.sortascending();
	//  output = is.pop();
	//  System.out.println(output);
	    //	}
    }
 }
