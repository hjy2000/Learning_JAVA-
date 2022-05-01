package learning.day09;
interface I1 // 接口
 {
  int i1 = 0; // 一定要初始化 因为接口的变量默认为 public static final定义 即默认就是常量

  void t1(); // 默认的方法是由public abstract修饰的 接口没有构造器 采用多重继承
}

interface I2 // 接口
 {
  int i2 = 0; // 一定要初始化 因为接口的变量默认为 public static final定义 即默认就是常量

  void t2(); // 默认的方法是由public abstract修饰的 接口没有构造器 可以采用多重实现
}

// 模板设计模式
abstract class Template {
  public final void time() {
    long start = System.currentTimeMillis();
    code();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  abstract void code();
}

class t extends Template {
  @Override
  void code() {
    int k = 0;
    for (int i = 0; i < 100000; i++) {
      k += 1;
    }
  }
}

class ttt {}

class III extends ttt implements I1, I2 {
  // 必须实现接口中所有的方法 如果不实现的话 其实就是一个抽象类 并且可以实现多个接口 注意 这里是实现不是继承
  // 并且 可以先继承类 再实现接口
  // 接口和抽象类相似 为什么用接口？
  // 抽象类增加了抽象方法 则子类需要同时改变内容实现新的抽象方法 否则子类会成为抽象类
  // 如果要新增方法 新建接口 子类有需要的话就去实现这个接口

  // 例子二
  // 会唱歌的厨子是个好老师 如果使用多层继承的话 中间的类会继承到不该有的父类的属性 被污染了 逻辑不对
  // 使用接口就很棒 搞一个老师类继承人类 然后做接口拓展功能 test6中实现一下
  @Override
  public void t1() {}

  @Override
  public void t2() {}
}

public class test5 {
  public static void main(String[] args) {
    t tt = new t();
    tt.time();
  }
}
