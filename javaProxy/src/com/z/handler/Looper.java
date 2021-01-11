package com.z.handler;

/**
 * 主要是循环去取消息
 * zkb
 */
public class Looper {

    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    public MessageQueue queue ;
    private Looper() {
        queue = new MessageQueue();
    }

    public static void initLooper() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    public static Looper getLooper() {
        return sThreadLocal.get();
    }


    public static void loop() {

        Looper me = getLooper();
        //参考Looper中取消息的写法
        for (; ; ) {
            //没有消息这里就会一直阻塞，有消息就取出来。
            //阻塞会释放系统资源，这里要涉及到一些操作系统知识，等我先去补习几天操作系统的知识先。
            /**
             * 状态四个
             * 执行，就绪，阻塞（或叫等待），死亡。不同的系统可能不同，一般都大同小异。
             * 阻塞状态:进程因发生某种事件（例如I/O请求、申请缓冲空间等）而暂停执行时的状态，亦即进程的执行受到阻塞，
             * 故称这种状态为阻塞状态，有时也称“等待”状态或“睡眠”状态。通常将处于阻塞状态的进程排成一个队列，
             * 称为阻塞队列。在有的系统中，按阻塞的原因不同而将处于阻塞状态的进程排成多个队列。
             * 把进程比作人，
             * 这里用单核操作系统说明，比如你6个人用一个洗手间，为啥是一个洗手间呢，因为多进程在微观上面是交替执行的。所以6个人轮流使用一个洗手间，这就叫多线程发执行，
             * 由于系统是时间切片，即每个人只能用一会，比如这里是30秒，就得换下一个了。这个时候拉到一半怎么办？这个时候就需要你夹断了
             * （这就是系统中断机制，进程管理块PCB,会保存这个人拉到那里了，等待下次再上洗手间）。然后接着下一个，以此类推。其实这样很浪费资源的，
             * 如果其中三个人其实是不急的或者根本没有需求，进去也是，浪费资源。所以这个时候就出现优化，没有需求，先在外面等着。（这就是阻塞状态了），
             * 把这个三个人放到阻塞队列，这时洗手间压力减轻一半，可以愉快上个洗手间了。等他们有需求再从新排队，在接着.....
             * 就是阻塞状态变成就绪状态，排队，等待系统分配时间片-执行状态。）
             *加入线程概念，一个进程可以有多个线程，增加效率，因为切换进程开销大。好比，你把三个人放到厕所里面，即马桶边上，这个过程少了开关门的步骤，是不是更加有效率了，手动微笑。
             */
            Message message = me.queue.next();
            //System.out.println("----loop----"+queue.size());
            /*
             * loop怎么知道是哪个Handler，给哪个发消息 ？
             * 所以消息里面带有 handle 对象。问题迎刃而解
             */
            if (message.target != null) {
                message.target.dispatchMessage(message);
            }

            System.out.println(message.message);

        }
    }
}
