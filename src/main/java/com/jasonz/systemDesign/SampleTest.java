package com.jasonz.systemDesign;

/**
 * @author Jason Zhuang
 * @created 2024.06.11 10:37
 * @project JasonJavaLibrary
 * @description:
 */
public class SampleTest {
    static {
        // Ensure memory storage is initialized at application start
        MemoryStorageAccess.getInstance();
    }

    public static void main(String[] args) {
        // Application logic here
        SampleTest test = new SampleTest();
        test.tryMemoryStorageAccess();
    }

    // test the MessageStorageAccess single instance
    private void tryMemoryStorageAccess(){
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        MemoryStorageAccess myStorage =  MemoryStorageAccess.getInstance();
                        for(int i=0;i<10;i++) {
                            myStorage.put(i, "Thread 1 - Jason"+i);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(myStorage.get(i));
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        MemoryStorageAccess myStorage =  MemoryStorageAccess.getInstance();
                        for(int i=10;i>0;i--) {
                            myStorage.put(i, "Thread 2 - Jason"+i);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(myStorage.get(i));
                        }
                    }
                }
        );


        try{
            t1.start();
            t2.start();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
