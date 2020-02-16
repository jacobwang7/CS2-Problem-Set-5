# Problem Set 5
## Due Saturday, February 22 at 11:59pm
---

For this problem set, you will implement an interface, write your own `compareTo()` method, learn about polymorphism,  practice writing a constructor, and refactor an existing class to work with a new kind of data.

The interface you will be implementing is a specification for carrying out mathematical operations on fractions (a.k.a. rational numbers). You are going to create a class implementing this interface that has two instance variables of type `long`: one representing the numerator of the fraction and one representing the denominator of the fraction. 

The methods you write will perform arithmetic operations with fractions just the way you did in elementary school. For adding and subtracting, you need to ensure that the denominators are the same. To multiply, you multiply the two numerators to get the new numerator, and multiply the two denominators to get the new denominator. To divide, you flip the second fraction over and multiply. Of course, like in elementary school, you have to reduce your resulting fraction to lowest terms! And you will always return another `Fraction` and never a decimal.

Finally you will refactor the `Postfix` class we wrote together so that it can handle objects of your new `Fraction` class.

## The `Fraction` interface

**Note: You do not need to modify the `Fraction` interface in any way. You just need to implement the interface, as descibed in the next section and in the code for `FractionClass.java`.**

The Java interface you will be implementing has the following specification:

```java
public interface Fraction extends Comparable<Fraction> {
  long getNumerator();
  long getDenominator();
  Fraction plus(Fraction b);
  Fraction subtract(Fraction b);
  Fraction multiply(Fraction b);
  Fraction divide(Fraction b);
  String toString();
}
```

This is a new kind of interface for us because it **extends another interface**! The notation `extends Comparable<Fraction>` means that an implementation of the `Fraction` interface requires everything listed expicitly in the `Fraction` interface **plus** whatever is specified in the `Comparable` interface. More on this below! 

**Note: You do not need to modify the interface in any way. You just need to implement the interface, as descibed below and in the code for `FractionClass.java`.**

## The `FractionClass` implementation of the `Fraction` interface

You will implement the `Fraction.java` interface in a class called `FractionClass.java`. `FractionClass.java` will need to implement: (1) all the methods in the `Fraction` interface; (2) the `compareTo()` method from the `Comparable` interface; (3) a constructor; and (4) a main method for testing your code.

### 1. Methods in the `Fraction` interface
Most of these methods perform some kind of arithmetic on fractions. You'll need to reduce the result of each operation to its lowest terms. I have provided some code for finding the least common multiple (`lcm`) and greatest common divisor (`gcd`), which you may or may not find helpful. A few things to remember: 

* Do not change the method declarations (return type, method name, parameters) at all when you implement them. You'll note that many of them return a `Fraction`. That is okay! This is what polymorphism is all about.
* There should be no decimals at any time.
* If the user tries to instantiate a  `FractionClass` with a `0` denominator, throw an `IllegalArgumentException`, which will terminate the program.

### 2. The `compareTo()` method

The `Comparable` interface is an important built-in interface from `java.lang` which has one method:

```java
public interface Comparable<T> {
  int compareTo(T other);
}
```

We've talked about generics in class, and you see it here. In the examples we've seen so far, Since the `Fraction` interface says `Comparable<Fraction>`, that means that when we write our implementation of `compareTo()`, we substitute in `Fraction` for `T `. Thus, when you write your `compareTo()` method in your `FractionClass.java` file, the method will look like this:

```java
int compareTo(Fraction other) {
  // blah blah blah
}
```

An implementation of `compareTo()` should return: 

* a positive number if the calling object is larger than the argument object
* a negative number if the calling object is smaller than the argument object
* 0 if the calling object and the argument object are equal

### 3. The `FractionClass` constructor
Use the constructor to set the `numerator` and `denominator` instance variables.

### 4. Unit testing in `main()`
The `main()` method of `FractionClass.java` runs some *unit tests*, which help you determine whether you are doing things correctly. When you run your code and uncomment what is in the main method, you should see the output that is indicated in the comments to the right of each method call in the main method.

You must provide **two additional unit tests of each of the mathematical operations and `compareTo()`** using different `Fraction` objects. Make your code look like the code provided for unit testing in `main()`. Specifically, in the comments, indicate what the expected output should be.

## Refactoring the `PostFix` class
You'll recall that in lecture, we twice wrote a `Postfix` class to be able to do arithmetic with postfix notation using a stack. In the `src` directory, I have provided all of the necessary code for doing this with `Double` objects: `BCStack.java`, `BCStackLinkedList.java`, and `Postfix.java`. You don't need to do anything with the first two files. Instead, you will "refactor" `Postfix.java` so that it works with `Fraction` objects. 

This will involve 

* changing all the `double` and `Double` references to `Fraction`
* modifying how you call the arithmetic operations so that they are the methods on `Fraction`
* doing fancier parsing of the string to turn a `String` into a `FractionClass` object

The first two changes should be straightforward. The third change will be a little tricky so I will give you a big hint. In the `Double` version of this class, if the `String` chunk under consideration was not an operator, you called `Double.parseDouble(e)` to turn it into a `Double` and then pushed that `Double` on the stack. Here you will need to first divide the `String` chunk, `e`, into two parts: the part before the `/` and the part after the `/`. Then you'll turn each of those part into a `Long` using `Long.parseLong()`. Then you'll create a new `FractionClass` with those components. You can do this as follows (but don't forget to implement the last two commented lines!).

``
// if e is not one of the four operators...
   String[] fractionparts = e.split("\\/");
   long top = Long.parseLong(fractionparts[0]);
   long bottom = Long.parseLong(fractionparts[1]);
   // Create a new FractionClass object with top and bottom.
   // Push it onto the the mathstack Stack.
``

---

## Pushing and verifying your submission

Once your code works to your satisfaction, push `FractionClass.java` to your personal master repo on the GitHub Classroom site, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

---

## Important notes on grading

1. All of your classes **must be in the `src` directory**. You will lose 1 point for each file that is not in this directory. 

2. Your code must compile. If a class does not compile, you will get a 0. If you are struggling and you aren't able to get in touch with me or the TAs, any TAs in the lab can help you compile your code. If it's 11:55pm on the day it's due and you don't want to take the late penalty, comment out the part of the code that is preventing compilation, and include an explanation of why you are commenting it out.

3. You must comment your code. The TAs are instructed to take off up to 1 point for missing or inadequate comments.

4. The TAs will review and run your code with its unit tests. Then they will try out a few `PostFix` expressions. It's a good idea to do some error checking to avoid any surprises during grading.

