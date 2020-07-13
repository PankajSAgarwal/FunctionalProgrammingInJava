package Chapter6;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class HolderNaive {
    private Heavy heavy;

    public HolderNaive() {
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        // race condition can occure if two or more threads call at the same time
        if(heavy == null){
            heavy = new Heavy();
        }
        return heavy;
    }

    // ...

    public static void main(String[] args) {
        HolderNaive holder = new HolderNaive();//Holder created
        System.out.println("deferring heavy creation ..");
        System.out.println(holder.getHeavy());//Heavy created //quite heavy
        System.out.println(holder.getHeavy());// quite heavy
    }
}
