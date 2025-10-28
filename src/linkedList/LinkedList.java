/**
 * Program Name: LinkedList Join Implementation
 * Program Developer: Peter Uriarte
 * Program Date: Y2025 / M09 / D29
 * Program Version: v1.0.0.0 - release, codename Kinche
 * (using epoch semver —— EPOCH.MAJOR.MINOR.PATCH / marketing.breaking(can no longer use same args).new feature.fix)
 */
package linkedList;
import java.io.File;
import java.util.Scanner;
import java.util.function.Consumer;
/**
 * 
 */
public class LinkedList<T> {
//	beginning item
	private LinkedListNode<T> head;

//	root getter
	public LinkedListNode<T> getHead(){
		return head;
	}
	
//	last item
	private LinkedListNode<T> tail;
	
//	tail getter
	public LinkedListNode<T> getTail(){
		return tail;
	}
	
//	foreach function for this list
	public void traverse(Consumer<LinkedListNode<T>> fn) {
		for(LinkedListNode<T> currNode = head; currNode!=null; currNode = currNode.getNext()) {
			fn.accept(currNode);
		}
	}

//	append node directly to end
	public void appendNode(LinkedListNode<T> newNode) {
		System.out.println("Appending " + newNode.getData() + " to " + this);
//		if the list is empty (head null), set head and tail
		if(head == null) {
			System.out.println("List is empty. This will be the first element.");
			head = newNode;
			tail = newNode;
			
//			display list
			printAll();
			return;
		}
		
//		gets tail, set next, new next is now set as tail
		tail = tail.setNext(newNode);
		
//		display list
		printAll();
	}

//	add new data as node to end
	public void append(T data) {
//		create new node
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
	
//		append node
		appendNode(newNode);
	}
	
//	join lists by appending the other list to this
	public void appendList(LinkedList<T> dataList) {
		System.out.println("Appending data of " + dataList + " to the end of " + this);
		dataList.traverse((node) ->{
			this.appendNode(node);
		});
		System.out.println();
	}
	
//	display / print all nodes / data
	public void printAll() {
//		header
		System.out.println("Displaying list " + this + ":");
		
//		print list - start with '{'
		System.out.print("{ ");
		
//		for each node, print it
		traverse(node -> {
//			if the current node isn't the first, add comma
			if(node != head) {
				System.out.print(", ");
			}
			
			System.out.print(node.getData());
		});
		
//		close list with '}'
		System.out.println(" }");
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// gets the input directory.
		File inputDir = new File(System.getProperty("user.dir")+"/inputs/");

		// prints what is available in the directory.
		System.out.println("Available files in directory " + inputDir.getAbsolutePath());

		// for each filename in the input dir, print.
		for(String f : inputDir.list()) {
			System.out.println(f);
		}
		
		// prompt user for filename:
		File input = null;

		// scan console inp
		try (Scanner cnslScnr = new Scanner(System.in)) {
			// while input file has not been selected...
			while (input==null) {
				// input prompt
				System.out.println();
				System.out.println("Input file name of items and press enter");

				// see if our input directory has the exact file the user wants
				File[] results = inputDir.listFiles((File _, String name) -> name.equals(cnslScnr.nextLine()));

				// if it does, set and be free
				// case: only one match, so we have our file
				if (results.length == 1) {
					System.out.println("Caught.");
					input = results[0];
				}
				// otherwise, go again
				// case: input.length == 0 -> no match.
				// case: input.length > 1 -> shouldn't happen, since the filter is asking for .equals, and every file has a unique path/name
				else{
					System.out.println("Invalid file name or something has gone horribly wrong.");
					System.out.println("Please try again.");
				}
			}
		}

		// alright, now time to scan input
		try (
			Scanner inScn = new Scanner(input);
		) {
			while (inScn.hasNext()) {
				System.out.println(inScn.next());
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something has gone horribly wrong.");
		}

		LinkedList<String> americanFoodList = new LinkedList<>();
		
		americanFoodList.append("donut");
		americanFoodList.append("french fries");
		americanFoodList.append("hamburger");
		
		americanFoodList.printAll();
		
		LinkedList<String> chineseFoodList = new LinkedList<>();
		chineseFoodList.append("chinese donut");
		chineseFoodList.append("fried rice");
		chineseFoodList.append("dumpling");
		
		chineseFoodList.printAll();
		
		// this info was taken from wikipedia "ethiopian cuisine"
		LinkedList<String> ethiopianFoodList = new LinkedList<>();
		ethiopianFoodList.append("Wat");
		ethiopianFoodList.append("Tibs");
		ethiopianFoodList.append("Kinche");
		
		ethiopianFoodList.printAll();
		
		americanFoodList.appendList(chineseFoodList);

		americanFoodList.printAll();		
	}

}
