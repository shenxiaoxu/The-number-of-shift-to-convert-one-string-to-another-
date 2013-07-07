/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author XiaoxuShen
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     * Write a C program to find the number of shift required to convert one string to another. Check all the corner cases. 

         Eg: abc to acb o/p shd be 2 as 'b' shifted from 1st index to 2nd and 'c' shifted to 1st from second.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //1.Levenshtein Algorithm using dynamic programming
        //d[i,j] represents the number of edit to transfer from first i character of string one to first j character of string two.
        //d[i,j] = min{d[i - 1, j] + 1, d[i, j-1] + 1, d[i - 1, j - 1] + 1}(if i character of first string is not equal 
        //to j character of second string)
        //d[0,j] and d[i,0]is already known.
        System.out.println(EditDistance("cdf","abcd"));
        
    }
    public static int EditDistance(String s1, String s2){
        int[][] DynamicArray = new int[s1.length()+ 1][s2.length() + 1];
        for(int ii = 0; ii <= s1.length(); ii++){
            for(int jj = 0; jj <= s2.length(); jj++){
                if(ii == 0){
                    DynamicArray[ii][jj] = jj;
                }else if(jj == 0){
                    DynamicArray[ii][jj] = ii;
                }else{
                    DynamicArray[ii][jj] = 0;
                }
            }
        }
        for(int ii = 1; ii <= s1.length(); ii++){
            for(int jj = 1; jj <= s2.length(); jj++){
                
                if(s1.charAt(ii - 1) == s2.charAt(jj - 1)){
                    DynamicArray[ii][jj] = minimal(DynamicArray[ii - 1][jj] + 1, DynamicArray[ii][jj - 1] + 1, DynamicArray[ii - 1][jj - 1]);
                }else{
                    DynamicArray[ii][jj] = minimal(DynamicArray[ii - 1][jj] + 1, DynamicArray[ii][jj - 1] + 1, DynamicArray[ii - 1][jj - 1] + 1);                   
                }
            }
        }
        return DynamicArray[s1.length()][s2.length()];
    }
    public static int minimal(int aa, int bb, int cc){
        if(aa <= bb && bb <= cc){return aa;}
        if(aa<=cc && cc <= bb){return aa;}
        if(bb <= aa && aa<= cc){return bb;}
        if(bb <= cc && cc <= aa){return bb;}
        if(cc <=bb && cc <= aa){return cc;}
        else{return bb;}        
    }
}
