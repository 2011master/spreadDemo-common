package technologyStack.interfaceDefault;

/**
 * https://www.geeksforgeeks.org/default-methods-java/
 */
// A simple program to Test Interface default
// methods in java 
interface TestInterfaceDefaultMethod
{ 
    // abstract method 
    public void square(int a); 
  
    // default method 
    default void show() 
    { 
      System.out.println("Default Method Executed"); 
    } 
} 