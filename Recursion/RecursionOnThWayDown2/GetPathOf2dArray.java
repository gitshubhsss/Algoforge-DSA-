import java.util.ArrayList;

public class GetPathOf2dArray {

    // Expentiation: it will return [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
    // faith:if it returns the path from 0th row and 0th col then it will give the
    // path from
    // 0+1 row and 0+1 col
    // [0,0]=[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
    // [0,1]=[hvv,hhv,vhv] this is for the horzoaal
    // [1,0]=[hhv,hvh,vhh] this is for vertical

    // so if we add h in the [0,1] will get[hhvv,hhhv,hvhv]
    // and if we add the v in the [1,0] will get [vhhv,vhvh,vvhh]
    // and that will be our final answer
    public static ArrayList<String> getAllPath(int sr, int sc, int dr, int dc) {

        // if we get the invalid index on that day will return empty arry
        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        // when we reach to our destination will return the empty stirng
        if (sc == dc && sr == dr) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        // Faith if it will work properly from 0 to col+1//horizontal path
        ArrayList<String> horizontalPath = getAllPath(sr, sc + 1, dr, dc);
        // Faith if it will work properly from 0 to row+1 //vertical path
        ArrayList<String> verticalPath = getAllPath(sr + 1, sc, dr, dc);

        ArrayList<String> myAns = new ArrayList<>();

        for (String s : horizontalPath) {
            myAns.add("h" + s);
        }
        for (String s : verticalPath) {
            myAns.add("v" + s);
        }
        return myAns;
    }

    public static void main(String[] args) {
        System.out.println(getAllPath(0, 0, 2, 2));
    }
}
