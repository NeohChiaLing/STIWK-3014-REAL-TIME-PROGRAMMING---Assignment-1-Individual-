import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Directory Analysis System ---");
        System.out.print("Please enter the directory path: ");

        String inputPath = scanner.nextLine();  // read user input

        DirectoryAnalysis analyzer = new DirectoryAnalysis();

        try {
            analyzer.analyzePath(inputPath); //analysis section

            System.out.println("\n--- Analysis Result ---");
            System.out.println("Number of Java Files = " + analyzer.getJavaFileCount());
            System.out.println("Number of Issues     = " + analyzer.getIssueCount());

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage()); //error handling
        }
    }
}