package iuh.fit.se.creational_design_patterns.singleton.eager_initialization;

public class Main {
    public static void main(String[] args) {
        // Lấy instance duy nhất của EagerInitializedSingleton
        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();

        // In thông tin của các instance để kiểm tra xem chúng có phải là cùng một đối tượng không
        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);

        // Kiểm tra xem cả hai instance có phải là cùng một đối tượng không (nên là true)
        if (instance1 == instance2) {
            System.out.println("Cả hai instance là cùng một đối tượng. Singleton hoạt động đúng!");
        } else {
            System.out.println("Các instance là khác nhau. Có vấn đề gì đó.");
        }
    }
}
