/**
 * 
 */
package linkedList;
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
			return;
		}
		
//		gets tail, set next, new next is now set as tail
		tail = tail.setNext(newNode);
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
		
		LinkedList<String> ethiopianFoodList = new LinkedList<>();
		ethiopianFoodList.append("Wat");
		ethiopianFoodList.append("Tibs");
		ethiopianFoodList.append("Kinche");
		
		ethiopianFoodList.printAll();
		
		americanFoodList.appendList(chineseFoodList);

		americanFoodList.printAll();		
	}

}
