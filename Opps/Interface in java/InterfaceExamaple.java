interface Vehicle {
    default void honk() {
        System.out.println("Vehicle honk");
    };
}

class Car implements Vehicle {

    @Override
    public void honk() {
        // TODO Auto-generated method stub
        System.out.println("car is honking");
    }

}

class Bike implements Vehicle {

    @Override
    public void honk() {
        // TODO Auto-generated method stub
        System.out.println("bike is honking");
    }

}

public class InterfaceExamaple {
    public static void main(String[] args) {
        Vehicle v1 = new Bike();
        v1.honk();
        ;
    }
}
