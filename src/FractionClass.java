public class FractionClass implements Fraction {


  // Follow these instructions, which are outlined in
  // more detail in the problem set README.

  /* INSTANCE VARIABLES */
  // Create long type instance variables for the numerator and denominator
    long num;
    long denom;
    //These are the instance variables for the numerator and denominator

  /* CONSTRUCTOR */
  // Implement the constructor to initialize the instance variables.
  //This is the constructor for a fraction which also checks for a Division
  //by zero error
  public FractionClass(long num, long denom) {
    if (denom == 0) {
      throw new IllegalArgumentException("Division by zero.");
    }
    this.num = num;
    this.denom = denom;
  }

  /* FRACTION INTERFACE METHODS */
  // Implement *all* the methods from the Fraction interface.
  // Do not change return type, spelling, parameters!
  //These getters return the numerator and the denominator
  public long getNumerator() {
    return this.num;
  }
  public long getDenominator() {
    return this.denom;
  }
  //This method adds two fractions
  public Fraction plus(Fraction b){
    long commondenom = lcm(this.denom, b.getDenominator());
    long den1 = commondenom/this.denom;
    long den2 = commondenom/b.getDenominator();
    long num1 = this.num*den1;
    long num2 = b.getNumerator()*den2;
    long newnum = num1 + num2;
    long common = gcd(newnum, commondenom);
    long finalnum = newnum / common;
    long finaldenom = commondenom / common;
    Fraction answer = new FractionClass(finalnum, finaldenom);
    return answer;
    //To add two fractions, we call lcm which finds the least common multiple
    //of the denominators so that we can have the same denominator for both
    //fractions. Once there's a common denominator, update the numerators and add them.
    //Call gcd to find greatest common divisor which we then use to divide the
    //numerator and denominator of the final fraction by to get its simplest form.
}
  //This method subtracts the fraction from the argument from the calling fraction
  public Fraction subtract(Fraction b){
    long commondenom = lcm(this.denom, b.getDenominator());
    long den1 = commondenom/this.denom;
    long den2 = commondenom/b.getDenominator();
    long num1 = this.num*den1;
    long num2 = b.getNumerator()*den2;
    long newnum = num1 - num2;
    long common = gcd(newnum, commondenom);
    long finalnum = newnum / common;
    long finaldenom = commondenom / common;
    Fraction answer = new FractionClass(finalnum, finaldenom);
    return answer;
    //To subtract two fractions, we call lcm which finds the least common multiple
    //of the denominators so that we can have the same denominator for both
    //fractions. Once there's a common denominator, update the numerators and subtract them.
    //Call gcd to find greatest common divisor which we then use to divide the
    //numerator and denominator of the final fraction by to get its simplest form.
}
  //This method multiplies two fractions
  public Fraction multiply(Fraction b){
    long num1 = this.num * b.getNumerator();
    long denom1 = this.denom * b.getDenominator();
    long commondivisor = gcd(num1, denom1);
    long finalnum = num1/commondivisor;
    long finaldenom = denom1/commondivisor;
    Fraction answer = new FractionClass(finalnum, finaldenom);
  return answer;
  //To multiply two fractions, multiply the numerators and then multiply the
  //denominators. To simplify, we call gcd to get the greatest common divisor
  //and then we divide the numerator and denominator of the final fraction
  //by the gcd to get its simplest form.
}
  //This method deivides the calling fraction by the fraction from the argument
  public Fraction divide(Fraction b){
    long num1 = this.num * b.getDenominator();
    long denom1 = this.denom * b.getNumerator();
    long commondivisor = gcd(num1, denom1);
    long finalnum = num1/commondivisor;
    long finaldenom = denom1/commondivisor;
    Fraction answer = new FractionClass(finalnum, finaldenom);
  return answer;
  //To divide two fractions, multiply the numerators by the other fraction's
  //denominators. To simplify, we call gcd to get the greatest common divisor
  //and then we divide the numerator and denominator of the final fraction
  //by the gcd to get its simplest form.
}
  public String toString(){
    return this.num+"/"+this.denom;
  }


  /* COMPARABLE INTERFACE METHOD (compareTo()) */
  // Implement compareTo() from the Comparable interface:
  //This method compares two fractions and uses the numerator after finding
  //a common denominator to determine which fraction is larger. Update the
  //numerators after finding the common denominator through the lcm function.
  //Subtract the numerators and if the result is greater than 0, it will return
  //1 (meaning >), if the result is 0, it will return 0 (meaning =), and if
  //the result is anything else, it will return -1 (meaning <).
  public int compareTo(Fraction other) {
    long commondenom = lcm(this.denom, other.getDenominator());
    long den1 = commondenom/this.denom;
    long den2 = commondenom/other.getDenominator();
    long num1 = this.num*den1;
    long num2 = other.getNumerator()*den2;
    long finalnum = num1 - num2;
    if (finalnum > 0) {
      return 1;
    } else if (finalnum == 0) {
      return 0;
    } else {
      return -1;
    }
    }
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
    } else if (r8 == -1) {
      System.out.println(r1 + " < " + r2);
    } else {
      System.out.println(r1 + " = " + r2);
    }

    Fraction a1 = new FractionClass(1, 2);
    Fraction a2 = new FractionClass(3, 4);
    Fraction a3 = a1.plus(a2);
    Fraction a4 = a1.subtract(a2);
    Fraction a5 = a1.multiply(a2);
    Fraction a6 = a1.divide(a2);
    int a8 = a1.compareTo(a2);                             // 1/2 < 3/4
    System.out.format("%s + %s = %s%n", a1, a2, a3);       // 5/4
    System.out.format("%s - %s = %s%n", a1, a2, a4);       // -1/4
    System.out.format("%s * %s = %s%n", a1, a2, a5);       // 3/8
    System.out.format("%s / %s = %s%n", a1, a2, a6);       // 2/3
    if (a8 == 1) {
      System.out.println(a1 + " > " + a2);
    } else if (a8 == -1) {
      System.out.println(a1 + " < " + a2);
    } else {
      System.out.println(a1 + " = " + a2);
    }

    Fraction b1 = new FractionClass(-3, 5);
    Fraction b2 = new FractionClass(-6,10);
    Fraction b3 = b1.plus(b2);
    Fraction b4 = b1.subtract(b2);
    Fraction b5 = b1.multiply(b2);
    Fraction b6 = b1.divide(b2);
    int b8 = b1.compareTo(b2);                             // -3/5 = -6/10
    System.out.format("%s + %s = %s%n", b1, b2, b3);       // -6/5
    System.out.format("%s - %s = %s%n", b1, b2, b4);       // 0
    System.out.format("%s * %s = %s%n", b1, b2, b5);       // 9/25
    System.out.format("%s / %s = %s%n", b1, b2, b6);       // 1
    if (b8 == 1) {
      System.out.println(b1 + " > " + b2);
    } else if (b8 == -1) {
      System.out.println(b1 + " < " + b2);
    } else {
      System.out.println(b1 + " = " + b2);
    }


  }
}
