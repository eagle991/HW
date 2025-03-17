package org.example;

public class Truck extends org.example.MotorTransport {

    public Truck(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }

    @Override
    public void service () {
        super.service();
        checkTrailer();
    }

    @Override
    public void checkEngine() {

    }
}
