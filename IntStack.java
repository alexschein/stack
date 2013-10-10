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

    //random push by lindsay
    void pushRandom(int ran){
	ran = gen.nextInt(9);
	stack[top++]=ran; //put random numbers into the stack 
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
	return stack[--top];
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

    //counts the number of number given in the int stack
    //Anna Hirschorn
    int count = 0;
    int numberCount(int num){
	for(int i=0; i<=top; i++){
	    if(stack[i]==num) count++;
	}
	return count;
    }

    int peek() {
	return stack[top-1];//show the top spot
    }
   
    /*
     *author: Emma
     */
    // void sortdescending() {
    //	Arrays.sort(stack, 0, top);
    // }

    void print(){
	System.out.println(stack[top]); 
	System.out.println(stack[top-1]); 
	System.out.println(stack[top-2]); //printing spots in the stacks
    }

    public static void main(String[] args) {
	//	int num = Integer.parseInt(args[0]);

	IntStack is = new IntStack(10);
	//fill the array with ints at each spot
	is.push(4);is.push(5);is.push(6);is.push(7);is.push(8);
	is.push(9);is.push(10);
	int output = is.pop();
      	System.out.println(output);
     
	//this is the test for peek of the stack:
	int test = is.ranPeek();
	System.out.println("test of peek at random depth: " + test);

	//test print function:
	System.out.println("print test:");
	is.print();

	//tests for popall:
	is.push(3);
	is.push(2);
	is.push(1);
	int[] outputall = is.popAll();
	System.out.println(Arrays.toString(outputall));

	/*tests for sort fucntions*/
    	is.sortdescending();
    	while(!is.isEmpty() )
	{
	    int output = is.pop();
	    System.out.println(output);
        }

	//test for number count
	is.popAll();
	is.push(1);
	is.push(1);
	is.push(1);
	is.push(2);
	is.push(4);
	int one = is.numberCount(1);
	System.out.println(one); //should print out 3 (yay it works!)
    }
 }
