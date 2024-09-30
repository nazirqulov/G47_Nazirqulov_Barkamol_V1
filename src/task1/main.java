package task1;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank=new Bank();
        Thread thread=new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                bank.increaseBalnce();
            }

        });
        thread.start();
        Thread.sleep(100);
        System.out.println("bank.getBalance() = " + bank.getBalance());
    }
}
