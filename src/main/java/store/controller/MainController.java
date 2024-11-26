package store.controller;

import java.util.List;
import store.domain.file.FileReader;

public class MainController {

    private final String filePath;

    public MainController(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        FileReader fileReader = new FileReader(filePath);
        for(List<String> ss : fileReader.getContents()){
            System.out.println(ss);
        }
    }
}
