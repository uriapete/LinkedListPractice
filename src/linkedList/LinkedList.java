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
//		if the list is empty (head null), set head and tail
		if(head == null) {
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
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
