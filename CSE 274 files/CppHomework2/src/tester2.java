
public class tester2 {

	public static void main(String[] args) {
		String[] nmonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int[] ndays={31,29,31,30,31,30,31,31,30,31,30,31};

		String inMS = "Dec";
		int inD = 1;
		int inY = 2018;

		String outMS = "Jun";
		int outD = 30;
		int outY = 2019;

		int inM = 0;
		int outM = 0;
		for(int i = 0; i<nmonths.length; i++) {
			if(nmonths[i].equals(inMS))
				inM = i;
			if(nmonths[i].equals(outMS))
				outM = i;
		}
		int countdays = 0;
		int inWhileM = inM;
		int inWhileY = inY;

		int counterM = 1;
		if(inM == outM && inD == outD) {
			counterM = 13 * (outY-inY);
		}
		else if(inD > outD && inM == outM) {
//			while(inWhileM <= outM && (inWhileY <= outY)) {
				counterM = 13;
//				if(inWhileM == 11) {
//				++inWhileM;
//			}	
		}
		else {
		while(inWhileM != outM || (inWhileY != outY)) {
			++counterM;
			if(inWhileM == 11) {
				inWhileM = -1;
				inWhileY++;
			}
			++inWhileM;
		}
		}
		
//		if(outY > inY && outM > inM)
//		counterM += ((outY-inY) * 12);
		
		int index = inM;
		for(int i = 0; i<counterM; i++) {
			countdays += ndays[index];
			if(index == 11) 
				index = -1;
			index++;
		}
		
		int minusD = (inD - 1) + (ndays[outM] - outD);
		countdays = countdays-minusD;
		
		int modelA = countdays * 600;
		double modelB = 600;
		double interest = 1.000164;
		
		for(int a = 0; a <= countdays; a++) {
			modelB = modelB*interest;
		}

		
		System.out.println(countdays + " days have passed since the start of the project.");
		System.out.println(counterM + " months have passed since the start of the project.");
		System.out.println("Model A: $" + modelA);
		System.out.printf("Model B: $%.2f %n", modelB);

	}
}
