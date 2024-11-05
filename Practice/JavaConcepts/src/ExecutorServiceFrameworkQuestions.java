import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExecutorServiceFrameworkQuestions {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> number = Arrays.asList(4, 6, 1, 5, 2, 8, 11, 10);


        /*
            Question 1 : Using the ExecutorService framework, write a Java program that accepts a list of integers and
            creates a fixed thread pool to process each integer in parallel. For each integer, calculate its square
            and print the result.
         */
                        ExecutorService service = Executors.newFixedThreadPool(5);
                        for (int finalA : number) {
                            service.submit(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println(finalA * finalA);
                                }
                            });
                        }
                        service.shutdown();
                        ExecutorService service2 = Executors.newFixedThreadPool(5);
                        for (int finalA : number) {
                            service2.submit(() -> System.out.println(finalA * finalA));
                        }
                        service2.shutdown();

        /*
            Question 2 : Write a Java program that uses the ReentrantLock class. Create two threads that each try
            to increment a shared counter 1000 times. Use the lock to ensure only one thread increments the counter
            at a time.
         */
                        int[] counter = new int[1];
                        Lock newLock = new ReentrantLock(true);

                        Runnable task = () -> {
                            for (int a = 0; a < 1000; a++) {
                                try {
                                    newLock.lock();
                                    counter[0]++;
                                } finally {
                                    newLock.unlock();
                                }
                            }
                        };

                        Thread T1 = new Thread(task);
                        Thread T2 = new Thread(task);

                        T1.start();
                        T2.start();

                        // Joining basically asks the main thread to wait for completion of execution for both the threads.
                        T1.join();
                        T2.join();

            /**
             * Use the above ReentrantLock mechanism or since the need of operation is increment by one. We can also use
             *  Atomic Integer as well. This would remove the need of lock and saves time in context switching in case
             *  of locks. In our use case of only incrementing to one, Atomic Integer will give the highest throughput.
             */
                        AtomicInteger counter1 = new AtomicInteger(0);

                        Runnable task2 = () -> {
                            for (int a = 0; a < 1000; a++) {
                                counter1.incrementAndGet();
                            }
                        };

                        Thread T3 = new Thread(task2);
                        Thread T4 = new Thread(task2);

                        T3.start();
                        T4.start();

                        // Joining basically asks the main thread to wait for completion of execution for both the threads.
                        T3.join();
                        T4.join();

        /*
            Question 3 : Using ReentrantReadWriteLock, write a Java program where multiple threads can read a shared
            resource simultaneously, but only one thread can write to it at any given time. Create two types of tasks:
                A read task that prints the value of a shared integer.
                A write task that increments the shared integer.
            Ensure that multiple read threads can access the resource concurrently, while write threads have
            exclusive access.
         */
                        final Integer[] counter3 = new Integer[1];
                        counter3[0] = 0;
                        ReentrantReadWriteLock l1 = new ReentrantReadWriteLock(true);

                        Runnable readTask = () -> {
                            l1.readLock().lock();
                            try{
                                System.out.println("Read Value : " + counter3[0]);
                            }finally {
                                l1.readLock().unlock();
                            }
                        };
                        ExecutorService readPool = Executors.newFixedThreadPool(3);
                        for(int a = 0 ; a < 100 ; a++){
                            readPool.execute(readTask);
                            if(a % 7 == 0){
                                Runnable writeTask = () -> {
                                    l1.writeLock().lock();
                                    try{
                                        counter3[0]++;
                                        System.out.println("Written value: " + counter3[0]);
                                    }finally {
                                        l1.writeLock().unlock();
                                    }
                                };
                                new Thread(writeTask).start();
                            }
                        }
                        readPool.shutdown();

    }
}
