class Solution {
    public boolean isAnagram(String s, String t) {
        // if string is not equakl to yhe target then return false
       if(s.length()!=t.length()){
        return false;
       } 
       // nor create a array because it it more optimize rether then using the sorting
       int []feq=new int[26];
       // main loop for increasing the count
      for (int i = 0; i < s.length(); i++) {
            feq[s.charAt(i) - 'a']++;   // Increase for s
            feq[t.charAt(i) - 'a']--;   // Decrease for t
        }
       // use the if condition for checking the charcter values are zero or not
       for(int count:feq){
if(count!=0){
    return false;
}
       }
return true;
       }
}
