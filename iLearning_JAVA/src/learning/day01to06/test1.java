package learning.day01to06;

public class test1 {

  public static void swap(t t2) {
    t2.a = 12;
  }

  public static void main(String args[]) {
    t t1 = new t();
    System.out.println(t1.a);
    test1.swap(t1);
    System.out.println(t1.a);
  }
}
// 纠正： 这里对象作为函数参数也是传值（变量在栈中的值，若是对象则值为对象在堆中的地址） 不是传地址 只不过值是对象在堆中的地址
class t {
  public int a;
}
// 包相当于文件夹 不同包可以有同一个名称的.java文件 使用.分隔包的层级 包可以嵌套
// 使用import标明使用哪个包的哪个类
