
public class QuickSort {
	public static void quickSort(int[] array, int low, int high) {
		int stackSize = high - low + 1;
		int[] stack = new int[stackSize];
		int top= -1;
		stack[++top] = low;
		stack[++top] = high;
		int pivot; //ek
		while(top >= 0) {
			high = stack[top--];
			low = stack[top--];
			pivot= partition(array,low,high);
			if(pivot - 1 > low) {
				 stack[++top] = low;
				 stack[++top] = pivot - 1;
			 }
			if(pivot + 1 < high) {
				stack[++top] = pivot + 1;
				stack[++top] = high;
			}
		}
		
		
		
			
	}
	
	public static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		
		for(int j = low; j < high; j++ ) {
			if(array[j] <= pivot) {
				i++;
				swap(array,i,j);
			}
		}
		swap(array,i+1,high);
		return i+1;	
	}
	
	
	
	
	
	
	
	
	
	public static void swap(int[] array, int i, int j) {
		int temp= array[i];
		array[i]= array[j];
		array[j]= temp;
	}
}
