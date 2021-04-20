import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PrQueue {
    
	public static void printPlayersById(Player[] queue) {
		Player[] copy = queue;
		Arrays.sort(copy, new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p1.id - p2.id;
			}
		});
		for (Player player : copy) {
			System.out.println(player);
		}
	}
	
	/* num_players = number of players
	 * portion = portion of points passed from the player with the most points to the one with the least
	 * min_points = minimum of the initital points range
	 * max_points = max of the initial points range
	 * rounds = number of rounds to play 
	 */
	public static void playGame(int num_players, double portion, int min_points, int max_points, int rounds, int seed) {
		Random rand = new Random(seed);
		// your code goes here
		
		ArrayPriorityQueue min_heap=new ArrayPriorityQueue(true,num_players);
		ArrayPriorityQueue max_heap=new ArrayPriorityQueue(false,num_players);
		
		/* Generate players and put them in the heaps*/
		for(int player_num=0;player_num<num_players;player_num++)
		{
			int max_bound=max_points-min_points;
			int points = rand.nextInt(max_bound)+min_points;
			Player new_player=new Player(player_num,points);
			max_heap.addElement(new_player);
			min_heap.addElement(new_player);
		}
		
		/*Rounds*/
		for(int round_num=0;round_num<rounds;round_num++)
		{
			int max_point=max_heap.getArray()[0].points;
			int min_point=min_heap.getArray()[0].points;
			int offset=(int) (max_point*portion);
			
			max_point=max_point-offset;
			min_point=min_point+offset;
			
			/*Change the values*/
			max_heap.getArray()[0].points=max_point;
			min_heap.getArray()[0].points=min_point;
			
			/*In order to do upHeap, we need locations on the other heap*/
			int min_loc=min_heap.getArray()[0].getMaxLocation();
			int max_loc=max_heap.getArray()[0].getMinLocation();
			
			max_heap.upHeap(min_loc);
			max_heap.downHeap();
			
			min_heap.upHeap(max_loc);
			min_heap.downHeap();

			System.out.println((round_num+1)+"th");
		Player []temp=new Player[num_players];
		for(int i=0;i<num_players;i++)
		{
			temp[i]=max_heap.getArray()[i];
		}
		printPlayersById(temp);
		
    	}
		
		}
		
		/*I could directly send max_heap.getArray() to the printing function but it changes the array structure, thereby I wanted to preserve my heap array as client might want to add some other elements & rounds after printing */
		

	public static void main(String[] args) {
        	playGame(5, 0.3, 0, 100, 4, 15);
	}

}
