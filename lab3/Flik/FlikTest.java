import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest{
   @Test
   public void testFlik(){
      int a = 128;
      int b = 128;
      int c = 127;
      assertTrue(Flik.isSameNumber(a, b));
      assertTrue(!Flik.isSameNumber(a, c));
      assertTrue(!Flik.isSameNumber(c, 20));
   }

}