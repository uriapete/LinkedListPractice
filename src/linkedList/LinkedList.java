/**
 * 
 */
package linkedList;
import java.util.function.Consumer;
/**
 * 
 */
public class LinkedList<T> {
	private LinkedListNode<T> head;

//	root getter
	public LinkedListNode<T> getRoot(){
		return head;
	}
	
//	foreach function for this list
	public void traverse(Consumer<LinkedListNode<T>> fn) {
		for(LinkedListNode<T> currNode = head; currNode!=null; currNode = currNode.getNext()) {
			fn.accept(currNode);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
