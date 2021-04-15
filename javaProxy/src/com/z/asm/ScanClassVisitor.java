package com.z.asm;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import jdk.internal.org.objectweb.asm.signature.SignatureVisitor;

/**
 * User: zhangkb
 * Date: 2019/5/21 0021
 * Time: 上午 10:29
 */
public class ScanClassVisitor extends ClassVisitor {


    public ScanClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public void visitSource(String s, String s1) {
        super.visitSource(s, s1);
    }

    /**
     * 访问有个方法
     * @param access
     * @param name
     * @param desc
     * @param s2
     * @param strings
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String s2, String[] strings) {
        System.out.println("--visitMethod name---:"+name);
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, s2, strings);

        //访问方法里面，方法适配器。
        return new MyAdviceAdapter(Opcodes.ASM5, methodVisitor, access, name, desc);
    }



    public class MyClassVisitor extends ClassVisitor {

        public MyClassVisitor(int i) {
            super(i);
        }

        @Override
        public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
            return super.visitMethod(i, s, s1, s2, strings);
        }
    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {

        return super.visitAnnotation(s, b);
    }


    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    /*
    方法适配器
    泛型与注解
     */
    class  MySignatureVisitor extends SignatureVisitor{

        public MySignatureVisitor(int i) {
            super(i);
        }
    }
    /*
    AdviceAdapter
    这个方法适配器是一个抽象类，可用于在一个方法的开头以及恰在任意 RETURN 或 ATHROW
指令之前插入代码。它的主要好处就是对于构造器也是有效的，在构造器中，不能将代码恰好插
入到构造器的开头，而是插在对超构造器的调用之后。事实上，这个适配器的大多数代码都专门
用于检测对这个超构造器的调用。
     */
    class MyAdviceAdapter extends AdviceAdapter {

        protected MyAdviceAdapter(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
            super(i, methodVisitor, i1, s, s1);
        }


        boolean injection;

        int startTime;
        @Override
        public AnnotationVisitor visitAnnotation(String s, boolean b) {
           // System.out.println("--MyAdviceAdapter: visitAnnotation:" + s);
            if(Type.getDescriptor(MyInjection.class).equals(s)){
                injection = true;
            }

            return super.visitAnnotation(s, b);
        }

        @Override
        public void visitFieldInsn(int i, String s, String s1, String s2) {
            super.visitFieldInsn(i, s, s1, s2);
         //   System.out.println("--MyAdviceAdapter visitFieldInsn:" + s);
        }



        @Override
        public void visitMethodInsn(int i, String s, String s1, String s2, boolean b) {
            super.visitMethodInsn(i, s, s1, s2, b);

            System.out.println("--MyAdviceAdapter visitMethodInsn:" + s);
        }

        @Override
        public void visitCode() {
            super.visitCode();
        }


        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            if(!injection) {
                return;
            }

            System.out.println("写入代码");
            startTime=newLocal(Type.LONG_TYPE);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(LSTORE, startTime);





        }


        @Override
        protected void onMethodExit(int i) {
            super.onMethodExit(i);
            System.out.println("2--onMethodExit");

            if(!injection) {
                return;
            }
            /**
             * java -classpath asm-all-5.2.jar org.objectweb.asm.util.ASMifier Test.class
             * 这一大堆由上面的命令生成，生成的有点坑。
             * @param i
             */
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(LSTORE, 3);

            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitLdcInsn("-------cost time:----------");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitVarInsn(LLOAD, startTime);
            mv.visitInsn(LSUB);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

   /*         mv.visitInsn(RETURN);
            mv.visitMaxs(6, 5);
            mv.visitEnd();
*/

        }
    }
}
