class Car {
    String engineType;
    String color;
    int horsePower;

    public Car() {
        System.out.println("Defaltcon called");
    }

    public Car(String engineType) {
        this.engineType = engineType;
        System.out.println("setting value of engineType called");
    }

    public Car(String engineType, String color) {
        this(engineType);
        this.color = color;
        System.out.println("setting values for engineType and color called ");
    }

    public Car(String engineType, String color, int horsePower) {
        this(engineType, color);
        this.horsePower = horsePower;
        System.out.println("setting values for engineType ,color horsePower and  called ");
    }

    public int doubleHorsePower() {
        return horsePower * 2;
    }

    public String changeCarColor(String color) {
        this.color = color;
        return color;
    }
}

class Main {

    public static void main(String[] args) {
        Car c1 = new Car();

        Car c2 = new Car("electric");

        Car c3 = new Car("electric", "Orange");

        Car c4 = new Car("electric", "Red", 150);

        System.out.println(c4.doubleHorsePower());
        System.out.println(c4.changeCarColor("Black"));

    }
}