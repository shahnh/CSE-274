import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class tester {
	public static void main(String[] args) {
		tester sn = new tester(7);
		sn.addMember("Eamon");
		sn.addMember("Laural");
		sn.addMember("Hamil");
		sn.addMember("Zulema");
		sn.addMember("Celeste");
		sn.addMember("Rand ");
		sn.addMember("eaMon");
		sn.addMember("Tisha");
		sn.addMember("Nishil");
		sn.containsMember("Sundeep");
		sn.removeMember("Eamon");
		System.out.println(sn);
		System.out.println(getMemberCount());
		System.out.println(Arrays.toString(getMembers()));


	}
	private static int maxSize = 500; 
	private static int count = 0;
	private static ConcurrentHashMap<String, Member> storage;
	private static String[] members;

	public tester () {
		storage = new ConcurrentHashMap<>();
		members = new String[maxSize];
	}
	public tester (int maxSize) {
		this.maxSize = maxSize;
		storage = new ConcurrentHashMap<>();
		members = new String[maxSize];
	}

	public static boolean addMember(String id) {
		id = upperCase(id);
		if(count == maxSize) {
			System.out.println(id + " can not added becuase it reached max size");
			return false;
		}
		
		for(int i = 0; i < count; i++) {
			if (members[i].equals(id)) {
				System.out.println(id + " already exits in system!");
				return true;
			}
		}
		if (count <= maxSize) {
			members[count] = id;
			storage.put(id, new Member());
			count++;
			return true;
		}
		return false;
	}

	public static boolean arePals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(storage.get(id1).frnds.contains(id2) 
				&&containsMember(id1)
				&& containsMember(id2)
				&& storage.get(id2).frnds.contains(id1)) {
			return true;
		}
		return false;
	}

	public static ArrayList<String> commonPals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		ArrayList<String> commonFriends = new ArrayList<String>();
		for(String f : storage.get(id1).frnds) {
			if(storage.get(id2).frnds.contains(f))
				commonFriends.add(f);
		}
		return commonFriends;
	}

	public static boolean containsMember(String id) {
		id = upperCase(id);
		for (int i = 0; i < count; i++) {
			if (members[i].equals(id))
				return true;
		}
		System.out.println(id + " not founded!");
		return false;
	}

	public static void endPals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(storage.get(id1).frnds.contains(id2) && storage.get(id2).frnds.contains(id1)) {
			storage.get(id1).frnds.remove(id2);
			storage.get(id2).frnds.remove(id1);
			System.out.println("Successfully ended!");
		}
	}

	public static int getMemberCount() {
		return count;
	}

	public static String[] getMembers() {
		Arrays.sort(members);
		return members;
	}

	public static ArrayList<String> getPals(String id) {
		id = upperCase(id);
		Collections.sort(storage.get(id).frnds);
		return storage.get(id).frnds;
	}

	public static boolean makePals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(storage.get(id1).frnds.contains(id2) && storage.get(id2).frnds.contains(id1)) {
			return true;
		}
		if(containsMember(id1) && containsMember(id2)) {
			storage.get(id1).frnds.add(id2);
			storage.get(id2).frnds.add(id1);
			return true;
		}
		return false;
	}

	public static void removeMember(String id) {
		id = upperCase(id);
		for(int i = 0; i < count; i++ ) {
			if(id.equals(members[i])) {
				for(int j = 0; j <count; j++) {
					storage.get(members[j]).frnds.remove(id);
				}
			}
		}
		for(int i = 0; i < count; i++ ) {
			if(id.equals(members[i])) {
				for(int j = i; j<count-1; j++) {
					members[j] = members[j+1];
				}
				storage.remove(id);
				members[count-1] = null;
				count--;
				System.out.println(id + " have been removed");
				break;
			}
		}
	}

	public String toString() {
		String s = "";
		Set<String> keys = storage.keySet();
		keys = new TreeSet<String>(keys);
		for(String key: keys)
			s += (key + storage.get(key).toString() + "\n") ;
		return s;
	}

	private static String upperCase(String id) {
		String cap = id.substring(0, 1).toUpperCase() + id.substring(1).toLowerCase();
		return cap;
	}

}
