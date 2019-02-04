import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Homework01
 * @author Nishil Shah
 *Every methods work fine but there is a problem in the return type of commonPals and getPals. Both return ArrayList instead of array.
 */

public class PalBook{
	private int maxSize = 500; 
	private int count = 0;
	private ConcurrentHashMap<String, Member> storage;
	private String[] members;

	public PalBook() {
		storage = new ConcurrentHashMap<>();
		members = new String[maxSize];
	}
	public PalBook(int maxSize) {
		this.maxSize = maxSize;
		storage = new ConcurrentHashMap<>();
		members = new String[maxSize];
	}
	/**
	 * Adds a member to the social network. Returns true if, at the end of the method, that member is in the network, and false otherwise. Note that if the member already exists in the network, the member will not be added a second time, and the method will return true to indicate that the member is in the network. The only reason this method should fail is if the social network has reached its maximum size.
	 * @param id id of the members
	 * @return true if the member is in the network at the completion of this method, and false if not.
	 */
	public boolean addMember(String id) {
		id = upperCase(id);
		for(int i = 0; i < count; i++) {
			if (members[i].equals(id)) {
				System.out.println(id + " already exits in system!");
				return true;
			}
		}
		if(count == maxSize) {
			System.out.println(id + " can not added becuase it reached max size");
			return false;
		}
		if (count <= maxSize) {
			members[count] = id;
			storage.put(id, new Member());
			count++;
			return true;
		}
		return false;
	}
	/**
	 * Returns true if the two specified people exist in the network, and are pals, and returns false otherwise.
	 * @param id1 the id of a person
	 * @param id2 the id of another person
	 * @return true if id1 and id2 are pals in the network, and false otherwise
	 */
	public boolean arePals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(storage.get(id1).frnds.contains(id2) 
				&& containsMember(id1)
				&& containsMember(id2)
				&& storage.get(id2).frnds.contains(id1)) {
			return true;
		}
		System.out.println(id1 + " and " + id2 + " are not pals!");
		return false;
	}
	/**
	 * Given two members, returns an arrayList of members who are pals with both of the two members. The arrayList will be sorted by the members' ids.
	 * @param id1  the id of one member
	 * @param id2  the id of another (not necessarily different) member
	 * @return an arrayList of members who are pals to both of the two specified members, sorted by id.
	 */
	public String[] commonPals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(!(containsMember(id1)
				&& containsMember(id2))) {
			String[] empty = {};
			return empty;
		}
		ArrayList<String> commonFriends = new ArrayList<String>();
		for(String f : storage.get(id1).frnds) {
			if(storage.get(id2).frnds.contains(f))
				commonFriends.add(f);
		}
		String[] returns = commonFriends.toArray(new String[commonFriends.size()]);
		return returns;
	}
	/**
	 * Returns true if there exists a member in the network with the given id, and false otherwise.
	 * @param id The id of a member
	 * @return true if the member exists in the network, and false otherwise
	 */
	public boolean containsMember(String id) {
		id = upperCase(id);
		for (int i = 0; i < count; i++) {
			if (members[i].equals(id)) {
				return true;
			}
		}
		System.out.println(id + " not founded!");
		return false;
	}
	/**
	 * Removes id1 from id2's pal list, and removes id2 from id1's pal list. Does nothing id1 or id2 are not members, or if they are members but are not pals.
	 * @param id1  the id of a person
	 * @param id2 the id of another person
	 */
	public void endPals(String id1, String id2) {
		id1 = upperCase(id1);	id2 = upperCase(id2);
		if(!(containsMember(id1)
				&& containsMember(id2)));
		else if(storage.get(id1).frnds.contains(id2) && storage.get(id2).frnds.contains(id1)) {
			storage.get(id1).frnds.remove(id2);
			storage.get(id2).frnds.remove(id1);
			System.out.println("Successfully ended pals between " + id1 + " and " +id2 + "!");
		}
		
	}
	/**
	 * Gets a count of the number of members.
	 * @return the number of members in the social network
	 */
	public int getMemberCount() {
		return count;
	}
	/**
	 * Returns a (possibly empty) array of all members in the network, sorted by id.
	 * @return an array of all members in the network, sorted by id. Returns an array of length 0 if there are no members in the network.
	 */
	public String[] getMembers() {
		int count = getMemberCount();
		String[] returns = Arrays.copyOf(members, count);
		Arrays.sort(returns);
		return returns;
	}
	/**
	 * Returns the pals of a particular member, sorted by id.
	 * @param id the id of a member
	 * @return an arrayList of the pals of the specified member, sorted by id. Returns an arrayList of size zero if the specified member does not exist, or if the member exists but has no pals.
	 */
	public String[] getPals(String id) {
		id = upperCase(id);
		if(containsMember(id)) {
		Collections.sort(storage.get(id).frnds);
		String[] returns = storage.get(id).frnds.toArray(new String[storage.get(id).frnds.size()]);
		return returns; 
		}
		String[] returns = new String[0];
		return returns;
	}
	/**
	 * If id1 and id2 are members in the network, then makes them pals. Returns true if, at the end of the method, id1 and id2 are pals (which could mean they were pals before this method was invoked), and returns false otherwise (which really would only happen if id1 or id2 were not a member in the network.
	 * @param id1  the id of a person
	 * @param id2  the id of another person
	 * @return true if id1 and id2 are pals in the network, and false otherwise.
	 */
	public boolean makePals(String id1, String id2) {
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
	/**
	 * Removes member from the social network. If member is pals with anyone, all traces of that member will be gone. That is, member will be removed from everyone's pal list. Does nothing if member is not in the social network.
	 * @param id the id of the member to be removed
	 */
	public void removeMember(String id) {
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
				break;
			}
		}
	}
	/**
	 * Returns a newline-separated list of members, including a comma-separated list of each member's pals. Note that the list of members should be sorted by id, and each member's list of pals should be sorted by id. For example: Amy [Mary, Dina] Bob [Mary] Dina [Amy, Mary] Mary [Amy, Bob, Dina] Steve []
	 */
	@Override
	public String toString() {
		String s = "";
		Set<String> keys = storage.keySet();
		keys = new TreeSet<String>(keys);
		for(String key: keys)
			s += (key + storage.get(key).toString() + "\n") ;
		return s;
	}
	/**
	 * Return a String of the id with making the first letter capital and other lowercase and check for any space put by accident. 
	 * @param id
	 * @return String
	 */
	private String upperCase(String id) {
		id = id.trim();
		String cap = id.substring(0, 1).toUpperCase() + id.substring(1).toLowerCase();
		return cap;
	}
}