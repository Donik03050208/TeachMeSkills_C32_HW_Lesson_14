import service.DocumentService;

import java.io.File;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        DocumentService.processDocuments(fileName);
    }
}
