import Proxy.ProxyImage;
import Proxy.RealImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestImage {
    @Test
    public void testImage(){
        boolean success = true;
        try{
            RealImage realImage = new RealImage("example.png");
            realImage.display();
            ProxyImage proxyImage = new ProxyImage("example.png");
            proxyImage.display();
        } catch (Exception e){
            success = false;
        }
        Assertions.assertTrue(success);
    }
}


