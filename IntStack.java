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
	Arrays.sort(stack, 0, top);
    }

    //reverse the array in a backwards order
    int[] reverse(int[] stack) {
	//make the array that will have the reversed array of stack array
	int[] backwards = new int[stack.length];

	//fill it
	for(int i = stack.length-1; i >= 0; i--) {
	    backwards[(stack.length-1)-i] = stack[i];
	}
	
	return backwards;//send out the reversed array
    }

    public static void main(String[] args) {

	IntStack is = new IntStack(10);
     
	//this is the test for peek of the stack:
	int test = is.ranPeek();
	System.out.println("test of peek at random depth: " + test);

	System.out.println("the array: " + is);
	//test for reverse
	//     int test2 = is.reverse(stack);
	//	System.out.println("reverse: " + test2);

	/*tests for sort fucntions*/
	is.sortdescending();
	while(!is.isEmpty() )
	    {
		int output = is.pop();
		System.out.println(output);
	    }

	//tests for popall:
	is.push(3);
	is.push(2);
	is.push(1);
	int[] outputall = is.popAll();
       	System.out.println(Arrays.toString(outputall));
    }
}
