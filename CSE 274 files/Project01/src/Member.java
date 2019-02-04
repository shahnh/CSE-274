import java.util.ArrayList;
import java.util.Collections;

public class Member {
	public ArrayList<String> frnds;
	
	public Member() {
		frnds = new ArrayList<String>(); 
	}
	
	@Override
	public String toString() {
		Collections.sort(frnds);
		return frnds + "";
	}

}
