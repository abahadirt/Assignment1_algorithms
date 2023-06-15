
public class SelectionSort {

	public static void selectionSort(int[] array, int size) {
		for(int i=0; i<size-1; i++) {
			int min= i;
			for(int j=i+1; j<size; j++) {
				if(array[j]<array[min]) {
					min=j;
				}	
			}
			if(min!=i) {
				swap(array,min,i);
			}
		}
	}
	
	
	public static void swap(int[] array, int i, int j) {
		int temp= array[i];
		array[i]= array[j];
		array[j]= temp;
	}
	
}
