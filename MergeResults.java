import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * create one result file from two.
 */

public class MergeResults {
	private static final String file1 = "/path/to/Slidepuzzle/result/a2494in937min.txt";
	private static final String file2 = "/path/to/Slidepuzzle/result/b.txt";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MoveCounter mc = new MoveCounter();
		int c1, c2, cs, c0;
		
		BufferedReader in1 = new BufferedReader(new FileReader(file1));
		BufferedReader in2 = new BufferedReader(new FileReader(file2));
		
		c1 = c2 = cs = c0 = 0;
		
		for (int i=0 ; i < 5000 ; i++) {
			String s1 = in1.readLine();
			String s2 = in2.readLine();
			if (s1.length() == 0 && s2.length() == 0) {
				System.out.println();
				c0++;
			}
			else if (s1.length() == 0) {
				mc.count(s2);
				c2++;
			}
			else if (s2.length() == 0) {
				mc.count(s1);
				c1++;
			}
			else if (s1.length() < s2.length()) {
				mc.count(s1);
				c1++;
			}
			else {
				mc.count(s2);
				c2++;
			}
		}
		System.err.println("a: " + c1 + " b: " + c2 + " s: " + cs + " skip: " + c0);
		System.err.println(mc.toString());
	}
	
	public static class MoveCounter {
		int cu, cd, cl, cr;
		
		MoveCounter() {
			cu = cd = cl = cr = 0;
		}
		
		public void count(String s) {
			System.out.println(s);
			for (int i = 0 ; i < s.length() ; i++) {
				switch (s.charAt(i)) {
				case 'U': cu++; break;
				case 'D': cd++; break;
				case 'L': cl++; break;
				case 'R': cr++; break;
				}
			}
		}
		
		public String toString() {
			return "U: " + cu + " D: " + cd + " L: " + cl + " R: " + cr;
		}
	}
}
