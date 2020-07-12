package Chapter5;

import static org.junit.Assert.fail;

public class TestHelper {
    public static <X extends Throwable> Throwable assertThrows(
            final Class<X> excptionClass,final Runnable block){

        try {
            block.run();
        } catch (Throwable ex) {
            if(excptionClass.isInstance(ex))
                return ex;
        }
        fail("Failed to throw expected exception");
        return null;
    }
}
