package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.Object.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static class testThreeAddThreeRemove{
        private static void printDifference(AListNoResizing<String> Ns, AListNoResizing<Integer> Size, AListNoResizing<String> Elem) {
            System.out.println("Test result after three add and three remove");
            System.out.printf("%20s %12s %30s\n", "List Name", "Size", "Elements");
            System.out.printf("------------------------------------------------------------------\n");
            for (int i = 0; i < Ns.size(); i += 1) {
                String name = Ns.get(i);
                int size = Size.get(i);
                String elem = Elem.get(i);
                System.out.printf("%20s %12d %30s\n", name, size, elem);
            }
        }
        public static void testRun() {
            AListNoResizing testNR = new AListNoResizing<Integer>();
            BuggyAList testAL = new BuggyAList<Integer>();

            AListNoResizing Ns = new AListNoResizing<String>();
            AListNoResizing Size = new AListNoResizing<Integer>();
            AListNoResizing Elem = new AListNoResizing<String>();
            int add_num = 3, remove_num = 3;
            for (int i = 0; i < add_num; i += 1) {
                testNR.addLast(1);
                testAL.addLast(1);
            }
            for (int i = 0; i < add_num; i += 1) {
                testNR.removeLast();
                testAL.removeLast();
            }
            Ns.addLast("AListNoResizing");
            Ns.addLast("BuggyAList");

            Size.addLast(testNR.size());
            Size.addLast(testAL.size());

            String ret = "[ ";
            for (int i = 0; i < testNR.size(); i++) {
                ret += (String.valueOf(testNR.get(i)) + " ");
            }
            ret += "]";
            Elem.addLast(ret);

            ret = "[ ";
            for (int i = 0; i < testAL.size(); i++) {
                ret += (String.valueOf(testAL.get(i)) + " ");
            }
            ret += "]";
            Elem.addLast(ret);

            printDifference(Ns, Size, Elem);
        }
        public static void main(String[] arg) {
          testRun();
        }
    }

    public static class testRandom {
        public static void randomizedTest() {
            AListNoResizing<Integer> L = new AListNoResizing<>();
            BuggyAList<Integer> B = new BuggyAList<>();

            int N = 5000;
            for (int i = 0; i < N; i += 1) {
                int operationNumber = StdRandom.uniform(0, 4);
                if (operationNumber == 0) {
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    B.addLast(randVal);
//                    System.out.println("addLast(" + randVal + ")");
                } else if (operationNumber == 1) {
                    int L_size = L.size();
                    int B_size = B.size();
//                    System.out.println("AListNoResizing size: " + L_size);
//                    System.out.println("BuggyAList size: " + B_size);
                } else if (operationNumber == 2) {
                    int L_last = -1, B_last = -1;
                    if (L.size() > 0) {
                        L_last = L.getLast();
                    }
                    if (B.size() > 0) {
                        B_last = B.getLast();
                    }
//                    System.out.println("AListNoResizing getLast(): " + L_last);
//                    System.out.println("BuggyAList getLast(): " + B_last);
                } else if (operationNumber == 3) {
                    int L_remove = -1, B_remove = -1;
                    if (L.size() > 0) {
                        L_remove = L.removeLast();
                    }
                    if (B.size() > 0) {
                        B_remove = B.removeLast();
                    }
//                    System.out.println("AListNoResizing removeLast(): " + L_remove );
//                    System.out.println("BuggyAList removeLast(): " + B_remove );
                }
            }
        }
        public static void main(String[] arg) {
            randomizedTest();
        }
    }


}
