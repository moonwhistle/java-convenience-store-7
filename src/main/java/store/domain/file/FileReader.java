package store.domain.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileReader {

    private final List<List<String>> contents;

    public FileReader(String filePath) {
        this.contents = makeFileContents(filePath);
    }

    public List<List<String>> getContents() {
        return Collections.unmodifiableList(contents);
    }

    private List<List<String>> makeFileContents(String filePath) {
        List<List<String>> fileContents = new ArrayList<>();

        try(BufferedReader fileReader = new BufferedReader(new java.io.FileReader(filePath))){
            readFileContents(fileReader, fileContents);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 내용을 읽을 수 없습니다.");
        }

        return fileContents;
    }

    private void readFileContents(BufferedReader fileReader, List<List<String>> fileContents) throws IOException {
        String line;
        skipOneLine(fileReader);

        while( (line = fileReader.readLine()) != null ) {
            List<String> splitLine = splitLine(line);
            fileContents.add(splitLine);
        }
    }

    private List<String> splitLine(String line) {
        return Arrays.stream(line.split(","))
                .toList();
    }

    private void skipOneLine(BufferedReader fileReader) throws IOException {
        fileReader.readLine();
    }
}
