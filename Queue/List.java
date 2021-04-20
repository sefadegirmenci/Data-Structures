import java.util.Scanner;

public class List {
	
	public static void charOrderingExercise(char[] charArray) {
		Queue myQueue = new Queue();
		
		for(char element: charArray){
			if(myQueue.isEmpty()){
			myQueue.enqueue(element);
			}else{

			char front=myQueue.front();
			char currentFront;
			do{
			char value =myQueue.dequeue();
			myQueue.enqueue(value);
			currentFront=myQueue.front();
			if(currentFront==element){
				myQueue.dequeue();
			}

			}while(currentFront!=front);

			myQueue.enqueue(element);

			}
		}
		// print out the final state of the queue
		System.out.println(myQueue);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		charOrderingExercise(line.toCharArray());
		
		scan.close();
	}

}