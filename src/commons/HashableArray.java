package commons;

import java.util.Arrays;

public class HashableArray<T> {

	private T[] a;
	
	public HashableArray(T[] a) {
		this.a = a;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HashableArray) {
			return Arrays.deepEquals(a, ((HashableArray<?>) obj).getA());
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Arrays.deepHashCode(a);
	}
	
	public HashableArray<T> clone() {
		HashableArray<T> clone = new HashableArray<>(a.clone());
		return clone;
	}
	
	public T[] getA() {
		return a;
	}
	
}
