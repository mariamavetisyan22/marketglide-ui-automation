package utils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Utils {

    public static void cleanTheAllureResults() {
        final Path folderPath = Paths.get("allure-results");
        try {
            // Walk the directory and delete files
            Files.walkFileTree(folderPath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);  // Delete the file
                    return FileVisitResult.CONTINUE;
                }

            });
            System.out.println("Files deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
