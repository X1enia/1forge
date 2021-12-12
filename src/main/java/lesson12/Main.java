package lesson12;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        array[0] = new String[]{"5", "5", "5", "5"};
        array[1] = new String[]{"5", "5", "5", "5"};
        array[2] = new String[]{"5", "5", "5", "5"};
        array[3] = new String[]{"5", "5", "5", "5"};
        ArrayLesson lesson = new ArrayLesson();
        try {
            lesson.setArray(array);
            System.out.println(lesson.getSum());
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
