package singleton;

public class MultiThreadSingleton {
    private  static volatile MultiThreadSingleton instance;
    public String value;

    MultiThreadSingleton(String value) {
        this.value = value;
    }

    public static MultiThreadSingleton getInstance(String value) {
        // The approach taken care is called double-checked locked (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instance as a result.
        //
        // It may seem that having `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved
        // by introducing this local variable.
        //

        MultiThreadSingleton result = instance;
        if (result != null) {
            return result;
        }

        synchronized (MultiThreadSingleton.class) {
            if (instance == null) {
                instance = new MultiThreadSingleton(value);
            }
            return instance;
        }
    }

}
