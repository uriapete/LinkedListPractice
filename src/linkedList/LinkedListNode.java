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
}
