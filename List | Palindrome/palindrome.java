import java.util.Scanner;

public class palindrome {

	// Use this function to get nth element on the list
	public static int getElement(ListNode temp, int n) {
		for (int i = 0; i < n; i++) {
			if (temp.getNext() != null) {
				temp = temp.getNext();
			}
		}
		return temp.getData();
	}


	public static boolean isPalindromeRestricted(ListNode head) {

		// check whether head is null or not
		if (head == null)
			return false;
		else {
			ListNode temp = head;

			// get element number in the list
			int count = 1;
			while ((temp.getNext()) != null) {
				count++;
				temp = temp.getNext();
			}

			// it is to check whether palindrome or not
			boolean palindrome = true;

			// middle point of the list
			int n = count / 2;

			temp = head;
 
			// I had a trouble when it comes to middle point of even numbers so using
			// divide/conquer
			if (count % 2 == 0) {
				for (int i = 1; i <= n; i++) {
					if (getElement(temp, n - i) != getElement(temp, n + i - 1)) { // we start by comparing middle point
																					// and the number before the middle
																					// point for example: 1 3 3 2 , we
																					// compare 3,3 and 1,2
						palindrome = false;
					}
				}

			}

			else {
				for (int i = 1; i <= n; i++) {
					if (getElement(temp, n - i) != getElement(temp, n + i)) { // odd numbers are easy, we just compare i
																				// th offset from middle point
						palindrome = false;
					}

				}

			}
			return palindrome;
		}

	}


	public static boolean isPalindromeUnrestricted(ListNode head) {
		if (head == null)
			return false;

		else {
			// we don't want to lose our original list's head
			ListNode tempHead = head;

			// reverse our list through creating another list
			ListNode reverseHead = new ListNode(tempHead.getData());
			ListNode nextNode = reverseHead;
			if (tempHead.getNext() != null) {
				nextNode.setNext(new ListNode(tempHead.getNext().getData()));
				nextNode = nextNode.getNext();
			}
			ListNode previous = null;
			reverseHead.setNext(previous);
			while (tempHead.getNext() != null) {

				tempHead = tempHead.getNext();
				previous = reverseHead;
				reverseHead = nextNode;

				if (tempHead.getNext() != null) {
					nextNode.setNext(new ListNode(tempHead.getNext().getData()));
					nextNode = nextNode.getNext();
				}

				reverseHead.setNext(previous);

			}

			// control both lists inputs -- it is basically comparing our original list from
			// starting front and end(by reversed list)
			boolean palindrome = true;
			while (head.getNext() != null) {
				if (head.getData() != reverseHead.getData())
					palindrome = false;
				head = head.getNext();
				reverseHead = reverseHead.getNext();
			}
			return palindrome;

		}
	}

	// Prints LinkedList, given the head of the list (if needed for testing)
	public static String listToString(ListNode head) {
		String result = "";
		if (head != null) {
			result += head.getData();
		}

		while (head.getNext() != null) {
			head = head.getNext();
			result += " -> " + head.getData();
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ListNode head = null;
		ListNode current = null;

		// reads integer tokens from the console and constructs a LinkedList from them
		String line = scan.nextLine();

		scan.close();
		scan = new Scanner(line);

		while (scan.hasNextInt()) {
			int value = scan.nextInt();
			if (head == null) {
				head = new ListNode(value);
				current = head;
			} else {
				current.setNext(new ListNode(value));
				current = current.getNext();
			}
		}

		System.out.println(listToString(head));
		System.out.println(isPalindromeUnrestricted(head));

		System.out.println(isPalindromeRestricted(head));

		scan.close();
	}

}
