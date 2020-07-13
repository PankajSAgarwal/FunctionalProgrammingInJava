package Chapter6;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class HolderThreadSafe {
    private Heavy heavy;

    public HolderThreadSafe() {
        System.out.println("Holder created");
    }

    // thread safe but will incur unnecessary synchronization overhead
    // even when there are no competing threads
    public synchronized Heavy getHeavy() {

        if(heavy == null){
            heavy = new Heavy();
        }
        return heavy;
    }

    // ...

    public static void main(String[] args) {
        HolderThreadSafe holder = new HolderThreadSafe();//Holder created
        System.out.println("deferring heavy creation ..");
        System.out.println(holder.getHeavy());//Heavy created //quite heavy
        System.out.println(holder.getHeavy());// quite heavy
    }
}
