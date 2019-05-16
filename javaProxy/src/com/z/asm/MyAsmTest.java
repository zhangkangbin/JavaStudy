package com.z.asm;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

/**
 * User: zhangkb
 * Date: 2019/5/16 0016
 * Time: 下午 2:54
 */
public class MyAsmTest extends AdviceAdapter {

    protected MyAsmTest(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
        super(i, methodVisitor, i1, s, s1);
    }

    int startTime;

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        startTime = newLocal(Type.LONG_TYPE);
        mv.visitMethodInsn(INVOKEDYNAMIC,"","","",false);
        mv.visitIntInsn(LSTORE, startTime);
        //   methodVisitor.visitMethodInsn();
    }

    public void print() {
        System.out.println("hi");
    }
}
