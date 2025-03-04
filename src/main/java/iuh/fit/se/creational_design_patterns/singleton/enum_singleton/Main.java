package iuh.fit.se.creational_design_patterns.singleton.enum_singleton;

public class Main {
    public static void main(String[] args) {
        // Truy cập thể hiện Singleton
        EnumSingleton singleton = EnumSingleton.INSTANCE;

        // Gọi phương thức doSomething
        singleton.doSomething();

        // Chứng minh rằng đây là Singleton:
        EnumSingleton anotherSingleton = EnumSingleton.INSTANCE;
        System.out.println("Cả hai thể hiện có giống nhau không? " + (singleton == anotherSingleton));
    }
}