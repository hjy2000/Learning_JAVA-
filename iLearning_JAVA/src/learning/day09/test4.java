package learning.day09;
// 静态方法不能被重写 如果子类定义返回值及参数完全相同的方法 则父类的方法将被屏蔽 而不是重写
// 在Java继承关系中，如果子类和父类中各有一个static方法，且它们的返回值类型、方法名、参数列表都相同，那么这两个static方法并不具有重写关系。
// A是B的子类 B b = new A()可以理解为父类(B)的引用(b)指向了子类(A)的对象，即b指向new A()
// 这是子类类型转父类类型，属于向上转型，在这个过程中，子类的test()方法丢失，最终b.test()执行的是父类的test()方法，所以没有实现方法重写。
// abstract可以修饰类或者方法 不能修饰属性 私有方法 构造器 静态方法 final修饰的 即不能修饰不能被继承的东西
abstract class Animal {
  Animal() {}
  ; // 可以有构造器 但是还是不能new

  public abstract void test(); // 有抽象方法 类就必须是抽象类

  public abstract void move();
}

abstract class e {
  int salary;
  String name;
  int id;
  e() {}

  public abstract void work();
}

class manager extends e {
  int bonus;

  @Override
  public void work() {
    System.out.println("经理在工作");
  }
}

class worker extends e {
  public void set() {
    super.id = 1;
    super.name = "hjy";
    super.salary = 1000;
  }

  @Override
  public void work() {
    System.out.println("员工在工作");
  }
}

class Dog extends Animal {

  @Override
  public void test() {
    System.out.println();
  }

  @Override
  public void move() {
    System.out.println("狗在跑");
  }
}

class Fish extends Animal // 必须重写实现抽象方法
{

  @Override
  public void test() {}

  @Override
  public void move() {
    System.out.println("鱼在游");
  }
}

public class test4 {
  public static void main(String[] args) {
    Dog d = new Dog();
    Fish f = new Fish();
    worker w = new worker();
    w.set();
  }
}
