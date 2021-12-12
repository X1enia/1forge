package lesson12;

public class ArrayLesson {
    private String[][] array = new String[4][4];

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) throws MyArraySizeException {
        if (array.length > 4 || array[0].length > 4) {
            throw new MyArraySizeException("Неправильный размер массива.");
        }
        this.array = array;
    }

    public int getSum() throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                String value = array[i][j];
                try {
                    int l = Integer.parseInt(value);
                    sum += l;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage());
                }
            }
        }
        return sum;
    }
}
