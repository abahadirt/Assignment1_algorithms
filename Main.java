import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Main {
    public static void copyArray(int[] array) {
    	
    }
	
	
	public static void main(String args[]) throws IOException {
    	
    	
        int[] array250k = csvReader.read(args[0]);  //src/TrafficFlowDataset.csv
		
        
        
        
        //these were not necessary but they helped me take time measurements
        int[] array500 = new int[500];
		System.arraycopy(array250k, 0, array500, 0, 500);          
		int[] array1000 = new int[1000];
		System.arraycopy(array250k, 0, array1000, 0, 1000); 
		int[] array2000 = new int[2000];
		System.arraycopy(array250k, 0, array2000, 0, 2000);
		int[] array4000 = new int[4000];
		System.arraycopy(array250k, 0, array4000, 0, 4000);
		int[] array8000 = new int[8000];
		System.arraycopy(array250k, 0, array8000, 0, 8000);
		int[] array16000 = new int[16000];
		System.arraycopy(array250k, 0, array16000, 0, 16000);
		int[] array32000 = new int[32000];
		System.arraycopy(array250k, 0, array32000, 0, 32000);
		int[] array64000 = new int[64000];
		System.arraycopy(array250k, 0, array64000, 0, 64000);
		int[] array128000 = new int[128000];
		System.arraycopy(array250k, 0, array128000, 0, 128000);
		int[] array250000 = new int[250000];
		System.arraycopy(array250k, 0, array250000, 0, 250000);
		

		
        //		SEARCH
//		long totalTime=0;
//		array1000=BucketSort.bucketSort(array1000);
//		for(int i=0; i<1000;i++) {
//			int r= randomNum(array1000);
//			long start=System.nanoTime() ;
//			LinearSearch.linearSearch(array1000, r);
//			long end=System.nanoTime();
//			totalTime=totalTime+ (end-start);
//		}
//			
//		System.out.println(totalTime/1000);

        

//      SORTED ARRAY TIME MEASURE		
		SelectionSort.selectionSort(array250000, 250000);
		long start= System.currentTimeMillis();
		SelectionSort.selectionSort(array250000, 250000);
		long time =  System.currentTimeMillis()- start;
		System.out.println(time);
		
		
		
        		//REVERSE SORTED TIME MEASURE
//		array250000=BucketSort.bucketSort(array250000);
//		reverse(array250000);
//		long start= System.currentTimeMillis();
//		BucketSort.bucketSort(array250000);
//		long time =  System.currentTimeMillis()- start;
//		System.out.println(time);

        
        //		ARRAY TIME MEASURE
//		shuffle(array500);
//		long start= System.currentTimeMillis();
//		SelectionSort.selectionSort(array500, 500);
//		long time =  System.currentTimeMillis()- start;
//		System.out.println(time);		

        

			
		
        //THIS WAS USED FOR TESTING			
//		for(int i:array500)
//			System.out.print(i+" ");
		


		

        
        

		
		
		
		
    	//BELOW CREATES PNGs
        // X axis data
        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        // Create sample data for linear runtime
        double[][] yAxis = new double[3][10];
        yAxis[0] = new double[]{2021, 3326, 5645, 7692, 8950, 9135, 10669,  13366, 18635, 31965};
        yAxis[1] = new double[]{2200, 3074, 6215, 7619, 8374, 15157, 27280, 33005, 44150, 49487};
        yAxis[2] = new double[]{984, 889, 804, 819 ,1004, 961, 1155, 887, 906, 952};
        // Save the char as .png and show it
        showAndSaveChart("Search", inputAxis, yAxis,
        		"Linear Search (Random)","Linear Search (Sorted)","Binary Search");
		
        double[][] yAxis2 = new double[3][10];
        yAxis2[0] = new double[]{2, 4,8,	12, 32,	96, 362,1507, 5663, 19818};
        yAxis2[1] = new double[]{1, 1,1,1, 3, 5,10,26,60,90};
        yAxis2[2] = new double[]{2,3,4,6,9,15,22,35,74,143};
        // Save the char as .png and show it
        showAndSaveChart("Random Input Data Timing Results", inputAxis, yAxis2,
        		"Selection Sort","Quick Sort","Bucket Sort");
        
        double[][] yAxis3 = new double[3][10];
        yAxis3[0] = new double[]{0,2,6,6,24,92,342,1496,5534,19537};
        yAxis3[1] = new double[]{1,3,5,11,36,132,620,2547,9461,33089};
        yAxis3[2] = new double[]{0,0,1,1,2,2,2,4 ,11,23};
        // Save the char as .png and show it
        showAndSaveChart("Sorted Input Data Timing Results", inputAxis, yAxis3,
        		"Selection Sort","Quick Sort","Bucket Sort");
        
        double[][] yAxis4 = new double[3][10];
        yAxis4[0] = new double[]{1,2,6,9,36,133,545,2162,8487,36912};
        yAxis4[1] = new double[]{1,2,4 ,6,13,21,70,305,1192,2317};
        yAxis4[2] = new double[]{0,1,1,1,2,3,3,6,15,29};
        // Save the char as .png and show it
        showAndSaveChart("Reversely Sorted Input Data Timing Results", inputAxis, yAxis4,
        		"Selection Sort","Quick Sort","Bucket Sort");
     

		
		
		
		
		
		



    }

	
	
    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis, String x,String y,String z) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle(" Measured Time: ").xAxisTitle("Input Size").build();


        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries(x, doubleX, yAxis[0]);
        chart.addSeries(y, doubleX, yAxis[1]);
        chart.addSeries(z, doubleX, yAxis[2]);
        
        

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);
       
        // Show the chart
        new SwingWrapper(chart).displayChart();

    }


    
    
    public static void shuffle(int[] array) {
       	//SHUFFLE
    	Random rand = new Random();           
    	for (int i = 0; i < array.length; i++) {
    		int randomI = rand.nextInt(array.length);
    		int temp = array[randomI];
    		array[randomI] = array[i];
    		array[i] = temp;
    	}	
    	
    	
    }
    
    public static void reverse(int[] array) {
		for(int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    public static int randomNum(int array[]) {
    	    int random = new Random().nextInt(array.length);
    	    return array[random];
    }

    
    
}
