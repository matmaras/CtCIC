package threadlocal;

public class ThreadContext {
	 
    private String userId;
    private Long transactionId;
 
    private static ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected ThreadContext initialValue() {
        	System.out.println("new thread local");
            return new ThreadContext();
        }
    };
    
    public static ThreadContext get() {
    	System.out.println("im in get");
        return (ThreadContext) threadLocal.get();
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
 
    public String toString() {
        return "userId:" + userId + ",transactionId:" + transactionId;
    }
}
