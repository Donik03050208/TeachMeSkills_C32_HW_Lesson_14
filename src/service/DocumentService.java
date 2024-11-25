package service;

import exception.InvalidDocumentException;
import utils.Constant;
import validator.DocumentValidator;

import java.io.*;

public class DocumentService {
    public static void processDocuments(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter validDocumentWriter = new BufferedWriter(new FileWriter(Constant.VALID_DOC_REPORT_PATH));
            BufferedWriter contractWriter = new BufferedWriter(new FileWriter(Constant.VALID_CONTRACT_REPORT_PATH));
            BufferedWriter invalidDocumentWriter = new BufferedWriter(new FileWriter(Constant.INVALID_DOC_REPORT_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                try {
                    DocumentValidator.validateDocument(line);

                    if (line.toLowerCase().startsWith(Constant.DOCNUM_NAME)){
                        validDocumentWriter.write(line);
                    } else if (line.toLowerCase().startsWith(Constant.CONTRACT_NAME)) {
                        contractWriter.write(line);
                    }
                } catch (InvalidDocumentException e) {
                    String invalidEntry = line + " - " + e.getMessage();
                    invalidDocumentWriter.write(invalidEntry + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
