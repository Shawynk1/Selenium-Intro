import org.testng.annotations.Test;
import org.testng.Assert;

public class TestSuite {
    @Test
    public void test1() {
        String str = "TestNg is working fine";
        Assert.assertEquals("TestNg is working fine", str);
    }
}
