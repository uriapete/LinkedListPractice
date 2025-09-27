/**
 * 
 */
package linkedList;

/**
 * 
 */
public class LinkedListNode<T> {
	T data;
	
//	ref to next node
	LinkedListNode<T> next;
	
//	base constructor
	public LinkedListNode(T d){
		data = d;
	}
	
// 	constructor with next option
	public LinkedListNode(T d, LinkedListNode<T> n) {
		new LinkedListNode<T>(d);
		next = n;
	}
	
//	sets next node
	protected void setNext(LinkedListNode<T> n) {
		next = n;
	}
	
//	creates new node in front, the former next becomes the next node of the new next node
	protected void newNodeInFront(T d) {
		next = new LinkedListNode<T>(d, next);
	}
}
