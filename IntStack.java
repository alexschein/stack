import java.util.Random;
import java.util.Arrays;

public class IntStack {
    int[] stack;
    int top;
    Random gen = new Random();

     public IntStack(int size) {
	top=0;
	stack = new int[size];//make size that your stack can be--takes in param
     }//close public intstack
    
     boolean isEmpty() {
	return top==0;
     }//close isEmpty

    void push(int num) {
	stack[top++]=num;
    }//close push

    //random push
    void pushRandom(int ran){
	ran = gen.nextInt(9);
	stack[top++]=ran; //put random numbers into the stack 
    }//close pushRandom

    //peak at a random depth
     int ranPeek() {
	 //pick random depth spot from stack array
	 int ran2 = gen.nextInt(top);
	 //return the number that is in the spot at ran
	 return stack[ran2];
	
     }//close ranPeek
    
     int pop() {
	return stack[--top];
     }//close pop

    // this method pops all the ints in the array
     int[] popAll(){
	if(isEmpty()) return new int[] {};
	return combine(new int[]{pop()}, popAll());
     }//close popAll
    
    //combine method used in popall
    /*from javarevisted online*/
    public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }//close combine

    //counts the number of number given in the int stack
    //Anna Hirschorn
    int count = 0;
    int numberCount(int num){
	for(int i=0; i<=top; i++){
	    if(stack[i]==num) count++;
	}//close for loop
	return count;
    }//close numberCount

    int peek() {
	return stack[top-1];//show the top spot
    }//close peek

    //prints all the numbers in the stack and their positions
    //Anna Hirschorn and Lindsay Jadow
    void posprinter(){
	for(int i=0; i<=top; i++){
	    System.out.println("Position "+i+": "+stack[i]);
	}//close for loop
    }//close posprinter
   
    void sortdescending() {
	//sort the stack
	Arrays.sort(stack, 0, top);
    }//close sortdescending
    /*
     *author: Emma
     */ 
    void sortascending() {
	//create a temporary array:
	int[] ascending = new int[stack.length];

	//sort in descending order:
	sortdescending();

	//put into the ascending array in reverse:
	for (int i=0; i<top; i++){
	    ascending[i] = stack[(top - 1) - i];
	}//close for loop

	//set stack to be that array:
	stack = ascending;
    }//close sort ascending

    /*author Alex Schein*/
    //reverse the array in a backwards order
    int[] reverse() {
	//make the array that will have the reversed array of stack array
	int[] backwards = new int[top];

	//take the number from the last spot of the stack array and put it in the first spot of the reverse array - continue this until the reverse array is filled
	int j = 0;
	for (int i = top-1; i > 0; i--){
	    backwards[j++] = stack[i];
	}//close for loop
	
	return backwards;//send out the reversed array
    }//close reverse

    void print(){
	System.out.println(stack[top]); 
	System.out.println(stack[top-1]); 
	System.out.println(stack[top-2]); //printing spots in the stacks
    }//close print

    String printstack() {
	return Arrays.toString(stack);
    }//close printstack

    }//close class
