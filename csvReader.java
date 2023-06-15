import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvReader {
	
	
	public static int[] read(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName)); 
		
		
		int[] array = new int[250000];
		int i = 0;
		sc.nextLine();
		while (sc.hasNext() & i!=250000) {  
			String a = sc.nextLine().split(",")[6];
			array[i]= Integer.parseInt(a);
			i++;
		}   
		sc.close();

		
//		System.out.println("csv.Reader: OK1.");
//		SelectionSort.selectionSort(array, 250000);
//		System.out.println("csv.Reader: OK2.");


		return array;
	}
	
	
}
