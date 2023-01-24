// Written by: Charlie Alpert

import java.util.EmptyStackException;

public class ArrayStack implements BKStack {

    int initialCapacity = 100; //determines the original size of the array
    int index = 0; //tracks the current position in the stack
    double[] stack = new double[initialCapacity]; //initializes stack with the 0s


    //doubles the size of the array when array is full
    public void doubleArray(){
        if(index == stack.length){ //checks if stack is same size as num of elements
            double[] newStack = new double[stack.length * 2]; //creates a new empty stack twice the size

            int i = 0; //iterator to track index for replacement
            for(double element: stack){ //iterates through every value in array
                //newStack will be filled in first half and zeros for second half
                newStack[i] = element; //takes the index for replacement and adds elements from previous stack
                i++; //increment index for replacement
            }
            stack = newStack; //replaces stack with the new doubled stack
        }
    }

    //checks if stack is clear of any non 0 values
    @Override
    public boolean isEmpty() {
        if(index == 0){ //checks if index is 0 (index will start at 0 and return to 0 after all values are popped)
            return true;
        }
        return false; //otherwise false aka not empty
    }

    //adds value to stack
    @Override
    public void push(double d) {
        doubleArray(); //first checks if array needs to be doubled and does so if needed
        stack[index] = d; //imports value to next spot in array using index
        index++; // increments index to prepare for next value
    }


    //removes value from stack
    @Override
    public double pop() {
        if(isEmpty()){ //first verify if stack has a value
            throw new EmptyStackException(); //error when empty (rest of method will not execute)
        }

        index--; //decreases index to account for one less value in stack
        double pop = stack[index]; //stores current value in temp variable pop
        stack[index] = 0; //replaces current value in array with 0 (pops)
        return pop; //returns the temp popped value
    }

    //returns most recent value in stack
    @Override
    public double peek() {
        if(isEmpty()){ //first verify if stack has a value
            throw new EmptyStackException(); //error when empty (rest of method will not execute)
        }
        return stack[index - 1]; //grabs and returns value at the index - 1 in stack (where most recent value is added)
    }
}
