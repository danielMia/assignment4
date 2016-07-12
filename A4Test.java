/**
 * A4Test.java
 * COMP 1020 Summer 2016
 * (C) Computer Science, University of Manitoba
 */
public class A4Test{
  public static void main(String [] args){
    String fileName = "darwin.txt";
    System.out.println("This is A4Test.\n");
    LinkedList myList = new LinkedList(fileName);
    System.out.println(myList.format(80));
    System.out.println(fileName + " contains " + myList.size() + " words.");
  }// main
}// class A4Test