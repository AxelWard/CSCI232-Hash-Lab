package container;

public class Table {
	
	private int size;
	private int contained;
	private Pair[] table;
	
	Table() {
		size = 5;
		contained = 0;
		table = new Pair[5];
	}
	
	public void addData(Pair newData) {
		
		int key = newData.getKey();
		int hash = hash(key, this.size);
		
		boolean placed = false;
		
		int i = hash;
		
		while(placed == false) {
			
			if(table[i] == null) {
				table[i] = newData;
				placed = true;
				System.out.println("Placed at " + i);
				contained++;
			} else if(i < size) {
				i++;
			} else {
				i = 0;
			}
		}
		
		if ((this.contained/this.size) >= .8) {
			rehash();
		}
	}
	
	private int hash(int key, int hashSize) {
		int returnKey;
		
		returnKey = key%hashSize;
		
		return(returnKey);
	}
	
	private void rehash() {
		
		System.out.println("Rehashing");
		
		int newSize = this.size*2;
		Pair[] tempTable = new Pair[newSize];
		Pair data;
		
		for(int i = 0; i < this.size; i++) {
			if(table[i] != null) {
				data = table[i];
				int hashKey = hash(data.getKey(), newSize);
				
				boolean placed = false;
				
				while(placed == false) {
					if(tempTable[hashKey] == null) {
						tempTable[hashKey] = data;
						placed = true;
						contained++;
					} else if(i < newSize) {
						i++;
					} else {
						i = 0;
					}
				}
			}
		}
		
		table = tempTable;
		tempTable = null;
		this.size = newSize;
		
		System.out.println("Rehashed. New size is: " + size);
		}
	
	public void print() {
		for(int i = 0; i < size; i++) {
			if(table[i] != null) {
				System.out.println("ID: " + table[i].getKey() + " - Data: " + table[i].getData());
			}
		}
	}
}
