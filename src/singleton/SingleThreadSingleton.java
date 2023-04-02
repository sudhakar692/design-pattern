package singleton;

public class SingleThreadSingleton {
    private static SingleThreadSingleton instance;
    public String value;

    private SingleThreadSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static SingleThreadSingleton getInstance(String value){
        if (instance == null) {
            instance = new SingleThreadSingleton(value);
        }
        return instance;
    }

}
