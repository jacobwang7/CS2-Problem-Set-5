import java.util.Scanner;

public class Postfix {

  public static void main(String[] args) {
    // Create a stack of Fraction objects
    BCStack<Fraction> ss = new BCStackLinkedList<Fraction>();

    // Get input from user.
    System.out.println("Enter an expression to evaluate: ");
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();

    // Divide the string into chunks by splitting on space (\\s+)
    String[] parts = s.split("\\s+");

    // Go through each of the chunks...
    for (int i=0; i<parts.length; i++) {
      String e = parts[i];

      // if the chunk is an operator, pop the last two
      // things off the stack and carry out that operation
      if (e.equals("+")) {
        Fraction d2 = ss.pop();
        Fraction d1 = ss.pop();
        Fraction result = d1.plus(d2);
        ss.push(result);
        //.plus adds the two fraction classes
      } else if (e.equals("-")) {
        Fraction d2 = ss.pop();
        Fraction d1 = ss.pop();
        Fraction result = d1.subtract(d2);
        ss.push(result);
        //.subtract finds the difference between the two fraction classes
      } else if (e.equals("*")) {
        Fraction d2 = ss.pop();
        Fraction d1 = ss.pop();
        Fraction result = d1.multiply(d2);
        ss.push(result);
        //.multiply finds the product of the two fraction classes
      } else if (e.equals("/")) {
        Fraction d2 = ss.pop();
        Fraction d1 = ss.pop();
        Fraction result = d1.divide(d2);
        ss.push(result);
        //.divide whill divide the two fraction classes
      }
      // if e is not one of the four operators...
      else {
        String[] fractionparts = e.split("\\/");
        long top = Long.parseLong(fractionparts[0]);
        long bottom = Long.parseLong(fractionparts[1]);
        FractionClass frac = new FractionClass(top, bottom);
        ss.push(frac);
      }
      // Create a new FractionClass object with top and bottom.
      // Push it onto the the mathstack Stack.
    }

    // print out the stack
    System.out.println(ss.pop());

  }
}
