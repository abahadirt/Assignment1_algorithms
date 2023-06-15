import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static int[] bucketSort(int[] array) {
		int numberOfBuckets = (int) Math.sqrt(array.length);
		
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		for (int i = 0; i < numberOfBuckets; i++) {
		      buckets[i] = new ArrayList<Integer>();
		}
		
		int max = array[0];
		for(int i=0; i<array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		for(int i=0; i<array.length; i++) {
			buckets[hash(array[i],max,numberOfBuckets)].add(array[i]);
		}
		
		for(int i = 0; i < numberOfBuckets; i++) {
			Collections.sort(buckets[i]);
		}
		int[] sortedArray = new int[array.length];
		int index = 0;
		for(int i =0; i< numberOfBuckets; i++) {
			for(int j = 0; j<buckets[i].size(); j++) {
				sortedArray[index++] = buckets[i].get(j);
			}
		}
		
		return sortedArray;
	}
	
	
	public static int hash(int i, int max, int numberOfBuckets) {
		return ( (i/max) * (numberOfBuckets-1) );
	}
	
	
	
	
	
	
	
	
	
	
}
