package Lab_6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		int newCapacity = elements.length * 2; // Double the current capacity.
		elements = Arrays.copyOf(elements, newCapacity);
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException("Errror");

		return elements[i];

	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException("Errror");
		E previous = elements[i];
		elements[i] = e;
		return previous;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {

		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		E removedElement = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		elements[size - 1] = null; // Set the last element to null
		size--;
		return removedElement;

	}

	// It is used to clear all elements in the list.
	public void clear() {
		size = 0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = elements.length - 1; i >= 0; i--) {
			if (elements[i].equals(o)) {
				return i; // Return the index of the last occurrence of the element
			}
		}

		return -1; // Element not found in the array
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order
	public E[] toArray() {
		E[] arrayy = (E[]) new Object[elements.length];
		for (int i = 0; i < elements.length; i++) {
			arrayy[i] = elements[i];

		}
		return arrayy;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> listtt = new MyArrayList<>();
		for (int i = 0; i < size; i++) {
			listtt.add(elements[i]);
		}
		return listtt;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				;
			return true;
		}
		return false;
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				;
			return i;
		}

		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = size - 1; i > 0; i++) {
			if (elements[i].equals(e))
				;
			elements[i] = elements[i + 1];
			elements[size - 1] = null;
			size--;
			return true;
		}

		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		int n = size;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (c.compare(elements[i - 1], elements[i]) > 0) {
					// Swap elements[i-1] and elements[i]
					E temp = elements[i - 1];
					elements[i - 1] = elements[i];
					elements[i] = temp;
					swapped = true;
				}
			}
			n--;
		} while (swapped);

	}
}
