public class Player {
	/*my variables*/
	private int location_max_heap; //player's location in the max heap
	private int location_min_heap; //player's location in the min heap
	
	public int points;
	public int id;
	
	public Player(int id, int points) {
		this.id = id;
		this.points = points;
	}
	
	public String toString() {
		return "Player " + this.id + " with " + this.points + " points"; 
	}
	
	/*GETTERS AND SETTERS*/
	public void setLocation(int location,boolean min_heap)
	{
		if(min_heap) location_min_heap=location;
		else location_max_heap=location;
	}

	
	public int getMinLocation()
	{
		return location_min_heap;
	}
	
	public int getMaxLocation()
	{
		return location_max_heap;
	}
}
