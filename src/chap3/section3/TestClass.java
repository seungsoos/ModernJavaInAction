package chap3.section3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClass {

    // 파일 한행을 읽음.
    public String processFile() throws IOException {
        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();       // 실제 필요한 작업을 하는 행
        }
    }

    // 파일 두행을 읽도록 수정
//    String result = processFile((BufferedReader br) -> {return br.readLine() + br.readLine()});

    public String processFile2(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    //람다 표현
//    String oneLine = processFile((BufferedReader br) -> br.readLine());

//    String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
}
