/**
* This class is an implementation 
* of a singly linked list node
* 
*/


public class ListNode {
	private int data;
    private ListNode next;
 
    
    // initialize empty
    public ListNode() {
    	this.next = null;
    	this.data = 0;
    }
 
    // initialize and set value
    public ListNode(int data) {
    	this.next = null;
    	this.data = data;
    }
 
    // initialize, set value and next node
    public ListNode(int data, ListNode next) {
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
    public void setData(int data) {
    	this.data = data;
    }
 
    // return the data value
    public int getData() {
        return data;
    }
}
