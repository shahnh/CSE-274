public class tester{
	public static void main(String[] args) {
		double q = 158.0/200;
		double e1 = 92.5/125;
		double e2 = 100.0/125;
		double s1 = (q * .18 + e1* .20 + e2 * .25)/ .635;
		System.out.println(s1);
		double pred = .880; 
		double fin = .98;
		System.out.println((pred - s1) / .35);
		//System.out.println(s1);
		double s2 = (q*.18) + (e1*.20) + (e2*.25) + (fin*.35) + (.9*.02);
		System.out.println(s2*100);
	}
}