package kit.interfaceDefault;

class TestStaticClass implements TestInterfaceStaticMethod
{ 
    // implementation of square abstract method 
    public void square(int a) 
    { 
        System.out.println(a*a); 
    } 
  
    public static void main(String args[]) 
    {
        TestStaticClass d = new TestStaticClass();
        d.square(4); 
  
        // default method executed 
        TestInterfaceStaticMethod.show();

    } 
} 