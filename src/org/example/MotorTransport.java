package org.example;

public abstract class MotorTransport extends org.example.WheeledTransport {


    public MotorTransport(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }


    public void cneckEngine() {
        System.out.println("Проверяем двигатель у транспорта" + getModelName());
    }

    @Override
    public void service() {
        super.service();
    }

    public abstract void checkEngine();
}