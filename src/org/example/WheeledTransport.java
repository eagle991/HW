package org.example;

public abstract class WheeledTransport implements org.exemple.Transport {



    private final String modelName;

    private final int wheelCount;

    public WheeledTransport(String modelName, int wheelCount) {
        this.modelName = modelName;
        this.wheelCount = wheelCount;
    }
    public String getModelName() {
        return modelName;
    }
    public int getWheelCount() {
        return wheelCount;
    }
    public void updateTyre(){
        System.out.println("Меняем шину у "+ getModelName());
    }

    @Override
    public void service() {
        for (int i = 0; 1 < wheelCount; i++) {
            updateTyre();
        }
    }
}


