import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BinarySearchTest {

    @Test
    public void zeroElement() {
        int[] inputs = {};
        int expect = -1;
        int actual = BinarySearch.search(inputs, 9);

        assertEquals(expect, actual);
    }

    @Test
    public void oneElement() {
        int[] inputs = {9};
        int targetNotExist = 1;
        int targetExist = 9;
        int expectNotExist = -1;
        int expectExist = 0;

        int actualNotExist = BinarySearch.search(inputs, targetNotExist);
        assertEquals(expectNotExist, actualNotExist);

        int actualExist = BinarySearch.search(inputs, targetExist);
        assertEquals(expectExist, actualExist);
    }

    @Test
    public void myAwesomeTests() {
        int[] input1 = {3};
        int answer1 = BinarySearch.search(input1, 3);
        assertEquals(0, answer1);

        int[] input2 = {1, 2, 3};
        int answer2 = BinarySearch.search(input2, 1);
        assertEquals(0, answer2);

        int answer3 = BinarySearch.search(input2, 3);
        assertEquals(2, answer3);

        int[] input3 = {3, 5, 7, 9, 20};
        int answer4 = BinarySearch.search(input3, 9);
        assertEquals(3, answer4);
    }

    @Test
    public void manyElement() {
        int[][] inputs = {
                {},
                {3},
                {3},
                {1, 3},
                {1, 3},
                {4, 6, 8},
                {4, 6, 8},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
                {3, 5, 7, 9, 20},
        };
        int[] targets = {9, 1, 3, 1, 3, 4, 6, 8, 3, 9};
        int[] answer = {-1, -1, 0, 0, 1, 0, 1, 2, 0, 3};

        for (int i = 0; i < inputs.length; i++) {
            int actual = BinarySearch.search(inputs[i], targets[i]);
            int expected = answer[i];
            assertEquals(expected, actual);
        }
    }

    @Test
    // run it with "-Xmx8g"
    public void largeArrayOverflow() {
        int hugeArraySize = Integer.MAX_VALUE / 3 * 2;
        int[] hugeArray = new int[hugeArraySize];
        for (int i = 0; i < hugeArray.length; i++) {
            hugeArray[i] = i;
        }

        int[] targets = {hugeArray.length - 1};
        int[] expected = {hugeArray.length - 1};

        for (int i = 0; i < targets.length; i++) {
            try {
                int actual = BinarySearch.search(hugeArray, targets[i]);
                assertEquals(expected[i], actual);
            } catch (Exception e) {
                fail(e.toString());
            }
        }
    }
}
