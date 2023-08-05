package bloomberg.strings;

import com.bichel.algorithms.strings.StringCompression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StringCompressionTests {
    @Test
    public void testTestCase1() {
        StringCompression pr = new StringCompression();

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int amount = pr.compress(chars);
    }

    @Test
    public void testTestCase2() {
        StringCompression pr = new StringCompression();

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int amount = pr.compress(chars);

        Assertions.assertEquals(4, amount);
    }

    @Test
    public void testTestCase3() {
        StringCompression pr = new StringCompression();

        char[] chars = {'a', 'a'};
        int amount = pr.compress(chars);

        Assertions.assertEquals(4, amount);
    }

    @Test
    public void testTestCase4() {
        StringCompression pr = new StringCompression();

        char[] chars = {'a', 'b', 'c'};
        int amount = pr.compress(chars);

        Assertions.assertEquals(4, amount);
    }
}
