package abstraction;

abstract class Vehicle {
    String color;

    abstract void honk();

    void run() {
        System.out.println("Car is running");
    }
}

class Car extends Vehicle {
    String engineType;

    @Override
    void honk() {
        // TODO Auto-generated method stub

    }
}



class Main {
    public static void main(String args[]) {
        Car c = new Car();

        c.run();
        c.honk();
    }
}
