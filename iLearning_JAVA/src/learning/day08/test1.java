package learning.day08;

class Person {
  public void test() {
    System.out.println("这是Person类");
  }
}

class Student extends Person {
  public void getSchool() {
    System.out.println("这是Student类");
  }
}

class Order {
  int orderId;
  String orderName;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Order) {
      Order o = (Order) obj; // 这里要再看一下
      if (o.orderId == this.orderId && o.orderName == this.orderName) // 重写为属性相同则为相同
      {
        return true;
      }
    }
    return false;
  }
}

public class test1 {
  public static void main(String[] args) {
    //        new test1().t(ss);
    //        new test1().t2();
    Order o1 = new Order();
    Order o2 = new Order();
    System.out.println(o1.equals(o2)); // 重写了equals方法 返回true 不重写就是false
  }

  public void t(Person e) {
    if (e instanceof Student) {
      Student s = (Student) e; // 强转
      s.getSchool();
    } else {
      e.test();
    }
  }

  public void t1() {
    int i1 = 10;
    long i2 = i1; // 自动类型转换
    short i3 = (short) i1; // 报错 需要强制类型转换 大的转小的

    Student s = new Student();
    Person p = s; // 子类到父类的对象的自动类型转换 向上转型

    Person pp = new Student(); // 这里是向下转型 只能向下转到右边new的子类的类型否则运行时报错
    Student ss = (Student) pp; // 报错 需要父类到子类的强制类型转换 我们需要进行安全的向下转型，安全的向下转型是先把子类对象向上转型为父类，再将该父类强制转换为子类
    // 无继承关系的会报错
  }

  public void t2() {
    int i = 3;
    System.out.println(i == 3); // ==比较基本数据类型直接比较值 两边数据类型必须兼容（可以自动转换或者相同）
    Person p1 = new Person();
    Person p2 = new Person();
    System.out.println(p1 == p2); // false
    System.out.println(p1 == p1); // ==比较引用类型时只有同一个对象才会返回true
    System.out.println(p1.equals(p2)); // equals只能比较引用类型 非特殊情况下作用与==相同 这里为false

    String s1 = new String("abc");
    String s2 = new String("abc");
    System.out.println(s1.equals(s2)); // true
    System.out.println(s1 == s2); // false
    System.out.println(
        "abc"
            == "abc"); // true 这里直接“abc”是true 因为这里的abc是直接存在字符串常量池中的 第一次创建好abc以后 第二次发现有abc存在直接把地址给过去了
    // 所以==比较也是true
    // 但是在String、file、date对象中 重写了equals方法 导致使用equals比较这些对象时只比较内容不比较地址
    // 如果使用String s="abc"; 则这样首先在常量池中找有没有 没有就创建 有的话直接赋值地址 后面再有这样的赋值的话 直接赋值地址过去 不再创建新的字符串
    // 但是 如果使用String s=new String("abc");的话 是在常量池中寻找abc 没有的话在池子里添加abc 然后在堆中创建一个abc字符串对象 将地址赋给s
    // 再次出现这种情况 常量池不再创建 但是还是会再创建一个abd对象 不一样的地址赋给栈中 很明显可以看到 不用new String更省内存..
    // String s="x"+"y"; 这样在常量池中直接创建xy然后将常量池xy的地址赋给s
    // String s=new String("x")+new String("x")+new String("y"); 这样的话在常量池中创建x和y对象
    // 然后在堆中创建xxy对象将地址赋给s（StringBuilder）
  }
}
