package JavaSE.day15;

/*
java.lang.Thread类实现多线程
每个Thread对象的run()方法写程序逻辑 start()方法自动调用run()启动线程
并行和并发区别 区别一： 并发是指一个处理器同时处理多个任务。 并行是指多个处理器或者是多核的处理器同时处理多个不同的任务。
单核CPU宏观上并行 微观上串行
多核心就是多个这样的情况一起 多核心宏观是并行 微观同时并行和并发...
线程生命周期：新建 就绪 运行 阻塞 死亡

实现Runnable接口的方式天然具有共享数据的特性（不用static变量）。
因为继承Thread的实现方式，需要创建多个子类的对象来进行多线程
如果子类中有变量A，而不使用static约束变量的话，每个子类的对象都会有自己独立的变量A，只有static约束A后，子类的对象才共享变量A。
而实现Runnable接口的方式，只需要创建一个实现类的对象，要将这个对象传入Thread类并创建多个Thread类的对象来完成多线程，而这多个Thread类对象实际上就是调用一个实现类对象而已。
实现的方式更适合来处理多个线程有共享数据的情况。
 */
class T1 extends Thread {
  // 方式一:继承Thread类
  // 子类重写run方法 生成子类对象 使用对象调用start方法生成线程
  // 逻辑代码存放在Thread子类的run方法中
  @Override
  public void run() {

    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " 继承Thread类的多线程运行中" + i + '\n');
    }
  }
}

class T2 implements Runnable {
  int count = 0; // 这样会共享count这个资源 两个线程的话最后就是count++到10
  // 方式二：实现Runable接口 这个方式较常用 避免单继承局限性
  // 逻辑代码存放在实现接口实现类的run方法中
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      count++;
      //            if(i%2==0)
      //            {
      //                Thread.yield();//线程让步 让给其他优先级相同或者更高的线程执行
      //            }
      System.out.println(Thread.currentThread().getName() + " 实现Runable接口的多线程运行中" + count + '\n');
      //            try {
      //                Thread.sleep(1000);//循环一次睡眠1000ms
      //            } catch (InterruptedException e) {
      //                throw new RuntimeException(e);
      //            }
    }
  }
}

public class thread1 {
  public static void main(String[] args) {
    //    Thread t1=new T1();
    //    t1.start();//这里的子线程和main就无关了 并行执行 多线程异步 并且可以声明多个对象启动多个子线程 都是互相异步
    Runnable run = new T2(); // 共享资源实现 看类中的conut属性
    Thread t2 = new Thread(run, "T2"); // 传递Runable实例
    System.out.println(t2.getName()); // 获取线程名称 如果创建对象时没有自定义线程名 会自动设置为Thread-0这种
    t2.setName("TTT2"); // 设置线程名
    System.out.println(t2.getName());

    Thread t3 = new Thread(run, "T3"); // 传递Runable实例

    // 设置线程优先级 哪个优先级高代表更可能被执行 优先级用数字1-10表示 数字越大优先级越高 默认优先级是5
    System.out.println(t2.getPriority()); // 获取优先级
    t2.setPriority(10); // 设置优先级

    t2.start();
    t3.start();
    System.out.println(t3.isAlive()); // 是否存活
    t3.stop(); // 强制停止线程
    System.out.println(t3.isAlive()); // 是否存活
    for (int i = 0; i < 10; i++) {
      System.out.println("------------" + i + '\n');
      if (i == 3) {
        try {
          t2.join(); // 这里的t2就必须在这里完全执行完 才能继续执行其他线程比如t3 阻塞其他线程（这里阻塞的是main方法）
          // 相当于将t2的run方法插入过来执行

        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
