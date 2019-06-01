package common.tryBlock;

public class Test2 {
    public int add(int a,int b){   
         try {
             return a+b;      
         } 
        catch (Exception e) {  
            System.out.println("catch语句块");
         }
         finally{ 
             System.out.println("finally语句块");
         }
         return 0;
    } 
     public static void main(String argv[]){ 
         Test2 test =new Test2();
         System.out.println("和是："+test.add(9, 34)); 
     }
}