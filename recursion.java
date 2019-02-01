import java.util.ArrayList;

public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      double guess = n/2;
      return sqrt(n,tolerance,guess);
    }

    public static double sqrt(double n, double tolerance, double guess) {
      if (java.lang.Math.abs((guess * guess - n) / n) < (tolerance / 100)) {
        return guess;
      }
      else {
        guess = (n/guess + guess)/2;
        return sqrt(n, tolerance, guess);
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 0; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return fib(0,1,0,n);
    }

    public static int fib(int first, int second, int current, int n) {
      if (current < n) {
        int temp = first;
        first = second;
        second = temp + second;
        current += 1;
        return fib(first,second,current,n);
      }
      return first;
    }

    /*As Per classwork*/
    // public static ArrayList<Integer> makeAllSums(){
    //
    // }

    public static void main(String[] args) {
      // System.out.println(sqrt(4,10));
      // System.out.println(sqrt(9,1));
      // System.out.println(sqrt(225,.001));
      // System.out.println(sqrt(2,.001));
      System.out.println(fib(0));
      System.out.println(fib(1));
      System.out.println(fib(4));
    }

}
