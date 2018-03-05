import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class HotelReviewTest {
    public static void test() throws FileNotFoundException{
        System.out.println("The test of class is starting");
        HotelReview Test = new HotelReview("data.txt");


        if(Test.getHotelCount()!=5)System.out.print("The amount of hotels fails5");


        System.out.println("The test of class is finished");
    }

}
