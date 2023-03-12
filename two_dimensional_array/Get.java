package two_dimensional_array;
// Iterate the array and print
// 1
// 1
// 1 2
// 1 2
// 1 2 3
// 1 2 3
// 1 2 3 4
// 1 2 3 4
public class Get {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4},
                        {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};

        int index = 1;
        for (int row = 0; row < nums.length; row++) {
            if (row % 2 == 0 && row > 1) {
                index++;
            }
            for (int column = 0; column < index; column++) {
                System.out.print(nums[row][column]);
            }
            System.out.println();
        }

    }

}
