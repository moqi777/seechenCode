package day6;

import java.io.*;
import java.lang.reflect.*;
import java.sql.Connection;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/1 19:37
 **/
//通过一个类自定义的类  属性 任意  方法任意编写
//  通过反射获取类的所有属性和方法  然后 将获取的数据
//  写入到result.txt中  内容如下:
//  方法有:
//  属性有:
//  构造方法有:
public class Job2 {
    int sum;
    String name;

    public Job2(){}
    public Job2(int sum, String name) {
        this.sum = sum;
        this.name = name;
    }

    public void hello(){}
    public void byby(){}

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("./javaSE/src/day6/result.txt"); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw);){
            Class c = Class.forName("day6.Job2");
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getDeclaredMethods();
            Constructor[] constructors = c.getDeclaredConstructors();

            String fieldsString = "属性有：";
            for (Field field : fields) {
                String name = field.getName();
                Type type = field.getGenericType();
                fieldsString += "属性名："+name+",类型为："+type+";";
            }
            String methodsString = "方法有：";
            for (Method method : methods) {
                String name = method.getName();
                Class[] parameterTypes = method.getParameterTypes();
                String parameterTypesString = Arrays.toString(parameterTypes);
                Class returnType = method.getReturnType();
                methodsString += "方法名："+name+"，参数列表："+parameterTypesString+"，返回值类型："+returnType+"；";
            }
            String constructorsString ="构造方法有：";
            for (Constructor constructor : constructors) {
                String name = constructor.getName();
                Class[] parameterTypes = constructor.getParameterTypes();
                String parameterTypesString = Arrays.toString(parameterTypes);
                constructorsString += name+"，参数有："+parameterTypesString+"；";
            }

            bw.write(fieldsString+"\n"+methodsString+"\n"+constructorsString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

