import java.util.Random;

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

    int peek() {
	return stack[top-1];//show the top spot
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
    }


 }
