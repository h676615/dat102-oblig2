package no.hvl.dat102.stabel.adt;

public interface StabelADT <T> {
	
	public void push(T newEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
}
