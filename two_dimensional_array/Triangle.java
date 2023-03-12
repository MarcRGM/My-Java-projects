package two_dimensional_array;

// iterate and print
//      3
//    2 3 4
//  1 2 3 4 5
public class Triangle {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};

        for (int row = 0; row < nums.length; row++) {
            int removed = 0;
            for (int space = 0; space < nums.length - (row + 1); space++) {
                System.out.print(" ");
                removed++;
            }
            for (int column = 0; column < nums[row].length; column++) {
                if (removed <= column && column < nums[row].length - removed) {
                    System.out.print(nums[row][column]);
                }
            }
            System.out.println();
        }


    }
}
