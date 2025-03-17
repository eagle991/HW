package org.example;

public class Bicycle extends org.example.WheeledTransport {


    public Bicycle(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

public void updateTyre() {
System.out.println("Немяем покрышку");
}
}
