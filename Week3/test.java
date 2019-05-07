/**
 * test
 */
public class test {

    public static void main(String[] args) {
        int[][] t = new int[2][3];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = 0;
            }
        }

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print("t[" + i + "][" + j + "] = " + t[i][j] + "; ");
            }
            System.out.println();
        }
    }
}