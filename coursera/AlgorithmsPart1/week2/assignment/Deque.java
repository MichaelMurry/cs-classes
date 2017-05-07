import java.util.Iterator;
import StdOut;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int count;
	
	// construct an empty deque
	public Deque() {
		first = null;
		last = null;
		count = 0;
	}
	
	private class Node {
		Item item;
		Node next;
		Node previous; 
	}

	// is the deque empty
	public boolean isEmpty() {
		return(first == null && last == null);
	}

	// return the number of items on the deque
	public int size(){
		return count;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (isEmpty()) {
			first = new Node();
			first.item = item;
			last = first;
			count += 1;
		
		}else {
			Node oldfirst = first;
			first = new Node();
			oldfirst.previous = first; 
			first.item = item;
			first.next = oldfirst;
			count += 1;
		}
	}

	// add the item to the end
	public void addLast(Item item) {
		if (isEmpty()) {
			last = new Node();
			last.item = item;
			first = last;
			count += 1;

		}else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			oldlast.next = last;
			last.previous = oldlast;
			count += 1;
		}
	}

	// remove and return the item from the front
	public Item removeFirst() {
		checkEmpty();
		Item item = first.item;
		first = first.next;
		System.out.println(item);
		count -= 1;
		return item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		checkEmpty();
		Item item = last.item;
		last = last.previous;
		System.out.println(item);
		count -= 1;
		return item;
	}

	// check if deque is empty
	public void checkEmpty() {
		if (size() < 1) {
			throw new java.util.NoSuchElementException("Deque is empty, can't perform operation");
		}
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() { 
			return (current != null); 
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	// unit testing 
	public static void main(String[] args) {
		Deque<Integer> tst = new Deque<Integer>();
		
		tst.addLast(1);
		tst.addFirst(2);
		tst.addLast(3);
		tst.addFirst(4);

		for (Integer i : tst)
			StdOut.println(i);
		// tst.removeFirst();
		// tst.removeFirst();
		// tst.removeFirst();
		// tst.removeFirst();
		// tst.removeFirst();
		// tst.size();


		// tst.removeFirst();



		// tst.addLast("me");
		// tst.addLast("There");
		// tst.removeLast();
		// tst.removeFirst();

		// tst.addLast("Hi");
		// tst.addLast("poop");
		// tst.removeFirst();
		// tst.removeFirst();


	}



}