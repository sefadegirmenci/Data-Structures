/**
* This class is an implementation 
* of a singly linked list node
* 
*/


public class ListNode {
   private char data;
   private ListNode next;
 
    
    // initialize empty
    public ListNode() {
    	this.next = null;
    	this.data = 0;
    }
 
    // initialize and set value
    public ListNode(char data) {
    	this.next = null;
    	this.data = data;
    }
 
    // initialize, set value and next node
    public ListNode(char data, ListNode next) {
        this.next = next;
    	this.data = data;
    }

    // link the next node
    public void setNext(ListNode next) {
    	this.next = next;
    }
 
    // get the linked node
    public ListNode getNext() {
        return this.next;
    }
 
    // change the data value 
    public void setData(char data) {
    	this.data = data;
    }
 
    // return the data value
    public char getData() {
        return data;
    }
}
