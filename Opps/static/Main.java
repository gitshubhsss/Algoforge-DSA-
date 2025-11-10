class Bike {
    static int objectCount = 0;

    public Bike() {
        objectCount++;
    }

    public static int getNumberOfBike() {
        return objectCount;
    }

}

class Main {

    public static void main(String args[]) {
        Bike b1 = new Bike();
        Bike b2 = new Bike();

        System.out.println(Bike.objectCount);
    }
}