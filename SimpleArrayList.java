package assignment4;

public class SimpleArrayList extends Person{
	public SimpleArrayList() {
		// Declare the initial size
		startingCapacity = 5;
		
		// Initialize the size
		size = 0;
		
		// Initialize the array
		data = new Person[startingCapacity];
	}
	
	protected Person[] data;
	protected int startingCapacity;
	protected int size;
	
	// Add at the end
	public void add(Person p) {
		// Check the capacity of the array
		if ( size >= data.length ) {
			// 1) Create a new, larger array
			Person[] tempArray = new Person[size + startingCapacity];
			
			// 2) Move the data to the new array
			for ( int i = 0; i < size; i++ ) {
				tempArray[i] = data[i];
			}
			
			// 3) Make the array variable point to the new address
			data = tempArray;
		}
		
		// Add n as a last element of the list
		data[size] = p;
		
		// Increment size, since we just added one element to the list
		size++;
		
		// Alternatively, but do NOT use both
		// data[size++] = n;
	}
	
	// Add at an index
	public void add(Person p, int i) {
		// Check the capacity of the array
		if ( size >= data.length ) {
			// Create a new, larger array
			Person[] tempArray = new Person[size + startingCapacity];
			
			// If index = 0 (beginning of array)
			if (i == 0) {
				//Set value n at index 0
				tempArray[0] = p;
				//Transfer rest of data to new array and shift index up by one
				for (int x = 1; x < size; x++) {
					tempArray[x] = data[x-1];
				}
				// Make the array variable point to the new address
				data = tempArray;
			}
			
			//If index is in middle or end of list
			if (i > 0 && i < size) {
				//Transfer data to new array until index argument 
				for (int x = 0; x < i; x++) {
					tempArray[x] = data[x];
				}
				//Set value n at index i 
				tempArray[i] = p;
				//Transfer rest of data to new array and shift index up by one
				for (int x = i+1; x < size; x++) {
					tempArray[x] = data[x-1];
				}
				// Make the array variable point to the new address
				data = tempArray;
			}
		}
		
		Person[] tempArray = new Person[data.length];
		// If index = 0 (beginning of array)
		if (i == 0) {
			//Set value n at index 0
			tempArray[0] = p;
			//Transfer rest of data to new array and shift index up by one
			for (int x = 1; x <= size; x++) {
				tempArray[x] = data[x-1];
			}
		}
		
		//If index is in middle or end of list
		if (i > 0 && i <= size) {
			//Transfer data to new array until index argument
			for (int x = 0; x < i; x++) {
				tempArray[x] = data[x];
			}
			//Set value n at index i 
			tempArray[i] = p;
			//Transfer rest of data to new array and shift index up by one
			for (int x = i+1; x <= size; x++) {
				tempArray[x] = data[x-1];
			}
		}
		// Make the array variable point to the new address
		data = tempArray;
		// Increment size, since we just added one element to the list
		size++;
	}
	
	// Get
	public Person get(int i) {
		// Check for valid index
		if ( i < 0 || i >= size ) {
			// Invalid index
			return null;
		}
		
		return data[i];
	}
	
	// Remove
	public void remove(int i) {
		// Check for valid index
		//if ( i < 0 || i >= size ) {
			// Invalid index
			//return Integer.MIN_VALUE;
		//}
		
		Person[] tempArray = new Person[data.length];
		
		//if index = 0, transfer data from index 1 and above to new array, shifting index
		if (i == 0) {
			for (int x = 1; x <= size; x++) {
				tempArray[x-1] = data[x];
			}
			
		//if index in middle or end of list
		if (i > 0 && i <= size) {
			//transfer data into new array at same index until index argument i
			for (int x = 0; x < i; x++) {
				tempArray[x] = data[x];
			}
			for (int x = i; x <= size; x++) {
				//transfer rest of data into new array, shift index down by 1
				tempArray[x] = data[x + 1];
			}
		}
		// Make the array variable point to the new address
		data = tempArray;
		// Decrement size, since removed one element from the list
		size--;
		}
	}
	
	// Get size
	public int size() {
		return size;
	}
}
