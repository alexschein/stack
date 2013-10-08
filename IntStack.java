import java.util.Arrays;

public class IntStack {
    int[] stack;
    int top;

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

    public static void main(String[] args) {
	IntStack is = new IntStack(10);
	is.push(4);
	is.push(6);
	is.push(5);
	is.push(6);
	int output = is.pop();
	System.out.println(output);

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
    }
 }
