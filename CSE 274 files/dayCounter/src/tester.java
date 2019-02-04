public class tester {
	public static void main(String[] args) {

		String[] nmonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int[] ndays={31,29,31,30,31,30,31,31,30,31,30,31};

		String inMS = "Sep";
		int inD = 5;
		int inY = 2018;

		String outMS = "Dec";
		int outD = 15;
		int outY = 2020;

		int inM = 0;
		int outM = 0;
		for(int i = 0; i<nmonths.length; i++) {
			if(nmonths[i].equals(inMS))
				inM = i;
			if(nmonths[i].equals(outMS))
				outM = i;
		}
		int difM = inM - outM;
		if(difM < 0)
			difM *= -1;
		if(inM > outM)
			difM = 13 - difM;
		if(inM < outM)
			difM = 1 + difM;

		int countMdays = 0;
		int inWhileM = inM;
		int inWhileY = inY;
		int i = 0;
		do {
			countMdays += ndays[inWhileM]; 
			if(inWhileM == 11 && inY == outY) {
				inWhileM = -1;
			}
			else if(inWhileM == 11 && ((inY +1) == outY)) {
				inWhileM = -1;
//				outY--;
			}
			else if(inWhileM == 11) {
				inWhileM = -1;
				inY++;
			}
			i++;
			inWhileM++;
		} while((i < difM));


		int minusD = (inD - 1) + (ndays[outM] - outD);
		countMdays = countMdays-minusD +((outY-inY)*366);
		
		System.out.println(countMdays);
	}
}
