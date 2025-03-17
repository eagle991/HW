package org.example;

public class App {
    public static void Main(String[] args) {
        Car car = new Car("car1", 4);
        Car car2 = new Car("car2",  4);

        Truck truck = new Truck( "truck1",  6);
        Truck truck2 = new Truck("truck2",  6);

        Bicycle bicycle = new Bicycle("bike1",  2);
        Bicycle bicycle2 = new Bicycle("bike2",  2);

        Electrocar electrocar = new Electrocar("electrocar1",4);
        org.exemple.Transport[] transports = {
                car,
                car2,
                truck,
                truck2,
                bicycle,
                bicycle2,
                electrocar
};
        ServiceStation station = new ServiceStation();

        for (org.exemple.Transport transport: transports) {
            station.check(transport);
        }
    }
}
