package practice4;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class J02 extends TestBaseBeforeAfter {
    //Verify that we have pom.xml file in our project => please try in 4 min s


    @Test
    public void test1() {
        String path="C:\\Users\\ASUS\\IdeaProjects\\com.Batch81Maven\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
