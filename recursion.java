import java.util.ArrayList;

public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      double guess = n/2; //guess is half of the number
      return sqrt(n,tolerance,guess); //calls the helper function
    }

    //helper function that keeps track of the guess
    public static double sqrt(double n, double tolerance, double guess) {
      if (java.lang.Math.abs((guess * guess - n) / n) > (tolerance / 100)) { //if the percent error is greater than what was desired
        guess = (n/guess + guess)/2; //a new guess is created
        return sqrt(n, tolerance, guess); //the function is called again
      }
      else { //if it is not
        return guess; //return guess
      }
    }

    public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed
  }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 0; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      return fib(0,1,0,n); //first int is 0, second is 1, current is the 0th term
    }

    //helper function
    public static int fib(int first, int second, int current, int n) {
      if (current < n) { //if the current term is less than the desired term
        int temp = first; //a temporary variable is created to store the value of the first term
        first = second; //first gets the value of the second term
        second = temp + second; //second gets the value of the first+second term
        current += 1; //current increases by 1
        return fib(first,second,current,n); //the function is called again
      }
      return first; //base case
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
      if (n > 0) { //if n is positive
        makeAllSums(n-1,sum,ans); //calls the function again on the sum without adding anything
        sum += n; //increases sum
        makeAllSums(n-1,sum,ans); //calls the function after adding the number to the sum
      }
      if (n < 0) { //if n is negative
        makeAllSums(n+1,sum,ans); //calls the function again on the sum without adding anything
        sum += n; //increases sum
        makeAllSums(n+1,sum,ans); //calls the function after adding the number to the sum
      }
      if (n == 0) {
        ans.add(sum); //when n reaches 0, the sum is added to the array
      }
    }

    //testing
    public static void main(String[] args) {
        System.out.println("sqrt()");
        System.out.println("-----------------------\n");

        System.out.println("sqrt(4, 0.00001)");
        System.out.println("EXPECTED: 2");
        System.out.println(sqrt(4, 0.00001));         // 2

        System.out.println("----");

        System.out.println("sqrt(8, 0.00001)");
        System.out.println("EXPECTED: ~2.8284");
        System.out.println(sqrt(8, 0.00001));         // ~2.8284

        System.out.println("----");

        System.out.println("sqrt(0, 0.00001)");
        System.out.println("EXPECTED: 0");
        System.out.println(sqrt(0, 0.00001));         // 0

        System.out.println("\n");

        System.out.println("fib()");
        System.out.println("-----------------------\n");

        System.out.println("fib(0)");
        System.out.println("EXPECTED: 0");
        System.out.println(fib(0));                   // 0

        System.out.println("----");

        System.out.println("fib(1)");
        System.out.println("EXPECTED: 1");
        System.out.println(fib(1));                   // 1

        System.out.println("----");

        System.out.println("fib(7)");
        System.out.println("EXPECTED: 13");
        System.out.println(fib(7));                   // 13

        System.out.println("makeAllSums()");
        System.out.println("-----------------------\n");

        System.out.println("makeAllSums(0)");
        System.out.println("EXPECTED: [0]");
        System.out.println(makeAllSums(0));           // [0]

        System.out.println("----");

        System.out.println("makeAllSums(1)");
        System.out.println("EXPECTED: [1, 0]");
        System.out.println(makeAllSums(1));           // [1, 0]

        System.out.println("----");

        System.out.println("makeAllSums(3)");
        System.out.println("EXPECTED: [0, 3, 2, 5, 1, 4, 3, 6]");
        System.out.println(makeAllSums(3));           // [0, 3, 2, 5, 1, 4, 3, 6]
      }

}
