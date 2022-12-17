package Threads;

//thread'ler ayni kaynaga erismek isterse ne olacak
public class Multithreading02 {

    public static int counter=0;
    public static void main(String[] args) {
        //!!!ayri 2 thread olusturup ayni kaynaga erismesini saglayalim

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread1 calisti");
            }
        });
        thread1.start();

//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread2 calisti");
            }
        });
        thread2.start();
    }
}

class Counter {
    //synchronized ile bu method icine threadler sira ile girecekler
    public synchronized static void count(){
        for (int i=1; i<=1000; i++){
            Multithreading02.counter++;//1000
        }
        System.out.println("counter : "+Multithreading02.counter);
    }

}
