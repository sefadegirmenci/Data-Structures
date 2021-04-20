public interface QueueInterface {

    /**
     * Return the first element in the queue without removing it from the queue
     *
     * @return integer value of the first element in the queue
     */
	public char front();


    /**
     * Return the first element in the queue and remove it from the queue
     *
     * @return integer value of the first element in the queue
     */
	public char dequeue();

    /**
     * Add a new integer element to the end of the queue
     */
	public void enqueue(char data);

    /**
     * Return true if there are no elements in the queue
     *
     * @return boolean value defining the emptiness of the queue
     */
	public boolean isEmpty();

    /**
     * Return the size of this queue
     *
     * @return integer value of the queue size
     */
	public int size();
	
}
