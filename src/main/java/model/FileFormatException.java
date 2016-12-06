package model;

@SuppressWarnings("ALL")
class FileFormatException extends Exception {
    private String line;

    public FileFormatException(String str) {
        line = str;
    }

    public String getOriginalLine() { return line; }
}
