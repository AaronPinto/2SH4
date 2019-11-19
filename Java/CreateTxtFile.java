import java.io.*;
import java.nio.file.Files;
import java.util.List;

// Used to create the text file submitted for quizzes
public class CreateTxtFile {
    public static void main(String[] args) throws IOException {
        File c = new File("C:\\Users\\aaron\\workspace\\2SH4\\Java\\Quizzes\\Course.java"),
            s = new File("C:\\Users\\aaron\\workspace\\2SH4\\Java\\Quizzes\\Student.java");

        List<String> txt = Files.readAllLines(c.toPath());
        txt.add("");
        txt.addAll(Files.readAllLines(s.toPath()));

        PrintWriter pw = new PrintWriter(new FileWriter("D:\\quiz9.txt", false));
        txt.forEach(pw::println);
        pw.flush();
    }
}
