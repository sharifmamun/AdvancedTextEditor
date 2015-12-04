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
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element)
	{
		if (element == null)
			throw new NullPointerException("Null Pointer Exception");
		//if (head == null) {
		LLNode<E> placeToInsert = tail.prev;
		LLNode<E> value = new LLNode<E>(element);
		placeToInsert.next = value;
		value.next = tail;
		value.prev = placeToInsert;
		tail.prev = value;
		
		size++;

		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (head.next==null || index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is bigger than the size of the list");
		
		
		LLNode<E> result = head.next;
		for (int i=0; i<index; i++){
			result = result.next;
		}
		
		if (result != null)
			return (E) result.data;
		
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null)
			throw new NullPointerException("Null Pointer Exception");
		
		if (head.next==null || index < 0 || index > size)
			throw new IndexOutOfBoundsException("index is bigger than the size of the list");
		
		LLNode<E> result = head.next;
		for (int i=0; i<index; i++){
			result = result.next;
		}
		
		LLNode<E> placeToInsert = result.prev;
		LLNode<E> value = new LLNode<E>(element);		
		
		placeToInsert.next = value;
		value.next = result;
		value.prev = placeToInsert;
		result.prev = value;
		
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{		
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{		
		if (head.next==null || index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is bigger than the size of the list");

		LLNode<E> result = head.next;
		for (int i=0; i<index; i++){
			result = result.next;
		}
		
		LLNode<E> result1 = new LLNode<E>(null);
		LLNode<E> result2 = new LLNode<E>(null);
		
		if (index > 0) {
			result1 = result.prev;
		} else {
			result1 = head;
		}
		
		if (index < size-1) {
			result2 = result.next;
		} else {
			result2 = tail;
		}
		
		if (result != null) {
			result1.next = result2;
			result2.prev = result1;
			size--;
			return (E) result.data;
		}
		
		return null;
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
		if (element == null)
			throw new NullPointerException("Null Pointer Exception");
		
		if (head.next==null || index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is bigger than the size of the list");

		LLNode<E> result = head.next;
		for (int i=1; i<index; i++){
			result = result.next;
		}
		
		LLNode<E> value = new LLNode<E>(element);
		if (result != null) {			
			result.next =  value;
			value.prev = result;
			return (E) result.data;
		}
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
