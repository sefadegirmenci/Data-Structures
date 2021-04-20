public class Queue implements QueueInterface {
	private int size;
	private ListNode front;
	private ListNode back;

	public Queue() {
		// add your code here
		front=null;
		back=null;
	}

	@Override
	public char front() {
		// add your code here
		if(front==null) return 0;
		return front.getData();
	}

	@Override
	public char dequeue() {
		// add your code here
		if(front==null){
			return 0;
		} 
		ListNode temp=front;
		if(front==back){
			front=null;
			back=null;
			size--;
			return temp.getData();
		} 
		front=front.getNext();
		temp.setNext(null);
		size--;
		return temp.getData();
	}

	@Override
	public void enqueue(char data) {
		// add your code here
		ListNode node=new ListNode(data);

		if(front==null){
			front=node;
			back=node;
			size++;
		}
		else{
			back.setNext(node);
			back=node;	
			size++;
		}
}
	@Override
	public boolean isEmpty() {
		// add your code here
		return front==null;
	}

	@Override
	public int size() {
		// add your code here
		return size;
	}
	
	// The string representation of the items in the queue
	public String toString() {
		String str = "front -> ";
		for (int i = size; i > 0; i--) {
			char value = dequeue();
			str += value + " -> ";
			enqueue(value);
		}
		return str + "back";
	}

}