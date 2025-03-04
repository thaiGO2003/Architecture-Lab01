package iuh.fit.se.creational_design_patterns.singleton.eager_initialization;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new
            EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}