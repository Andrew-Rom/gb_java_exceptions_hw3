public class MyArrayDataException extends RuntimeException{

    public int[] sellIndex;

    public MyArrayDataException(int[] cellIndex) {
        super("Invalid data in array");
        this.sellIndex = cellIndex;
    }

    public int[] getSellIndex() {
        return sellIndex;
    }
}
