import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Task 2.3
 * You are given the java class called PathComplete, which has a method
 * called findSomething. Implement the minimum number of JUnit test cases to achieve
 * path complete to the findSomething method.Write your test case(s) in the test() method
 * in the PathCompleteTest.java file. All test cases should pass the JUnit test. You are not
 * allowed to alter the signatures of the given methods and the package
 * structures of the given classes.
 */
public class PathCompleteTest {

    @Test(timeout = 1000)
    public void test() {
        /* All numbers are greater than zero */
        assertEquals(10, PathComplete.findSomething(10, 5, 6)); //a>b and a>c
        assertEquals(15, PathComplete.findSomething(10, 5, 15)); //a>b and c>a
        assertEquals(20, PathComplete.findSomething(10, 20, 15)); //a<b and b>c
        assertEquals(25, PathComplete.findSomething(10, 20, 25)); //a<b and b<c

        /* a is lesser than 0 */
        assertEquals(10, PathComplete.findSomething(-10, 5, 6)); //|a|>b and |a|>c
        assertEquals(15, PathComplete.findSomething(-10, 5, 15)); //|a|>b and c>|a|
        assertEquals(20, PathComplete.findSomething(-10, 20, 15)); //|a|<b and |a|>c
        assertEquals(25, PathComplete.findSomething(-10, 20, 25)); //|a|<b and b<c

        /* b is lesser than 0 */
        assertEquals(10, PathComplete.findSomething(10, -5, 6)); //a>|b| and a>c
        assertEquals(15, PathComplete.findSomething(10, -5, 15)); //a>|b| and c>a
        assertEquals(20, PathComplete.findSomething(10, -20, 15)); //a<|b| and |b|>c
        assertEquals(25, PathComplete.findSomething(10, -20, 25)); //a<|b| and |b|<c

        /* c is lesser than 0 */
        assertEquals(10, PathComplete.findSomething(10, 5, -6)); //a>b and a>|c|
        assertEquals(15, PathComplete.findSomething(10, 5, -15)); //a>b and |c|>a
        assertEquals(20, PathComplete.findSomething(10, 20, -15)); //a<b and b>|c|
        assertEquals(25, PathComplete.findSomething(10, 20, -25)); //a<b and b<|c|









    }
}
