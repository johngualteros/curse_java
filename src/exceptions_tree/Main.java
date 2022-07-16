package exceptions_tree;

public class Main {
    public static void main(String[] args) throws Exception{
        checkedException();
    }
    private static void finallyExample(){
        try {
            checkedException();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("End");
        }
    }
    private static void checkedTwoExceptions(boolean flag) throws Exception {
        if(flag){
            throw new Exception();
        }else{
            throw new RuntimeException();
        }
    }
    private static void checkedException() throws Exception {
        throw new Exception();
    }
    private static void exampleArithmeticException(){
        double number=10/0;
    }
}
