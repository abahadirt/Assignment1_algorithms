
public class LinearSearch {

	public static int linearSearch(int[] array, int search) {
		int size = array.length;
		for(int i=0; i<size; i++) {
			if(array[i]==search) {
				return i;
			}
		}
		return -1;
	}
	
	
}
