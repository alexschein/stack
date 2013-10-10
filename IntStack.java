import java.util.Random;
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
    Random gen=new Random();
    void pushRandom(int ran){
	ran = gen.nextInt(9);
	stack[top++]=ran; //put random numbers into the stack 
    }

    int pop() {
	return stack[--top];
    }

    int peek() {
	return stack[top-1];//show the top spot
    }
   
    void print(){
	System.out.println(stack[top]); 
	System.out.println(stack[top-1]); 
	System.out.println(stack[top-2]); //printing spots in the stacks
    }
    public static void main(String[] args) {

	IntStack is = new IntStack(10);
	is.pushRandom(4);
	is.pushRandom(5);
	is.pushRandom(6);
	int output = is.pop();
	System.out.println(output);
	is.print();
    }


 }
