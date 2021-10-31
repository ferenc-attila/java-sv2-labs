package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        str = str.strip();
        char[] chars = str.toCharArray();
        return chars[chars.length - 1];
    }

    public String findFileExtension(String fileName) {
        fileName = fileName.strip();
        int startExtension = fileName.lastIndexOf(".") + 1;
        return fileName.substring(startExtension);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (ext.equalsIgnoreCase(findFileExtension(fileName))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean compareFilesByName(String searchedFileName, String actualFilename) {
        searchedFileName = searchedFileName.strip();
        actualFilename = actualFilename.strip();
        if (searchedFileName.equals(actualFilename)) {
            return true;
        } else {
            return false;
        }
    }

    public String changeExtensionToLowerCase(String fileName) {
        return fileName.replace(findFileExtension(fileName), findFileExtension(fileName).toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target) {
        fileName = fileName.strip();
        present = present.strip();
        target = target.strip();
        return fileName.replaceAll(present, target);
    }
}
