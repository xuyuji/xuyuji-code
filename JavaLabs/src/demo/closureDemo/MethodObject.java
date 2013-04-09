package demo.closureDemo;

import java.lang.reflect.Method;  

public class MethodObject implements IMethod {  
      
    private Object target;//闭包所依赖的对象  
      
    private String methodName;//闭包方法的名字  
      
    public MethodObject(){}  
  
    public MethodObject(Object target, String methodName) {  
        super();  
        this.target = target;  
        this.methodName = methodName;  
    }  
  
    public Object invoke(Object... objects) {  
        Class clazz = target.getClass();  
        try {  
            Method[] ms = clazz.getDeclaredMethods();  
              
            Method targetMethod = null;  
            for(Method m : ms){  
                if(methodName.equals(m.getName())){  
                    targetMethod = m;  
                    break;  
                }  
            }  
            targetMethod.setAccessible(true);  
            return targetMethod.invoke(target, objects);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            throw new RuntimeException(e);  
        }   
    }  
      
    public void rebund(Object anothertarget){  
        target = anothertarget;  
    }  
      
  
}  