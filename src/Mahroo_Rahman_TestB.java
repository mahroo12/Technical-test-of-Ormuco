/*The goal of this question is
 *to write a software library that accepts 2 version
 *string as input and returns whether one is greater than,
 *equal, or less than the other. As an
 *example: “1.2” is greater than “1.1”.
 * Please provide all test cases you could think of.
 */
public class Mahroo_Rahman_TestB {
	
	
	/*
	 * We first split the string into an array and then parse those elements into 
	 * integer values and then compare the elements of each of the values to see
	 * which one is greater or smaller than the other. If value of version 1 is greater than we
	 * return 1 otherwise -1
	 */
	public int compareVersion(String version1, String version2) {
	    String[] arr1 = version1.split("\\.");
	    String[] arr2 = version2.split("\\.");
	 
	    int i=0;
	    while(i<arr1.length || i<arr2.length){
	        if(i<arr1.length && i<arr2.length){
	            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
	                return -1;
	            }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
	                return 1;
	            }
	        } else if(i<arr1.length){
	            if(Integer.parseInt(arr1[i]) != 0){
	                return 1;
	            }
	        } else if(i<arr2.length){
	           if(Integer.parseInt(arr2[i]) != 0){
	                return -1;
	            }
	        }
	 
	        i++;
	    }
	 
	    return 0;
	}
}
