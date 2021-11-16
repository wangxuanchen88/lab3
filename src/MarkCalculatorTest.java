import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarkCalculatorTest {
    /**
     * Return a list of parameters which are different implementation of
     * interface {@linkplain MarkCalculator}.
     * Do NOT Modify this part
     */
    @Parameters
    public static Iterable<? extends Object> getImplementations() {
        return Arrays.asList(
                new MarkCalculator0(),
                new MarkCalculator1(),
                new MarkCalculator2(),
                new MarkCalculator3(),
                new MarkCalculator4(),
                new MarkCalculator5(),
                new MarkCalculator6(),
                new MarkCalculator7(),
                new MarkCalculator8(),
                new MarkCalculator9(),
                new MarkCalculator10(),
                new MarkCalculator11(),
                new MarkCalculator12(),
                new MarkCalculator13(),
                new MarkCalculator14(),
                new MarkCalculator15()
        );
    }

    @Parameter
    public MarkCalculator calculator;


    /* Inner class to store all necessary information for the test */
    private static class TestMark {
        int lab;
        int ass1;
        int ass2;
        int finalExam;
        int mark;
        Grade grade;

        public TestMark(int lab, int ass1, int ass2, int finalExam, int mark) {
            this.lab = lab;
            this.ass1 = ass1;
            this.ass2 = ass2;
            this.finalExam = finalExam;
            this.mark = mark;
        }
    }

    /* Lists to store different test grades*/
    private static final List<TestMark> marksForPX = new ArrayList<>();
    private static final List<TestMark> marksForP = new ArrayList<>();
    private static final List<TestMark> marksForC = new ArrayList<>();
    private static final List<TestMark> marksForD = new ArrayList<>();
    private static final List<TestMark> marksForHD = new ArrayList<>();
    private static final List<TestMark> marksForN = new ArrayList<>();
    private static final List<TestMark> marksForRedeemable = new ArrayList<>();

    private static final int TEST_TIMES = 10000;

    /* Add 10000 cases to each lists */
    @Before
    public void init() {
        Random random = new Random();

        while (marksForPX.size() + marksForP.size() + marksForC.size() + marksForD.size() + marksForHD.size() + marksForN.size() + marksForRedeemable.size() < 7 * TEST_TIMES) {
            /* Randomly generate for valid numbers to represent one situation*/
            int lab = random.nextInt(11);
            int ass1 = random.nextInt(11);
            int ass2 = random.nextInt(11);
            int finalExam = random.nextInt(101);

            int mark = calculateMark(lab, ass1, ass2, finalExam);
            TestMark tm = new TestMark(lab, ass1, ass2, finalExam, mark);
            Grade grade = findScope(mark);

            /* Add mark to corresponding list*/
            switch (grade) {
                case PX:
                    if (marksForPX.size() < TEST_TIMES) {
                        marksForPX.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
                case P:
                    if (marksForP.size() < TEST_TIMES) {
                        marksForP.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
                case C:
                    if (marksForC.size() < TEST_TIMES) {
                        marksForC.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
                case D:
                    if (marksForD.size() < TEST_TIMES) {
                        marksForD.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
                case HD:
                    if (marksForHD.size() < TEST_TIMES) {
                        marksForHD.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
                default:
                    if (marksForN.size() < TEST_TIMES) {
                        marksForN.add(tm);
                    }

                    if (finalExam > mark && marksForRedeemable.size() < TEST_TIMES) {
                        tm.grade = findScope(finalExam);
                        marksForRedeemable.add(tm);
                    }
                    break;
            }
        }
    }

    private static Grade findScope(int mark) {
        if (mark >= 45 && mark <= 49) {
            return Grade.PX;
        } else if (mark >= 50 && mark <= 59) {
            return Grade.P;
        } else if (mark >= 60 && mark <= 69) {
            return Grade.C;
        } else if (mark >= 70 && mark <= 79) {
            return Grade.D;
        } else if (mark >= 80 && mark <= 100) {
            return Grade.HD;
        } else {
            return Grade.N;
        }

    }


    /**
     * Calculate marks
     */
    private static int calculateMark(int lab, int ass1, int ass2, int finalExam) {
        double labPart = 10 * (lab / 10.0);
        double ass1Part = 15 * (ass1 / 10.0);
        double ass2Part = 15 * (ass2 / 10.0);
        double examPart = 60 * (finalExam / 100.0);

        return (int) Math.round(labPart + ass1Part + ass2Part + examPart);
    }

    /*
     * Hint: Many students get stuck in this lab. Ensure you create out-of-bounds,
     * 	tests which expect an exception. Furthermore, note that if the first,
     * 	statement in such a test results in an exception, then later statements
     * 	will not be executed.
     */
    // ########## YOUR CODE STARTS HERE ##########

    /* Test exceptions*/
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(-1, 0, 0, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException2() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, -1, 0, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException3() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, 0, -1, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException4() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, 0, 0, -1, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException5() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(15, 0, 0, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException6() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, 15, 0, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException7() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, 0, 15, 0, true, false);

    }
    @Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
    public void testException8() throws ComponentOutOfRangeException {
        this.calculator.calculateMark(0, 0, 0, 110, true, false);

    }



    /* Test grade N */
    @Test(timeout = 1000)
    public void testGradeN() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForN) {
            assertEquals(new MarkGrade(tm.mark, Grade.N), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }


    /* Test grade PX */
    @Test(timeout = 1000)
    public void testGradePX() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForPX) {
            assertEquals(new MarkGrade(tm.mark, Grade.PX), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }

    /* Test grade P */
    @Test(timeout = 1000)
    public void testGradeP() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForP) {
            assertEquals(new MarkGrade(tm.mark, Grade.P), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }

    /* Test grade C */
    @Test(timeout = 1000)
    public void testGradeC() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForC) {
            assertEquals(new MarkGrade(tm.mark, Grade.C), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }

    /* Test grade D */
    @Test(timeout = 1000)
    public void testGradeD() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForD) {
            assertEquals(new MarkGrade(tm.mark, Grade.D), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }

    /* Test grade HD */
    @Test(timeout = 1000)
    public void testGradeHD() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForHD) {
            assertEquals(new MarkGrade(tm.mark, Grade.HD), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, false));
        }
    }

    /* Test grade NCN */
    @Test(timeout = 1000)
    public void testGradeNCN() throws ComponentOutOfRangeException {
        for (TestMark tm : marksForPX) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, false));

        }

        for (TestMark tm : marksForP) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, true));
        }

        for (TestMark tm : marksForC) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, true));
        }

        for (TestMark tm : marksForD) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, true));
        }

        for (TestMark tm : marksForHD) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, true));
        }

        for (TestMark tm : marksForN) {
            assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, false, true));
        }

    }

    /* Test redeemable */
    @Test(timeout = 1000)
    public void testRedeemable() throws ComponentOutOfRangeException {
        /* Test total mark is greater than final exam mark */
        for (TestMark tm : marksForPX) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.PX), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }

        for (TestMark tm : marksForP) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.P), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }

        for (TestMark tm : marksForC) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.C), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }

        for (TestMark tm : marksForD) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.D), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }

        for (TestMark tm : marksForHD) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.HD), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }

        for (TestMark tm : marksForN) {
            if (tm.mark > tm.finalExam) {
                assertEquals(new MarkGrade(tm.mark, Grade.N), this.calculator.calculateMark(tm.lab, tm.ass1, tm.ass2, tm.finalExam, true, true));
            }
        }


        /* Test total mark is lesser than final exam mark*/
        for (TestMark test : marksForRedeemable) {
            assertEquals(new MarkGrade(test.finalExam, test.grade), this.calculator.calculateMark(test.lab, test.ass1, test.ass2, test.finalExam, true, true));
        }

    }



}
