import java.util.Scanner;

public class Postfix {

  public static void main(String[] args) {

    // Create a stack of Double objects
    BCStack<Double> ss = new BCStackArray<Double>();

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
        Double d2 = ss.pop();
        Double d1 = ss.pop();
        Double result = d1 + d2;
        ss.push(result);
      } else if (e.equals("-")) {
        Double d2 = ss.pop();
        Double d1 = ss.pop();
        Double result = d1 - d2;
        ss.push(result);
      } else if (e.equals("*")) {
        Double d2 = ss.pop();
        Double d1 = ss.pop();
        Double result = d1 * d2;
        ss.push(result);
      } else if (e.equals("/")) {
        Double d2 = ss.pop();
        Double d1 = ss.pop();
        Double result = d1 / d2;
        ss.push(result);
      }
      // Otherwise, if it's not an operator, it's a
      // numberm, so push it on the stack!
      else {
        ss.push(Double.parseDouble(e));
      }
    }

    // print out the stack
    System.out.println(ss.pop());

  }
}
