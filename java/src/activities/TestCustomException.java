package activities;

public class TestCustomException {
    public static void main(String[] a){
        try {
            // Method call with correct input
        	TestCustomException.exceptionTest("Will print to console");
            // Method call with incorrect input
        	TestCustomException.exceptionTest(null); // Exception is thrown here
        	TestCustomException.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }
 
    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}

