
public class ArrayPriorityQueue {
	private boolean min_heap; //If true this priority queue represents min heap, o.w. max heap
	private int player_num;
	private Player[] heap;
	private int current_player_num;
	//create the array and some properties
	public ArrayPriorityQueue(boolean min_heap,int player_number) 
	{
		this.min_heap=min_heap;
		this.player_num=player_number;
		heap=new Player[player_number];
		current_player_num=0;
	}
	
	public void addElement(Player player)
	{
	
		heap[current_player_num]=player;
		
		heap[current_player_num].setLocation(current_player_num, min_heap);
		if(current_player_num!=0) upHeap(current_player_num);

		current_player_num++;
	}
	
	/*after addition or the change implement upheap to the specific location */
	public void upHeap(int location)
	{
		int iterator=location;
		if(min_heap)
		{
			while(!(iterator<=0))
			{
				int parent=(iterator-1)/2;
				if(heap[iterator].points<heap[parent].points)
				{
					Player swap=heap[parent];
					heap[parent]=heap[iterator];
					heap[iterator]=swap;
					
					/*Control this part*/
					heap[parent].setLocation(parent, min_heap);
					heap[iterator].setLocation(iterator, min_heap);
					
					iterator=parent;
				}
				else break;
			}
		}
		else
		{
			while(!(iterator<=0))
			{
				int parent=(iterator-1)/2;
				if(heap[iterator].points>heap[parent].points)
				{
					Player swap=heap[parent];
					heap[parent]=heap[iterator];
					heap[iterator]=swap;
					
					/*Control this part*/
					heap[parent].setLocation(parent, min_heap);
					heap[iterator].setLocation(iterator, min_heap);
					
					iterator=parent;
				}
				else break;
			}
		}
	}
	
	/* Every round we implement down heap as most minimum point increased, most maximum point decreased */
	public void downHeap()
	{
		if(min_heap)
		{
			int iterator=0;
			int left_node=2*iterator+1;
			int right_node=2*iterator+2;
			
			Player right=heap[right_node];
			Player left=heap[left_node];
			Player parent=heap[iterator];
			
			boolean swap=heap[0].points>heap[1].points||heap[0].points>heap[2].points; //If this is true, we enter while. I could use above variables but making it 0,1,2 made more understandable
			
			
			while(swap) 
			{
			
				/*Get minimum child and swap*/
				if(left.points<right.points)
				{
					heap[left_node]=parent;
					heap[iterator]=left;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[left_node].setLocation(left_node, min_heap);

					iterator=left_node;
					
				}
				else
				{
					heap[right_node]=parent;
					heap[iterator]=right;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[right_node].setLocation(right_node, min_heap);
					
					iterator=right_node;
				}
				
				left_node=2*iterator+1;
				right_node=2*iterator+2;
				
				if(right_node>player_num) break;
				
				right=heap[right_node];
				left=heap[left_node];
				parent=heap[iterator];
				
				swap=parent.points>left.points||parent.points>right.points;
			}
			if(left_node<player_num)
			{
				if(heap[left_node].points<heap[iterator].points) 
				{
					heap[left_node]=parent;
					heap[iterator]=left;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[left_node].setLocation(left_node, min_heap);
					
					iterator=left_node;
				}
			}
		}
		else
		{
			int iterator=0;
			int left_node=2*iterator+1;
			int right_node=2*iterator+2;
			
			Player right=heap[right_node];
			Player left=heap[left_node];
			Player parent=heap[iterator];
			
			boolean swap=heap[0].points<heap[1].points||heap[0].points<heap[2].points; //If this is true, we enter while. I could use above variables but making it 0,1,2 made more understandable
			
			
			while(swap) 
			{
			
				/*Get maximum child and swap*/
				if(left.points>right.points)
				{
					heap[left_node]=parent;
					heap[iterator]=left;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[left_node].setLocation(left_node, min_heap);
					
					iterator=left_node;
					
				}
				else
				{
					heap[right_node]=parent;
					heap[iterator]=right;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[right_node].setLocation(right_node, min_heap);
					
					iterator=right_node;
				}
				
				
				left_node=2*iterator+1;
				right_node=2*iterator+2;
				
				if(right_node>player_num) break;
				
				right=heap[right_node];
				left=heap[left_node];
				parent=heap[iterator];
				
				swap=parent.points<left.points||parent.points<right.points;
			}
			if(left_node<player_num)
			{
				if(heap[left_node].points>heap[iterator].points)
				{
					heap[left_node]=parent;
					heap[iterator]=left;
					
					heap[iterator].setLocation(iterator, min_heap);
					heap[left_node].setLocation(left_node, min_heap);
					
					iterator=left_node;
				}
			}
		}
	}
	
	
	public Player[] getArray(){
		return heap;
	}
	
}
