import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExecutorServiceFrameworkQuestions {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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

        /*


         */
        Callable<String> Task23 = () -> {
            for (int a = 0; a < 1000; a++) {
                try {
                    newLock.lock();
                    counter[0]++;
                } finally {
                    newLock.unlock();
                }
            }
            return "Execution Completed";
        };

        ExecutorService newExecutor = Executors.newFixedThreadPool(10);
        Future<String> result = newExecutor.submit(Task23);
        System.out.println(result.get());

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
            try {
                System.out.println("Read Value : " + counter3[0]);
            } finally {
                l1.readLock().unlock();
            }
        };
        ExecutorService readPool = Executors.newFixedThreadPool(3);
        for (int a = 0; a < 100; a++) {
            readPool.execute(readTask);
            if (a % 7 == 0) {
                Runnable writeTask = () -> {
                    l1.writeLock().lock();
                    try {
                        counter3[0]++;
                        System.out.println("Written value: " + counter3[0]);
                    } finally {
                        l1.writeLock().unlock();
                    }
                };
                new Thread(writeTask).start();
            }
        }
        readPool.shutdown();
            /*

                Question 4: Using the Lock Framework, create a multithreaded program where multiple threads are trying
                to book seats for a concert. There are only 10 seats available, and each thread should try to book a
                seat if any are available. Once a seat is booked, it should not be available for other threads.
                1 - Implement the seat-booking logic using an appropriate lock mechanism.
                2 - Ensure that each thread safely checks and updates the seat availability.
                3 - Print out messages showing which thread successfully booked a seat or if no seats are available
                    when a thread attempts to book.
                Once you’ve coded this, share it, and we’ll go over any improvements or enhancements that can be made.

             */
        List<Boolean> seatBookingList = new ArrayList<>(Collections.nCopies(10, false));
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

        Runnable bookTask = () -> {
            lock.writeLock().lock();
            try {
                for (int i = 0; i < seatBookingList.size(); i++) {
                    if (!seatBookingList.get(i)) {
                        seatBookingList.set(i, true);
                        System.out.println(Thread.currentThread().getName() + " booked seat number " + (i + 1));
                        break;
                    }
                }
            } finally {
                lock.writeLock().unlock();
            }
        };

        ExecutorService seatBookingThreads = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            seatBookingThreads.execute(bookTask);
        }
        seatBookingThreads.shutdown();
        try {
            if (!seatBookingThreads.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Some tasks did not complete within the timeout");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        /**
         * More efficient way to solve the above is to use AtomicBoolean array, rather than locks on List, since,
         * AtomicBoolean variable can be independently do the update with blocking the list via any lock.
         * When to Prefer Lock-Free Over Locking Solutions
         *      High Concurrency Needs: For systems that need to handle many concurrent threads, lock-free
         *          structures reduce bottlenecks.
         *      Independent Updates: If each thread’s work can be isolated (as with independent seat bookings),
         *          lock-free structures shine.
         *      Reduced Complexity: Code using atomic operations is usually more straightforward than code managing
         *          lock states, making it preferable where possible.
         */
        AtomicBoolean[] seatBooking2 = new AtomicBoolean[10];
        for (int i = 0; i < seatBooking2.length; i++) {
            seatBooking2[i] = new AtomicBoolean(false); // All seats initially available
        }

        Runnable seatBookingTask2 = () -> {
            for (int a = 0; a < 10; a++) {
                if (seatBooking2[a].compareAndSet(false, true)) {
                    System.out.println(Thread.currentThread().getName() + " booked seat number " + (a + 1));
                    break;
                }
            }
        };

        ExecutorService threadsForSeatBooking = Executors.newFixedThreadPool(3);
        for (int a = 0; a < 10; a++) {
            threadsForSeatBooking.execute(seatBookingTask2);
        }
        threadsForSeatBooking.shutdown();
        try {
            if (!threadsForSeatBooking.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("We were not able to book tickets as the seats are already full");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        /*
        Question 5 : Implement a thread-safe cache in Java. The cache should:
            1 - Store key-value pairs where both the key and value are strings.
            2 - Support put, get, and remove operations.
            3 - Expire entries after a certain timeout period (you can assume a default of 5 seconds).
            4 - Use a ConcurrentHashMap for storing the cache entries.
            5 - Ensure that expired entries are removed automatically from the cache.
            This cache implementation will help simulate scenarios like temporary storage of data for quick access,
            where data is discarded after a period.
         */

        ConcurrentHashMap<Integer, cacheEntry> cache = new ConcurrentHashMap<>();
        Runnable cacheEntryTask = () -> {
            for (int a = 0; a < 20; a++) {
                cache.put(a, new cacheEntry("String1 : " + a, "String2 : " + a, Instant.now()));
                System.out.println("Added Cache Entry : " + a + " : " + cache.get(a).value1() + " : By Thread : " + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Runnable cacheDeletionTask = () -> {
            for (Integer key : cache.keySet()) {
                cache.computeIfPresent(key, (k, v) -> {
                    if (Instant.now().minusSeconds(5).isAfter(v.timeOfCreation())) {
                        return null;
                    }
                    return v;
                });
            }
        };

        ExecutorService cacheAddition = Executors.newFixedThreadPool(3);
        ScheduledExecutorService cacheDeletion = Executors.newScheduledThreadPool(1);

        cacheAddition.execute(cacheEntryTask);
        cacheDeletion.scheduleAtFixedRate(cacheDeletionTask, 0, 5, TimeUnit.SECONDS);

        cacheAddition.shutdown();
        cacheAddition.awaitTermination(1, TimeUnit.MINUTES);

        Thread.sleep(1000);

        cacheDeletion.shutdown();
        cacheDeletion.awaitTermination(1, TimeUnit.MINUTES);
        /*
        Question 6 : Using the Executor Framework, create a thread pool that processes a list of URLs. Each thread
                    should fetch the content of a URL, and for each fetched content, you need to count the number
                    of occurrences of a specific keyword (let’s say “Java”). Finally, print the URL and the count
                    of the keyword occurrences.
         */


    }


}

record cacheEntry(String value1, String value2, Instant timeOfCreation) {
};
