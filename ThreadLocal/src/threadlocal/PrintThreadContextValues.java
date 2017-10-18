package threadlocal;

public final class PrintThreadContextValues {
	
	private PrintThreadContextValues() {
		//to prevent initialization
	}
	
    public static void printThreadContextValues(){
        System.out.println(ThreadContext.get());
    }
}
