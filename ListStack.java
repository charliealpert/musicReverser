// Written by: Charlie Alpert

import java.util.EmptyStackException;
public class ListStack implements BKStack {

    //Node class to implement Linked List
    class Node{
        double data; //stores numerical value
        Node next; //points to next value in the stack

        //default constructor for empty node
        public Node(){
            next = null;
            data = 0;
        }

        //constructor to make node for stack
        public Node(double d){
            next = null;
            data = d;
        }
    }

    private Node head; //Node that will always contain most recent value in stack (top of stack)

    //checks if stack has a non null value
    @Override
    public boolean isEmpty() {
        if(head == null){ //checks if main value in stack is null
            return true; //true when all are popped or nothing has been pushed
        }
        return false; //otherwise contains value
    }

    //adds value to stack
    @Override
    public void push(double d) {
        Node pushVal = new Node(d); //creates new node with double value as data
        pushVal.next = head; //moves current head to be the next pointer (not the top value of stack anymore)
        head = pushVal; //puts new value as head/top value of stack
    }

    //removes value from stack
    @Override
    public double pop() {
        double pop = head.data; //temporarily stores the head value in pop variable
        if(isEmpty()){ //double checks that there is a value to be popped
            throw new EmptyStackException(); //exception to stop from any weird errors when null value
        }
        head = head.next; //head now becomes second value in stack (2nd in stack now becomes 1st)
        return pop; //returns temp value that is being removed
    }

    //returns most recent value in stack
    @Override
    public double peek() {
        if(isEmpty()){ //double checks that there is a value in the stack
            throw new EmptyStackException(); //exception to stop from any weird errors when null value
        }
        return head.data; //returns top stack value stored in head
    }
}
