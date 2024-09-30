package task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    Lock lock=new ReentrantLock();
    int balance;
    public void increaseBalnce(){
        lock.lock();
        this.balance+=1;
        lock.unlock();
    }

    public int getBalance() {
        return balance;
    }
}
