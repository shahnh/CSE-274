
public class Tester4 {
	public static void main(String[] args) {

		String[] nmonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int[] ndays={31,29,31,30,31,30,31,31,30,31,30,31};

		String inMS = "Jan";
		int inD = 6;
		int inY = 2018;

		String outMS = "Jan";
		int outD = 1;
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
		int diffY = 0;

		int difM = (inM - outM);
		if(inM == outM && inY+1 == outY) {
			inWhileY++;
			difM += 12;
		}
		if(difM < 0) {
			difM *= -1;
		}
		if(inM > outM) {
			difM = 12 - difM;
			inWhileY++;
		}
		if(inM < outM)
			difM = difM;


		diffY += outY-inWhileY;
		int diffM = diffY * 12 + difM;
		
		System.out.println(diffM);
		
		for(int i = 0; i<diffM; i++) {
			countdays += ndays[inM];
			inM++;
			if(inM == 12)
				inM = 0;
		}

		System.out.println(countdays);
	}

}
