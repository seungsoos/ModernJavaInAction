package chap3.section3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {

    public String processFile() throws IOException {
        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();       // 실제 필요한 작업을 하는 행
        }
    }
}
