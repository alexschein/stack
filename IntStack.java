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

    int peek() {
	return stack[top-1];//show the top spot
    }
   
    /*
     *author: Emma
     */
    void sortdescending() {
	//make the descending stack:
	int[] descending = new int[stack.length];
	
	//sort the stack
	Arrays.sort(stack, 0, top);
    }
     
    void sortascending() {
	//create a temporary array:
	int[] ascending = new int[stack.length];

	//sort in descending order:
	sortdescending();

	//put into the ascending array in reverse:
	for (int i=0; i<stack.length; i++){
	    ascending[i] = stack[stack.length - i];
	}

	//set stack to be that array:
	stack = ascending;
    }

    public static void main(String[] args) {
	IntStack is = new IntStack(10);
	is.push(4);
	is.push(6);
	is.push(5);

	/*tests for sort fucntions*/
	//	is.sortdescending();
	
	is.sortascending();
	while(!is.isEmpty() )
	    {
		int output = is.pop();
		System.out.println(output);
	    }
    }


 }
