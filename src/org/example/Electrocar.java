package org.example;

public class Electrocar extends org.example.MotorTransport {

    public Electrocar(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    @Override
    public void checkEngine() {

        System.out.println("Проверяем электромотор");
    }
}
