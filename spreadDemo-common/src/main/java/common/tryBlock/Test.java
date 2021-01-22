package common.tryBlock;

public class Test {
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " +
        getValue());
        System.out.println("----------------");
        getValue2();
    }
     public static int getValue() {
         try {
             return 0;
         } finally {
             return 1;
         }
     }

    public static int getValue2() {
        try {
            return 0;
        } finally {
            System.out.println("execute");
        }
    }
 }