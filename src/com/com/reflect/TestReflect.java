package com.com.reflect;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * 测试反射的相关用法
 * Created by 浮生若梦 on 2017/3/6.
 */
public class TestReflect{
    public TestReflect(String s) {
        System.out.println("s:"+s);
    }
    public static void main(String[] args) throws Exception{
//        TestReflect testReflect = new TestReflect("s0");
//        System.out.println(testReflect.getClass().getName());
//        testInstance();
//        testRefFiled();
//        testRefMethod();
//        testRefInvokeMethod();
        testRefUpdFiled();
        testRefApply();
    }

    /**
     * 测试反射实例应用：为一个Integer的ArralyList添加一个String类型的数据-->正常用法是无法做到的
     * -->解析：泛型的作用层在编译时，运行时会被擦除，
     * 而反射在运行时获得add方法，并直接在其中添加数据，跳过了编译器
     */
    private static void testRefApply() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list,"反射应用实例");
        System.out.println("list.get(0):"+list.get(0));

    }

    /**
     * 通过反射修改某个类的属性
     */
    private static void testRefUpdFiled() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.com.reflect.User");
        Object obj = cls.newInstance();
        Field filed = cls.getDeclaredField("filed");
        filed.setAccessible(true);
        //可以直接设置私有属性的值
        filed.set(obj,"反射设置属性");
        System.out.println("filed:"+filed.get(obj));

    }

    /**
     * 测试利用反射调用类中的某个方法
     */
    private static void testRefInvokeMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> cls = Class.forName("com.com.reflect.User");
        Method method = cls.getMethod("toString");
        method.invoke(cls.newInstance());
        Method method2 = cls.getMethod("testMethod",int.class,String.class);
        method2.invoke(cls.newInstance(),20,"zs");
    }

    /**
     * 利用反射获取类中所有方法
     */
    private static void testRefMethod() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.com.reflect.User");
        Method[] methods = cls.getMethods();
        for(int i = 0;i<methods.length;i++){
            int mod = methods[i].getModifiers();
            String mods = Modifier.toString(mod);//限定符
            Class<?> retType = methods[i].getReturnType();
            Class<?>[] paras = methods[i].getParameterTypes();
            System.out.print(mods +" "+retType.getName()+" "+methods[i].getName()+"(");
            for (int j= 0;j<paras.length;j++) {
                System.out.print(paras[j].getName()+" arg"+j);
                if(j<paras.length-1){
                    System.out.print(",");
                }
            }
            //处理异常
            Class<?>[] exp = methods[i].getExceptionTypes();
            if(exp.length < 1){
                System.out.println(")");
            }else{
                System.out.println(") throws ");
                for (int k= 0;k<exp.length;k++){
                    System.out.print(exp[k].getName());
                    if(k<exp.length-1){
                        System.out.print(",");
                    }else{
                        System.out.println();
                    }
                }
            }
        }
    }

    /**
     * 获取类的所有属性 -- 修饰符 类型 属性名
     * @throws ClassNotFoundException
     */
    private static void testRefFiled() throws ClassNotFoundException {
        Class<?> class0 = Class.forName("com.com.reflect.User");
        Field[] fileds = class0.getFields();
        for(Field field: fileds){
            int mod = field.getModifiers();
            String mods = Modifier.toString(mod);//限定符
            System.out.println(mods+" "+field.getType().getName() +" "+ field.getName());
        }
    }

    /**
     * 实例化对象
     */
    private static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        //反射常用
        class1 = Class.forName("com.com.reflect.TestReflect");
        class2 = TestReflect.class;
        class3 = new TestReflect("s3").getClass();
        Constructor<?> con = class1.getConstructor(String.class);
        class1.getFields();//获取成员变量
        class1.getMethods();//获取所有方法
        class1.getConstructors();//获取构造方法
        class1.getAnnotations();
        //类有有参构造器时  反射的使用需要注意
        TestReflect cc2 = (TestReflect)con.newInstance("带参构造器");

        System.out.println("class name:"+class1.getName());
        System.out.println("class name:"+class2.getName());
        System.out.println("class name:"+class3.getName());
    }

}
class User{
    public int age;
    public String name;

    private String filed = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        System.out.println("this is toString method.");
        return "User:[age= "+age+" , name= "+name+"]";
    }
    public void testMethod(int age,String name){
        System.out.println("This is a test method.age:"+age+" name:"+name);
    }
}
