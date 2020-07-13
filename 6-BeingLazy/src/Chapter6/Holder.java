package Chapter6;

import net.jcip.annotations.ThreadSafe;

import java.util.function.Supplier;

/*
Thread safe class with lazy initialization and example of virtual proxy
Assumption : Heavy class is a thread safe class as well
 */
@ThreadSafe
public class Holder {

    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy>{
            private final Heavy heavyInstance = new Heavy();
            @Override
            public Heavy get() {
                return heavyInstance;
            }
        }
        if(!HeavyFactory.class.isInstance(heavy)){
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }

    public Holder() {
        System.out.println("Holder created ");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }
    //...

    public static void main(String[] args) {
        final Holder holder = new Holder();// holder instance created without creating instance of Heavy
        System.out.println("deferring heavy creation");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }
}
