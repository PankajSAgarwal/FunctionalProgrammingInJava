package Chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static Chapter5.Locker.runLocked;

public class Locking {
    Lock lock = new ReentrantLock();

    protected void setLock(final Lock mock){
        lock = mock;
    }

    public void doOp1(){
        lock.lock();
        try{
            //... critical code ...
        }finally {
            lock.unlock();
        }
    }

    // ...

    public void doOp2(){
        runLocked(lock,()->{/*... critical code ...*/});
    }

    public void doOp3(){
        runLocked(lock,()->{/*... critical code ...*/});
    }

    public void doOp4(){
        runLocked(lock,()->{/*... critical code ...*/});
    }
}
