package validator;

import exception.InvalidDocumentException;
import utils.Constant;

public class DocumentValidator {
    public static void validateDocument(String documentNumber)
            throws InvalidDocumentException {
        if (documentNumber.length() != Constant.DOCUMENT_LENGTH) {
            throw new InvalidDocumentException("Incorrect document number length");
        }
        if (!documentNumber.toLowerCase().startsWith(Constant.DOCNUM_NAME) && !documentNumber.toLowerCase().startsWith(Constant.CONTRACT_NAME)) {
            throw new InvalidDocumentException("Incorrect sequence of characters at the beginning of the document number");
        }
        if (!documentNumber.matches("^[a-zA-Z0-9]+$")) {
            throw new InvalidDocumentException("Incorrect characters");
        }
    }
}
