public class FindXtoThePowY {

    public static int findXtoThePowY(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smallerValue = findXtoThePowY(x, y - 1);// faith is it will work properly for the y-1
        int ans = x * smallerValue;// solve it for a whole problem
        return ans;
    }

    public static int findXtoThePowY2(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smallerAns = findXtoThePowY2(x, y / 2);// faith that it will work for y/2
        int ans = smallerAns * smallerAns; // y/2 * y/2

        // agar y odd hai to means y^5= x^2*x^2 * x^1
        // so ans= x^2*x^2
        // ans =ans*x;
        if (y % 2 == 1) {
            ans = ans * x;
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(findXtoThePowY(2, 6));
        System.out.println(findXtoThePowY2(2, 5));

    }
}
