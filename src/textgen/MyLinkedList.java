package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		// Add at end
		LLNode node = new LLNode(element);
		LLNode curr = head;
		while(curr.next != tail) {
			curr = curr.next;
		}
		
		node.next = curr.next;
		node.prev = curr;
		curr.next.prev = node;
		curr.next = node;
		this.size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode node = head;
		LLNode curr = head.next;
		int count = 0;
		
		while(curr != tail && count < index) {
			count++;
			curr = curr.next;
		}
		
		return (E) curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode node = new LLNode(element);
		int count = 0;
		LLNode curr = head;
		while(curr != tail && count < index) {
			curr = curr.next;
			count++;
		}
		
		node.next = curr.next;
		node.prev = curr;
		curr.next.prev = node;
		curr.next = node;
		this.size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode curr = head;
		LLNode res;
		int count = 0;
		while(curr != tail && count < index) {
			curr = curr.next;
			count++;
		}
		
		res = curr.next;
		curr.next.next.prev = curr;		//res.next.prev = curr;
		curr.next = curr.next.next;		//curr.next = res.next;
		this.size--;
		return (E) res.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		int count = 0;
		LLNode curr = head.next;
		while(curr != tail && count < index) {
			curr = curr.next;
			count++;
		}
		E res =(E) curr.data;
		curr.data = element;
		
		return res;
	}   
	
	public void print() {
		LLNode curr= head.next;
		while(curr != tail) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
