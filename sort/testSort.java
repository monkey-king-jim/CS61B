public class TestSort {
    /** Tests the sort method of the Sort class. */
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallestIndex(input);
        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, actual);

            }
        }

    public static void main(String[] args) {
        testSort();
    }
}