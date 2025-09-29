import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        // Here we provide the non primitive data type

        ArrayList<Integer> al = new ArrayList<>();
        al.add(55);
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al);
        al.add(2, 98);
        System.out.println(al);

        System.out.println(al.get(2));
        al.set(3, 100);
        System.out.println(al);
    }
}
