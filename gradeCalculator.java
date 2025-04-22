import java.util.Scanner;

public class gradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        double[] scores = new double[numSubjects];
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }
        
        // Calculate the average grade
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        double average = total / numSubjects;
        
        // Display the average grade to the user
        System.out.println("The average grade is: " + average);
        
        // Close the scanner
        scanner.close();
    }
}
