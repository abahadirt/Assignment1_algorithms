
public class BinarySearch {

	public static int binarySearch(int[] array, int search) {
		int low = 0;
		int high = array.length -1;
		
		while(high-low>1) {
			int mid = (high + low) / 2;
			if(array[mid] < search) {
				low= mid+1;
			}
			else {
				high = mid;
			}
		}
		if(array[low]==search) {
			return low;
		}
		else if(array[high]==search) {
			return high;
		}
		return -1;
	}
	
}
