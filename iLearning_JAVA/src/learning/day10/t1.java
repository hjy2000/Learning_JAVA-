package learning.day10;
// 异常分为 error错误（JVM错误、内存耗尽） 和excepttion异常 （IO/运行时异常）
// 异常处理 try catch到后throw
class A {
  int i;
  int age;

  public void test() throws NullPointerException // 方法抛出异常 让catch去捕获
      {
    A b = new A();
    System.out.println(b.i); // 空指针
  }

  public void test1(int age) throws Exception // 抛出
      {
    if (age > 0 && age <= 150) {
      this.age = age;
      System.out.println(age);
    } else {
      throw new Exception("年龄不符合要求"); // 这里将异常对象抛给函数 函数再抛出给上一级
    }
  }

  public void test2(int age) throws Exce // 抛出自定义异常
      {
    if (age > 0 && age <= 150) {
      this.age = age;
      System.out.println(age);
    } else {
      throw new Exce("年龄不符合要求喔"); // 抛出自定义异常
    }
  }

  class B extends A {
    //    @Override
    //    public void test() throws Exception//这里子类重写方法抛出的异常不能比父类的范围大
    //    {
    //
    //    }
  }
}

class Exce extends Exception {
  Exce(String e) {
    super(e);
  }
}

public class t1 {
  public static void main(String[] args) { // main方法也可以抛出异常 但是直接抛给了虚拟机.....
    try {
      A a = null;
      System.out.println(a.i); // 空指针异常
      String s[] = new String[] {"a", "b", "c"};
      System.out.println(s[3]); // 数组越界异常
      // 这里按顺序执行 第一个异常出现直接跳Catch 所以没有第二个异常
    } catch (ArrayIndexOutOfBoundsException e1) {
      //            e.printStackTrace();//异常发生时跟踪堆栈情况
      System.out.println(e1.getMessage()); // 得到异常信息
    } catch (NullPointerException e2) {
      System.out.println(e2.getMessage());
    } finally {
      System.out.println("Finally");
    }

    try {
      A aa = null;
      aa.test();
    } catch (Exception e) {
      e.printStackTrace(); // 跟踪到栈中异常信息
    }

    try {
      A aa = new A();
      aa.test1(1000); //
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      A aa = new A();
      aa.test2(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //        int aa = 1 / 0;//除数为0异常 / by zero
}
