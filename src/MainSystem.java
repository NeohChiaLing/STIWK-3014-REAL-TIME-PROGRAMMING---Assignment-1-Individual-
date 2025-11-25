import java.util.Scanner;

public class MainSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryAnalysis analyzer = new DirectoryAnalysis(); // OOP

        System.out.println("--- Real Time Directory Analysis System ---");

        while (true) {
            System.out.print("Please enter the directory path: ");
            String inputPath = scanner.nextLine();

            try {
                analyzer.analyzePath(inputPath); //analysis sections, to check valid or not the directory

                System.out.println("\nThe Results:   ");
                System.out.println("Number of Java Files = " + analyzer.getJavaFileCount());
                System.out.println("Number of Issues     = " + analyzer.getIssueCount());

                break; // exit loop if all are valid

            } catch (Exception e) {
                System.out.println("Unexpected Error Founded: " + e.getMessage()); //error handling
                System.out.println("Please try again.\n");
            }
        }
    }
}