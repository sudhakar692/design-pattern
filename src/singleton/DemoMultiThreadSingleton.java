package singleton;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class DemoMultiThreadSingleton {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {

        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
