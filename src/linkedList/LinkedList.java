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

//	add new node to end
	public void append(T data) {
//		create new node
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		
//		if the list is empty (head null), set head and tail
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		
//		gets tail, set next, new next is now set as tail
		tail = tail.setNext(newNode);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
