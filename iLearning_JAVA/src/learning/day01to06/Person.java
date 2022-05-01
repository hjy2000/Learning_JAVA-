package learning.day01to06;

class ppp {
  static String sex = "男";
  String name; // 类成员变量可以不初始化
  int age;
  private int test;

  public ppp(String s, int i, int t) {
    name = s;
    age = i;
    test = t;
  }

  public void showInfo(String s) {
    System.out.println(name + age + test);
    System.out.println(s);
  }

  public int getAge() {
    return age;
  }
}

public class Person {
  public static void main(String args[]) {
    // 局部变量需要初始化 在栈中 不指定权限修饰符
    ppp p = new ppp("hjy", 18, '1');
    p.showInfo("niubi");
    System.out.println(ppp.sex);
    //        p.test; 这样写不行
  }
}
