
public class BinaryHeap {
	private int[] data;
	private int size;
	
	public BinaryHeap(){
		data = new int[10];
		size = 0;
	}
	
	private void growArray() {
		// TODO Auto-generated method stub
		int[] temp = new int[data.length*100];
		
		System.arraycopy(data, 0, temp, 0, data.length);
		data = temp;
	}

	private void swap(int curr, int parent) {
		// TODO Auto-generated method stub
		int temp = data[curr];
		data[curr] = data[parent];
		data[parent] = temp;
		
	}

	private int parent(int curr) {
		// TODO Auto-generated method stub
		if(curr == 0)
			return 0;
		return ((curr-1)/2);
	}
	
	private int right_child(int position) {
		// TODO Auto-generated method stub
		return (2 * position + 2);
	}

	private int left_child(int position) {
		// TODO Auto-generated method stub
		return (2 * position + 1);
	}
	
	public void add(int priority) {
		// TODO Auto-generated method stub
		
		if(size >= data.length)
			growArray();
		
		int curr = size;
		data[size++] = priority;
		while(data[curr] < data[parent(curr)]){
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}

	public int remove() {
		// TODO Auto-generated method stub
		int temp = data[0];
		
		if(size != 0){
			siftDown(0);
			size--;
		}
			
		
		return temp;
	}

	private void siftDown(int position) {
		// TODO Auto-generated method stub
		if (left_child(position) >= size)
			return;
		int child = left_child(position);
		if (right_child(position) < size &&
				data[right_child(position)] < data[child])
			child = right_child(position);
		if (data[child] < data[position]) {
			swap(child, position);
			siftDown(child);
		}
	}
	
}
