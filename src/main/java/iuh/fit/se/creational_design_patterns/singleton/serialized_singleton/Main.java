package iuh.fit.se.creational_design_patterns.singleton.serialized_singleton;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        SerializedSingleton instance1 = SerializedSingleton.getInstance();

        try {
            // Serialize the instance
            FileOutputStream fileOut = new FileOutputStream("serializedSingleton.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(instance1);
            out.close();
            fileOut.close();

            // Deserialize the instance
            FileInputStream fileIn = new FileInputStream("serializedSingleton.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerializedSingleton instance2 = (SerializedSingleton) in.readObject();
            in.close();
            fileIn.close();

            // Check if both instances are the same
            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());

            if (instance1 == instance2) {
                System.out.println("Both instances are the same (Singleton preserved).");
            } else {
                System.out.println("Instances are different (Singleton broken).");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}