/**
 *
 */
package linkedList;

/**
 *
 */
public class LinkedListNode<T> {

    private T data;

	// data getter
    public T getData() {
        return data;
    }

	// ref to next node
    private LinkedListNode<T> next;

	// next getter
    public LinkedListNode<T> getNext() {
        return next;
    }
	// sets next node
	// returns next node to allow chains

    protected LinkedListNode<T> setNext(LinkedListNode<T> n) {
        next = n;
        return n;
    }

	// base constructor
    public LinkedListNode(T d) {
        data = d;
    }

	// constructor with next option
    public LinkedListNode(T d, LinkedListNode<T> n) {
        this(d);
        next = n;
    }

	// creates new node in front, the former next becomes the next node of the new next node
    protected void newNodeInFront(T d) {
        next = new LinkedListNode<>(d, next);
    }
}
