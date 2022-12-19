package Threads;

public class WaitNotify {
    public static int balance=0;

    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("withdraw thread");
        thread1.start();

        //thread2
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("deposit thread");
        thread2.start();
    }

    //para ekleme methodu
    public  void withdraw(int amount){
        synchronized (this){
            if (balance<=0|| balance<amount){
                System.out.println("balance degeri degisene kadar bekliyoruz");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }//blok sonu
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait islemi bittikten sonra veya balance zaten yeterli ise
        balance=balance-amount;
        System.out.println("para cekim islemi basariyla gerceklesti");
    }

    //para yatirma methodu
    public void deposit(int amount){
        balance=balance+amount;
        System.out.println("para yatirma isleminiz basariyla gerceklesti");
        synchronized (this){
            notify();
        }
    }
}
