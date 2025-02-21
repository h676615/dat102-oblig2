package no.hvl.dat102.stabel.adt;

import java.util.EmptyStackException;

public class LenketStabel<T> implements StabelADT<T> {

	private Node topNode;
	
	public LenketStabel() {
		topNode = null;
	}
	
	@Override
	public void push(T newEntry) {
		topNode = new Node(newEntry, topNode);
	}

	@Override
	public T pop() {
		if(topNode == null) {
			throw new EmptyStackException();
		}
		T top = topNode.data;
		topNode = topNode.neste;
		return top;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			return topNode.data;
		}
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;

	}

	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this(data, null);
		}

		private Node(T data, Node neste) {
			this.data = data;
			this.neste = neste;
		}
	}
}
