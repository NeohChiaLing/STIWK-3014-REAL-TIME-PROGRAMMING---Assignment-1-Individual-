import java.io.File;

public class DirectoryAnalysis {
    private int javaFileCount;
    private int issueCount;

    public DirectoryAnalysis() {
        this.javaFileCount = 0;
        this.issueCount = 0;
    }

    public void analyzePath(String path) throws Exception {
        this.javaFileCount = 0;
        this.issueCount = 0;

        File folder = new File(path);
        if (!folder.exists()) {
            throw new IllegalArgumentException("The path does not exist. Please try again with correct path."); //error handling
        }
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("The path provided is not a directory. Please try again with correct path.");//error handling
        }

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) { //checking the list of files
                if (file.isFile()) {
                    checkFileTypes(file.getName());
                }
            }
        }
    }

    private void checkFileTypes(String fileName) {
        if (fileName.endsWith(".java")) { //counting any files any with .java
            javaFileCount++;
        }
        else if (fileName.contains("Issue") || fileName.endsWith(".txt")) { //counting any files any with .txt
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