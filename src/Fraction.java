// An interface for performing arithmetic on
// rational numbers as fractions.

public interface Fraction extends Comparable<Fraction> {
  long getNumerator();
  long getDenominator();
  Fraction plus(Fraction b);
  Fraction subtract(Fraction b);
  Fraction multiply(Fraction b);
  Fraction divide(Fraction b);
  String toString();
}
