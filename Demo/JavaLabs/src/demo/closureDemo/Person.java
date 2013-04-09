package demo.closureDemo;

import java.util.Calendar;
import java.util.Date;

public class Person {  
    
    private int age = 0;  
      
    public Person(int age) {  
        super();  
        this.age = age;  
    }  
      
    public IMethod getClosualMethod(){  
        final int i = 10;  
          
        Object o = new Object(){  
            Date getBirthday(){  
                Calendar c = Calendar.getInstance();  
                c.set(Calendar.YEAR,c.get(Calendar.YEAR) - (age+i));  
                return c.getTime();  
            }  
        };  
          
        MethodObject mo = new MethodObject(o,"getBirthday");  
        return mo;  
    }
    
    public IMethod getClosualMethod2(){
        Object o = new Object(){  
            void getAge(String name){  
                System.out.println("hello " + name + ", I am " + age + " years old");  
            }  
        };
          
        MethodObject mo = new MethodObject(o,"getAge");  
        return mo;  

    }
}  
