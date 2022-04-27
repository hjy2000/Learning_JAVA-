package learning.day09;
//静态方法不能被重写 如果子类定义返回值及参数完全相同的方法 则父类的方法将被屏蔽 而不是重写
//在Java继承关系中，如果子类和父类中各有一个static方法，且它们的返回值类型、方法名、参数列表都相同，那么这两个static方法并不具有重写关系。
//A是B的子类 B b = new A()可以理解为父类(B)的引用(b)指向了子类(A)的对象，即b指向new A()
// 这是子类类型转父类类型，属于向上转型，在这个过程中，子类的test()方法丢失，最终b.test()执行的是父类的test()方法，所以没有实现方法重写。
public class test4 {
    public static void main(String[] args) {

    }
}
