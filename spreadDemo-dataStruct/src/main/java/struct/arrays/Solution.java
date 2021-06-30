package struct.arrays;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int[]  int1 = new int[10];

        int1.so

        char[] c1 = new char[10];
        char[] c2 = new char[10];

        for(String s : word1){
            for(int i =0;i< s.length() ; i++){
                c1[i] = s.charAt(0);
            }
        }

        for(String s : word1){
            for(int i =0;i< s.length() ; i++){
                c2[i] = s.charAt(0);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (c1[i] != c2[i]) return false;
        }

        return true;

    }
}