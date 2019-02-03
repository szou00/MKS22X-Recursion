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

    /*Returns an array list of all subset totals of the numbers 1 to n inclusive
    */
    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> ans = new ArrayList<Integer>(); //creates a new array
      makeAllSums(n,0,ans); //calls the helper function to modify the array
      return ans; //returns the array
    }

    //a helper function
    public static void makeAllSums(int n, int sum, ArrayList<Integer> ans) {
      if (n > 0) {
        makeAllSums(n-1,sum,ans); //calls the function again on the sum without adding anything
        sum += n; //increases sum
        makeAllSums(n-1,sum,ans); //calls the function after adding the number to the sum
      }
      else {
        ans.add(sum); //when n reaches 0, the sum is added to the array
      }
    }

    //testing
    public static void main(String[] args) {
      // System.out.println(sqrt(4,10));
      // System.out.println(sqrt(9,1));
      // System.out.println(sqrt(225,.001));
      // System.out.println(sqrt(2,.001));
      // System.out.println(fib(0));
      // System.out.println(fib(1));
      // System.out.println(fib(4));
      // System.out.println(fib(5));
      System.out.println(makeAllSums(3));
      System.out.println(makeAllSums(4));
      System.out.println(makeAllSums(5));
      // System.out.println(makeAllSums(12));
    }

}
