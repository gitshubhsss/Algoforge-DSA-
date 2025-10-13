import java.util.ArrayList;

public class GetMazePathWithJumps {

    public static ArrayList<String> getAllPath(int sr, int sc, int dr, int dc) {
        // when we reach to our destination will return the empty stirng
        if (sc == dc && sr == dr) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();
        // horizontal jumps
        int maxHorizontalJumpsAllowed = dc - sc;
        for (int jump = 1; jump <= maxHorizontalJumpsAllowed; jump++) {

            // if the whole problem is to file the it from the (0,0) then the smaller would
            // be (0,1),(0,2),
            ArrayList<String> pathAfterHjump = getAllPath(sr, sc + jump, dr, dc);
            for (String path : pathAfterHjump) {
                myAns.add("h" + jump + path);
            }
        }
        // vertical path
        int maxVerticalJumpsAllowed = dr - sr;
        for (int jump = 1; jump <= maxVerticalJumpsAllowed; jump++) {
            // if the whole problem was to solve for the (0,0) then the smaller would be
            // (1,0),(2,0);
            ArrayList<String> pathAfterVjump = getAllPath(sr + jump, sc, dr, dc);
            for (String path : pathAfterVjump) {
                myAns.add("v" + jump + path);
            }
        }

        return myAns;
    }

    public static void main(String[] args) {
        System.out.println(getAllPath(0, 0, 2, 2));
    }
}

// OutPUT= [h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v2h1, h2v1v1, h2v2,
// v1h1h1v1, v1h1v1h1, v1h2v1, v1v1h1h1, v1v1h2, v2h1h1, v2h2]
