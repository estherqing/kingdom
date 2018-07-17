package springTest.basic;

public class AA {

	 /**
     * 静态方法
     */
    public synchronized static void staticMethod(){}
     
    /**
     * 实例方法
     */
    public synchronized void instanceMethod(){}
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
         
        //A实例的创建过程
        @SuppressWarnings("rawtypes")
		Class c = Class.forName("com.springTest.A");
       //@SuppressWarnings("unused")
		@SuppressWarnings("unused")
		AA a1 =  (AA) c.newInstance();
        @SuppressWarnings("unused")
		AA a2 = (AA) c.newInstance();
        @SuppressWarnings("unused")
		AA a3 =  (AA) c.newInstance();
         
 
    }

}