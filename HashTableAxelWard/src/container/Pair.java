package container;

public class Pair {
	int key;
	String data;
	
	Pair(int newKey, String newData) {
		this.key = newKey;
		this.data = newData;
	}
	
	public int getKey() {
		return(key);
	}
	
	public String getData() {
		return(data);
	}
}
