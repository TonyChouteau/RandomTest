import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	private Random random = null;

	public RandomTest(){
		random = new Random(); 
	}

	public static void main(String[] args) {
		test();
		multipleTest();
	}

	public static void multipleTest(){
		RandomTest rt = new RandomTest();

		int numbers = 10;
		
		for (int i=10; i<100; i++){
			int iterations = 100*i;
			System.out.println(iterations);
			int[] results = rt.mathRandom(numbers,iterations);
			//int[] results = rt.nextInt(numbers,iterations);
			//rt.display(results);

			//double mean = rt.mean(mathRandomResults);
			double mean = (double)iterations/(double)numbers;

			double[] dif = rt.getDif(results, mean);
			//rt.display(dif);
			Arrays.sort(dif);
			System.out.println(Math.abs(dif[0])>dif[dif.length-1]?Math.abs(dif[0]):dif[dif.length-1]);
			//System.out.println(rt.mean(dif));
		}
	}

	public static void test(){
		RandomTest rt = new RandomTest();

		int numbers = 10;
		int iterations = 10000000;
		
		System.out.println(iterations);
		int[] results = rt.mathRandom(numbers,iterations);
		//int[] results = rt.nextInt(numbers,iterations);
		rt.display(results);

		//double mean = rt.mean(mathRandomResults);
		double mean = (double)iterations/(double)numbers;

		double[] dif = rt.getDif(results, mean);
		rt.display(dif);
		//Arrays.sort(dif);
		//System.out.println(Math.abs(dif[0])>dif[dif.length-1]?Math.abs(dif[0]):dif[dif.length-1]);
		//System.out.println(rt.mean(dif));
	}


	public int[] mathRandom(int n, int ite){
		int[] results = new int[n];

		for (int i=0; i<n; i++){
			results[i] = 0;
		}

		for (int i=0; i<ite; i++){
			int r = (int) Math.floor(Math.random()*n);
			results[r] ++;
		}

		return results;
	}

	public int[] nextInt(int n, int ite){
		int[] results = new int[n];

		for (int i=0; i<n; i++){
			results[i] = 0;
		}

		for (int i=0; i<ite; i++){
			int r = random.nextInt(n);
			results[r] ++;
		}

		return results;
	}

	public void display(int[] results) {
		//System.out.print("\n[ ");
		for (int elt : results){
			System.out.print(elt+",");
		}
		System.out.println("");
	}

	public void display(double[] results) {
		//System.out.print("\n[ ");
		for (double elt : results){
			System.out.print(elt+",");
		}
		System.out.println("");
	}

	public double mean(int[] results) {
		int m = 0;
		for (int elt : results){
			m += elt;
		}
		return ((double) m)/((double)results.length); 
	}

	public double mean(double[] results) {
		double m = 0;
		for (double elt : results){
			m += elt;
		}
		return ((double) m)/((double)results.length); 
	}

	public double[] getDif(int[] results, double mean) {
		double[] dif = new double[results.length];

		for (int i=0; i<results.length; i++){
			dif[i] = results[i]-mean;
		}

		return dif;
	}

}