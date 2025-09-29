public class StringBasics {
    public static void main(String[] args) {
        // We create the array of charactes
        char name[] = { 'h', 'e', 'l', 'l', 'o' };

        // There is another way to create the array of characters

        String str = "hello";

        // System.out.println(str);

        String pavan = "pavan";
        String shubham = "pavan";

        String ashish = new String("pavan");

        System.out.println(pavan.hashCode());
        System.out.println(shubham.hashCode());
        System.out.println(ashish.hashCode());

        System.out.println(pavan == ashish);
        System.out.println(pavan == shubham);

        // O(n)
        if (pavan.equals(ashish)) {// it first compares the address // if address are not equal then it
            // checks the charcter by character

        }
        System.out.println("value of ashish is " + ashish);

    }
}
