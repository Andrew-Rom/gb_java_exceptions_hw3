import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String[][] someMatrix = null; // Returns "Matrix is null"
//        String[][] someMatrix = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}}; // Returns "Size of matrix is not 4x4"
//        String[][] someMatrix = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2"}, {"1", "2", "3", "4"}}; // Returns "Size of matrix is not 4x4"
//        String[][] someMatrix = {{"1", "2", "3", "4"}, {"1", "abc", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}}; // Returns "Invalid data in array in [1, 1]"
        String[][] someMatrix = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            sumMatrixItems(someMatrix);
        } catch (NullPointerException | MyArraySizeException exception) {
            System.out.println(exception.getMessage());
        } catch (MyArrayDataException exception) {
            System.out.println(exception.getMessage() + " in " + Arrays.toString(exception.getSellIndex()));
        } catch (Exception exception) {
            System.out.println("Unknown exception");
        }
    }

    public static void sumMatrixItems(String[][] matrix) throws NullPointerException, MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int[] indexCellException = new int[2];
        try {
            if (matrix == null) {
                throw new NullPointerException("Matrix is null");
            }

            for (String[] strings : matrix) {
                if (matrix.length != 4 || strings.length != 4) {
                    throw new MyArraySizeException();
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    indexCellException = new int[]{i, j};
                    sum += Integer.parseInt(matrix[i][j]);
                }
            }

            System.out.println("Amount of items is " + sum);

        } catch (NumberFormatException exception) {
            throw new MyArrayDataException(indexCellException);
        }
    }

}