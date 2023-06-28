package chap3.section2;

public class TestClass {

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("run() Method 실행-1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run() Method 실행-2");
            }
        };

        process(r1);
        process(r2);
        process(()-> System.out.println("run() Method 실행-3"));

        // 정상적인 람다 표현식
        process(()-> System.out.println("run() Method 실행"));
        // 중괄호로 감싼 표현
        process(()->{
            System.out.println("run() Method 실행");
        });
        //한개의 void 메소드 호출은 중괄호로 감쌀 필요가 없다.
    }

    public static void process(Runnable r){
        r.run();
    }
}
