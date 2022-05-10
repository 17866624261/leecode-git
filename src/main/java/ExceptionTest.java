public class ExceptionTest {
    public void method(){
        try {
            System.out.println("try");
            System.exit(0);
            return;
        }catch (Exception e){
            System.out.println("异常发生了");
        }finally {
            System.out.println("finally");
            System.out.println("异常处理后续的代码");
        }
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.method();
    }
}
