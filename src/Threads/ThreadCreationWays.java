package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        //ilk calisan thread main thread'dir, kontrol ettik
        System.out.println("current thread : "+ Thread.currentThread().getName());//main

        MyThread thread1=new MyThread();
        //thread1.run();
        thread1.start();//thread sinifinda run methodunda yazilanlar islenmeye baslar
        //run() diyerek de cagirdgimizda method yine calisiyor.
        // start ile cagirmamiz arasindaki fark sudur. run() ile cagirildiginda thread degismez sadece method calisir.
        //start()'da ise thread once ayaga kalkar daha sonra icindeki run() method'u calisir


        MyRunnable runnable=new MyRunnable();
        Thread thread2 =new Thread(runnable);
        thread2.start();

        //!!! isimsiz olarak thread olusturma, annonymous(Interface)
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); //5 saniye uyu
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(("Current thread: "+Thread.currentThread().getName()));
                System.out.println("Bu annonymous class'iyla olusturulan thread");
            }
        });

        thread3.setName("Thread3"); //thread3 e isim verdik
        thread3.run();

        //!!!isimsiz olrak thread olusturalim
        Thread thread4=new Thread(()->{
            System.out.println("Lambda ile yazildi");
        });
        thread4.start();
        System.out.println("main methodu bitti");

        Thread thread5=new Thread(()->{
            System.out.println("thread5 calisti");
        });
        thread5.start();

    }


}
//1. way: thread class'ini extend ederek
class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread calisti");
    }
}

//2. way: Runnable interface'i implement ederek
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable calisti");
    }
}