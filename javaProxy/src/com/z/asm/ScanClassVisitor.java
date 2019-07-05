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
    public MethodVisitor visitMethod(int access, String name, String desc, String s2, String[] strings) {
        System.out.println("--visitMethod name---:"+name);
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, s2, strings);

        return new MyAdviceAdapter(Opcodes.ASM5, methodVisitor, access, name, desc);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {

        return super.visitAnnotation(s, b);
    }


    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    class  MySignatureVisitor extends SignatureVisitor{

        public MySignatureVisitor(int i) {
            super(i);
        }
    }
    class MyAdviceAdapter extends AdviceAdapter {

        protected MyAdviceAdapter(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
            super(i, methodVisitor, i1, s, s1);
        }


        boolean injection;

        int startTime;
        @Override
        public AnnotationVisitor visitAnnotation(String s, boolean b) {
            System.out.println("--MyAdviceAdapter visitAnnotation:" + s);

            if(Type.getDescriptor(MyInjection.class).equals(s)){
                injection = true;
            }


            return super.visitAnnotation(s, b);
        }

        @Override
        public void visitCode() {
            super.visitCode();
        }

        @Override
        public AnnotationVisitor visitTryCatchAnnotation(int i, TypePath typePath, String s, boolean b) {
            return super.visitTryCatchAnnotation(i, typePath, s, b);
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
