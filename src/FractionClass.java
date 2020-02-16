public class FractionClass implements Fraction {


  // Follow these instructions, which are outlined in
  // more detail in the problem set README.

  /* INSTANCE VARIABLES */
  // Create long type instance variables for the numerator and denominator


  /* CONSTRUCTOR */
  // Implement the constructor to initialize the instance variables.


  /* FRACTION INTERFACE METHODS */
  // Implement *all* the methods from the Fraction interface.
  // Do not change return type, spelling, parameters!


  /* COMPARABLE INTERFACE METHOD (compareTo()) */
  // Implement compareTo() from the Comparable interface:
  // int compareTo(Fraction other)
  // Return positive number (e.g., 1) if the calling Fraction is bigger,
  // return negative number (e.g., -1) if the other Fraction is bigger,
  // return 0 if they are equal.


  /* ARITHMETIC HELPER METHODS */
  // You can use this if you wish!
  // Helper method for least common multiple
  static long lcm(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    return m * (n / gcd(m, n));
  }

  // Helper method for greatest common divisor
  static long gcd(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    if (0 == n) return m;
    else return gcd(n, m % n);
  }


  /* MAIN METHOD */
  // The main() method does unit testing.
  // Here's an example for you to use, but
  // ** you must provide two more additional unit tests.**

  public static void main(String[] args) {
    // Uncomment the following code to run the unit test
    // by deleting the /* and */

    /*
    Fraction r1 = new FractionClass(3, 9);
    Fraction r2 = new FractionClass(2, 10);
    Fraction r3 = r1.plus(r2);
    Fraction r4 = r1.subtract(r2);
    Fraction r5 = r1.multiply(r2);
    Fraction r6 = r1.divide(r2);
    int r8 = r1.compareTo(r2);

    System.out.format("%s + %s = %s%n", r1, r2, r3);       // 8/15
    System.out.format("%s - %s = %s%n", r1, r2, r4);       // 2/15
    System.out.format("%s * %s = %s%n", r1, r2, r5);       // 1/15
    System.out.format("%s / %s = %s%n", r1, r2, r6);       // 5/3
    if (r8 == 1) {
      System.out.println(r1 + " > " + r2);
    } else if (r8 == 1) {
      System.out.println(r1 + " < " + r2);
    } else {
      System.out.println(r1 + " = " + r2);
    }
    */

  }
}
