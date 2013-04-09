package demo.closureDemo;

/**
 * java模拟闭包
 * @author xuyuji
 *
 */
public class ClosureDemo {  
    public static void main(String[] args)throws Exception {  
        Person p = new Person(20);  
          
        IMethod m = p.getClosualMethod();  
        Object o = m.invoke();  
        System.out.println(o);  
          
        IMethod m2 = p.getClosualMethod2();  
        m2.invoke("Tom");
    }  
      
  
}  