package atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread first=new Thread(counter,"First");
        Thread second=new Thread(counter,"Second");


        first.start();
        second.start();
        //Thread.sleep(5000);

        first.join();
        second.join();
        System.out.println(counter.count);
    }

    static class Counter extends Thread{
        public AtomicInteger count= new AtomicInteger(0);

        public void run(){
            //in java 8 we can add underscore for simpler and more understandable
            for (int i=0;i<1_000_000;i++){
                count.addAndGet(1);
            }
        }
    }
}
