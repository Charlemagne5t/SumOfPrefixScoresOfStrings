import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String[] words = {"abc","ab","bc","b"};
        int[] expected = {5,4,3,2};
        int[] actual = new Solution().sumPrefixScores(words);

        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void test2(){
        String[] words = {"abcd"};
        int[] expected = {4};
        int[] actual = new Solution().sumPrefixScores(words);

        Assert.assertArrayEquals(expected, actual);
    }


}
