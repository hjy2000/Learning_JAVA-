package learning.day09;
// final修饰类 则不可继承
// final修饰方法 则子类不可对其重写
// final修饰变量 则值不可修改 即为常量 常为全大写 必须显式初始化
// 若 final static修饰 则为静态常量 即全局常量
final class finalll {}

// class finllll extends finalll//不合法 final关键字修饰的类不能被继承
class l {}

class t1 {
  static int tttt;

  static {
    System.out.println("运行了静态代码块1"); // 多用于静态类属性初始化
    //        ttt=123;//非法 静态代码块无法使用非静态属性
    tt1(); // 静态代码块中只可以调用静态方法和使用静态属性
  }

  static {
    System.out.println("运行了静态代码块2"); // 静态代码块优先于非静态代码块执行
  }

  int ttt;

  {
    System.out.println("运行了非静态代码块1");
  }

  {
    ttt = 123; // 合法
    System.out.println("运行了非静态代码块2"); // 多个代码块按照顺序执行
  }

  // 最先是在堆中生成对象 并给对象属性赋默认值
  t1() {
    t1.tttt = 12345;
    System.out.println("调用了构造器"); // 最后执行 给属性赋值
  }

  public static void tt1() {
    System.out.println("这是tt1方法");
  }
}

class inner {
  int i;
  private int j;

  public void useA() {
    new A().set(); // 掉用内部类函数
  }

  public void showA() {
    System.out.println(i + j + new A().i); // 外部类使用内部类对象 先new
  }

  class A
  // 内部类 可以声明为final类型 也可以用private、protected修饰 也可以用static修饰（不能使用外层类的非静态变量和方法）
  // 可以声明为abstract 被其他内部类继承 主要解决不能多重继承的问题
  {
    int i = 3;

    public void set() {
      inner.this.i = 1;
      inner.this.j = 2;
    }
  }
}

public class test1 {
  public static void main(String[] args) {
    t1 tt1 = new t1();
    t1 tt2 = new t1(); // new多个对象时静态代码块只执行一次 非静态每次都执行

    inner ii = new inner();
    ii.useA();
    ii.showA();
  }
}
