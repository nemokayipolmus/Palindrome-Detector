
package palindromedetector;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import util.LinkedList;

public class PalindromeDetector {
	
	public static void main(String[] args) {
		
                String line = new String();
		File file = new File("palindromes.txt");
		LinkedList<String> list = new LinkedList<String>();

		 try {
			 Scanner sc = new Scanner(new FileInputStream(file));
			 while (sc.hasNextLine()){
				 line = sc.nextLine();
				 list.addLast(line);
				 
                                 FindPalindrome(list.lastValue().toString());
		}
			sc.close();
		}catch(FileNotFoundException fnf){
			fnf.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("\nEX");
		}
    }
        
	private static void FindPalindrome(String test){
	
        char[] chArray = FormatString(test).toCharArray();
        
        if(checkString(chArray) == true){
        	System.out.printf("%-60.60s  %-60.60s%n", test, "is a palindrome");
        }
        else{
        	System.out.printf("%-60.60s  %-60.60s%n", test, "is not a palindrome");
        }
	}
    
        public static boolean checkString(char[] c){
        
        boolean palindrom = false;
        
        if(c.length%2 == 0){
            for(int i = 0; i < c.length/2-1; i++){
                if(c[i] != c[c.length-i-1]){
                    return false;
                }else{
                    palindrom = true;
                }
            }
        }else{
            for(int i = 0; i < (c.length-1)/2-1; i++){
                if(c[i] != c[c.length-i-1]){
                    return false;
                }else{
                    palindrom = true;
                }
            }
        }
        return palindrom;
	}
	private static String FormatString(String str){
		
		str = str.replaceAll("[^a-zA-Z]", "");
		
                StringBuilder sb = new StringBuilder(str);
		for (int index = 0; index < sb.length(); index++) {
		    char c = sb.charAt(index);
		    if (Character.isUpperCase(c)) {
		        sb.setCharAt(index, Character.toLowerCase(c));
		    }
		}
		str = sb.toString();
		return str;
	}
	

}
