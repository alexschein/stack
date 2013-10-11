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

    //random push
    void pushRandom(int ran){
	ran = gen.nextInt(9);
	stack[top++]=ran; //put random numbers into the stack 
    }

    //peak at a random depth
     int ranPeek() {
	 //pick random depth spot from stack array
	 int ran2 = gen.nextInt(top);
	 //return the number that is in the spot at ran
	 return stack[ran2];
	
    }
    
     int pop() {
	return stack[--top];
    }

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
   
    void sortdescending() {
	Arrays.sort(stack, 0, top);
    }

    /*author Alex Schein*/
    //reverse the array in a backwards order
    int[] reverse() {
	//make the array that will have the reversed array of stack array
	int[] backwards = new int[top];

	//take the number from the last spot of the stack array and put it in the first spot of the reverse array - continue this until the reverse array is filled
	int j = 0;
	for (int i = top-1; i > 0; i--){
	    backwards[j++] = stack[i];
	}
	
	return backwards;//send out the reversed array
}

    void print(){
	System.out.println(stack[top]); 
	System.out.println(stack[top-1]); 
	System.out.println(stack[top-2]); //printing spots in the stacks
    }

    public static void main(String[] args) {

	IntStack is = new IntStack(10);
	is.push(3); is.push(4); is.push(5);
     
	//this is the test for random peek of the stack:
	int test = is.ranPeek();
	System.out.println("test of peek at random depth: " + test);

	//test print function:
	System.out.println("print test:");
	is.print();

	//test for reverse
        int[] test2 = is.reverse();
      	System.out.println("reverse: " + Arrays.toString(test2));

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
