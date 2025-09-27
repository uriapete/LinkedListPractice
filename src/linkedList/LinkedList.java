/**
 * 
 */
package linkedList;
import java.util.function.Consumer;
/**
 * 
 */
public class LinkedList<T> {
	private LinkedListNode<T> root;

	public LinkedListNode<T> getRoot(){
		return root;
	}
	
	public void traverse(Consumer<LinkedListNode<T>> fn) {
		for(LinkedListNode<T> currNode = root; currNode!=null; currNode = currNode.getNext()) {
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
