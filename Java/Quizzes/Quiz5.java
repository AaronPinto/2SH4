package Quizzes;

public class Quiz5 {
    public static void main(String[] args) {
        int[][] myArray;
        myArray = new int[10][];
        for (int i = 0; i < myArray.length; i++)
            myArray[i] = new int[5 * i + 1];
        int count = 0;
        for (int i = 0; i < myArray.length; i++)
            count += myArray[i].length;
        System.out.println("Total: " + count + " Integers");
    }
}
