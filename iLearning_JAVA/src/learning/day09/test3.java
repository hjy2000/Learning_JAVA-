package learning.day09;
// 匿名内部类中代码块的作用时代替构造函数初始化或者给类属性重新赋值
class ppp {
  int age;

  public void test() {
    System.out.println("ppp类test方法");
  }
}

public class test3 {
  public static void main(String[] args) {
    // 匿名内部类 其实这是ppp的匿名子类
    ppp pp =
        new ppp() {
          {
            this.age = 20; // 代码块代替构造器实现匿名内部类属性初始化（没有构造器）
          }

          @Override
          public void test() {
            System.out.println("重写后的test方法");
          }
        };

    System.out.println(pp.age);
  }
}
