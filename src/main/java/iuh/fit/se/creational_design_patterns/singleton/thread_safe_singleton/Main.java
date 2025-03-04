package iuh.fit.se.creational_design_patterns.singleton.thread_safe_singleton;

public class Main {
    public static void main(String[] args) {
        // Sử dụng phương thức getInstance() có synchronized
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        System.out.println("Instance 1 hashcode: " + instance1.hashCode());

        // Sử dụng phương thức getInstanceUsingDoubleLocking() với Double-Checked Locking
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());

        // Kiểm tra xem hai instance có cùng một địa chỉ không
        if (instance1 == instance2) {
            System.out.println("Cả hai instance là cùng một đối tượng Singleton.");
        } else {
            System.out.println("Hai instance KHÔNG phải là cùng một đối tượng Singleton.");
        }
    }
}