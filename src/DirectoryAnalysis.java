import java.io.File;

public class DirectoryAnalysis {
    private int javaFileCount;
    private int issueCount;

    public DirectoryAnalysis() {
        this.javaFileCount = 0;
        this.issueCount = 0;
    }

    public void analyzePath(String path) {
        File folder = new File(path);

        if (!folder.exists()) {
            System.out.println("Error: The path does not exist."); //error handling
            return;
        }
        if (!folder.isDirectory()) {
            System.out.println("Error: This is a file, not a directory.");//error handling
            return;
        }
        File[] listOfFiles = folder.listFiles(); //listout all the files

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    checkFileTypes(file.getName());
                }
            }
        }
    }

    //categorize file sections (differentiate between .java and .txt file
    private void checkFileTypes(String fileName) {
        // Check for Java files
        if (fileName.endsWith(".java")) {
            javaFileCount++;
        }
        //any file end with .txt is equal to issue files
        else if (fileName.contains("Issue") || fileName.endsWith(".txt")) {
            issueCount++;
        }
    }

    //getter sections
    public int getJavaFileCount() {
        return javaFileCount;
    }

    public int getIssueCount() {
        return issueCount;
    }
}