import java.util.*;
import java.util.Arrays;
import java.util.List;

public class CountKSubStr  { 
	    // Function to count number of substrings 
	    // with exactly k unique characters 
	
	// �������ȣ����ܸ����������list;
	    public static int countkDist(String str, int k) { 
	        int res = 0,  len = str.length(); 
	        // To store count of characters from 'a' to 'z' 
	        int map[] = new int[26]; 
	        for (int i = 0; i < len; i++)  { 
	            int count = 0; 
	            Arrays.fill(map, 0); 
	            // Consider all substrings between str[i..j] 
	            for (int j = i; j<len; j++)  { 
	                if (map[str.charAt(j) - 'a'] == 0)  count++; 
	                // Increment count of current character 
	                map[str.charAt(j) - 'a']++; 
	                // If distinct character count becomes k, 
	                // then increment result. 
	                if (count == k)  res++; 
	            } 
	        } 
	        return res; 
	    } 
	    // ����list�����ҹ涨����Ϊk, k-1 chars
	    public static List<String> countkDistLenK(String str, int k) {
	    	int res = 0, len = str.length();
	    	List<String> list = new ArrayList<>();// ��������ظ���list���set��
	    	Set<Character> set = new HashSet<>();// ��set����map[26]�����ԡ�
	    	for (int i = 0; i < len-k+1; i++) { // i is start
	    		for (int j = i;  j < len; j++) {
	    			set.add(str.charAt(j));
	    			if (set.size() == k) {
	    				list.add(str.substring(i, j+1));
	    			}
	    		}
	    		set.clear();
	    	}
	    	return list;
	    }
	    
	    public static void main(String[] args)  { 
	        String str = "pqpqr"; 
	        int res = countkDist(str, 2);
	        List<String> list = countkDistLenK(str, 2);
	        System.out.println("we have " + 
	                           res +    " K distinct chars  substrings "); 
	        for (String s : list)
	        	System.out.print(s+",");
	    } 
	} 
