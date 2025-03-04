package iuh.fit.se.creational_design_patterns.singleton.bill_pugh_singleton_implementation;

public class Main {
    public static void main(String[] args) {
        // Lấy instance đầu tiên từ BillPughSingleton
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        System.out.println("Instance 1 hashcode: " + instance1.hashCode());

        // Lấy instance thứ hai từ BillPughSingleton
        BillPughSingleton instance2 = BillPughSingleton.getInstance();
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());

        // Kiểm tra xem cả hai instance có cùng một địa chỉ không
        if (instance1 == instance2) {
            System.out.println("Cả hai instance là cùng một đối tượng Singleton.");
        } else {
            System.out.println("Hai instance KHÔNG phải là cùng một đối tượng Singleton.");
        }
    }
}