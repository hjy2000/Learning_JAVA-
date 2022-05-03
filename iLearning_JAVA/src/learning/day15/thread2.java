package learning.day15;

class Account {
  static int money = 3000;

  public synchronized void withDraw(int m)
        // 同步的
      {
    //        synchronized(this){}//这个表示锁代码块 当前对象代码块中的是同步执行
    // ！！！注意 如果有别的方法里的代码块也用了这个synchronized(this) 对同一个对象加锁的代码来说是同一把锁
    // ！！！如果想要实现不是同一把锁 那要使用synchronized(对象) 对象是当前的Account对象
    if (this.money < m) {
      System.out.println("余额不足，现有余额为" + this.money);
    } else {
      System.out.println("现有金额：" + Thread.currentThread().getName() + this.money);
      this.money -= m;
      System.out.println("余额：" + Thread.currentThread().getName() + this.money);
    }
  }
}

class User implements Runnable {
  Account account;

  User(Account a) {
    this.account = a;
  }

  @Override
  public void run() {

    account.withDraw(2000);
  }
}

public class thread2 {
  public static void main(String[] args) {
    Account a = new Account(); // 只有这一个对象！
    User weixin = new User(a);
    User alipay = new User(a);
    Thread weixin1 = new Thread(weixin, "weixin");
    Thread alipay1 = new Thread(alipay, "alipay");
    weixin1.start();
    alipay1.start(); // 发现判断没卡住... 通过同步锁synchronized实现线程安全
    // 如果在普通方法加锁 锁住整个对象 不是某个方法 所以对同一个对象类里其他方法其实也是被同步的（同一个对象里所有加了sync的都用同一把锁） 如果声明两个不同对象对象锁也是不同的
    // 不同对象就还是有共享资源问题
    // 但是方法是static的话 那就直接锁住了类的所有实例...

    // wait notify notifyAll 在synchronized方法 或者代码块中才能用
    // wait表示放弃当前占用资源的锁（对象监控权） 给其他线程锁 notify代表唤醒
    // 注意 wait必须在拥有对象监控权才能调用（持有锁）
  }
}
