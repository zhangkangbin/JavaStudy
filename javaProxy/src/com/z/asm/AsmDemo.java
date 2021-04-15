package com.z.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.*;
import java.lang.reflect.Method;

/**
 * User: zhangkb
 * Date: 2019/5/16 0016
 * Time: 下午 2:52
 * Asm文档地址
 * https://asm.ow2.io/
 */
public class AsmDemo implements Serializable {

    public static void main(String[] s) {

       writeCode();

    }

    private static void writeCode() {
        File file = new File("javaProxy/Test2.class");
        System.out.println(file.getAbsolutePath());

        try {
            InputStream inputStream = new FileInputStream(file);
            //读取文件
            ClassReader reader = new ClassReader(inputStream);

            //class写
            ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);

            //扫描并写入
            ScanClassVisitor cv = new ScanClassVisitor(Opcodes.ASM5, writer);
            reader.accept(cv, ClassReader.EXPAND_FRAMES);


            byte[] code = writer.toByteArray();


            MyClassLoader myClassLoader = new MyClassLoader();
            //装置修改后的类
            Class<?> test = myClassLoader.defineClass("com.z.asm.Test", code);
            Object object=test.newInstance();
            //反射方法
            Method method = test.getMethod("test1");

            method.invoke(object);

            //拷贝一份
            FileOutputStream fileOutputStream = new FileOutputStream("Test.class");
            fileOutputStream.write(code);
            fileOutputStream.close();
            inputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
