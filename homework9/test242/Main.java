package test242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aacc";
		String t = "cacc";
		boolean res = isAnagram(s, t);
		System.out.println(res);

	}

	// brute solution : use hash map
	private static boolean isAnagram(String s, String t) {
		int count = 0;
		if (!(s.length() == t.length()))
			return false;
		HashMap set = new HashMap();
		for (int i = 0; i < s.length(); ++i) {
			if (set.get(s.charAt(i)) == null) {
				set.put(s.charAt(i), 1);
			}
			count = (int) set.get(s.charAt(i));
			count++;
			set.put(s.charAt(i), count);
		}
		for (int j = 0; j < t.length(); ++j) {
			if (set.get(t.charAt(j)) == null)
				return false;
			else {
				count = (int) set.get(t.charAt(j));
				count--;
				if (count < 1)
					return false;
				set.put(t.charAt(j), count);
			}
		}

		return true;
	}

	// solution 2 : use array
	public boolean isAnagram1(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

	// solution 3 : use sort
	public boolean isAnagram2(String s, String t) {
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		Arrays.sort(sChar);
		Arrays.sort(tChar);

		return Arrays.equals(sChar, tChar);
	}

	// solution 4: solution 3 (improve)
	public boolean isAnagram4(String s, String t) {
		if (null == s)
			return (t == null);
		if (t == null || s.length() != t.length())
			return false;
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		Arrays.sort(sChar);
		Arrays.sort(tChar);

		return Arrays.equals(sChar, tChar);
	}

}
