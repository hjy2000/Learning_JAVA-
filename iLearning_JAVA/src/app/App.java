package app;

public class App {
  public static void main(String[] args) throws Exception {
    App a = new App();
    a.func1();
    a.func2(); // 静态方法调用非静态方法必须通过对象调用
    // a.func3();
    // func3();//静态调用静态可以直接调用也可以用对象调用
    a.func4();
  }

  static void func3() {
    App aa = new App();
    int l[] = new int[3];
    int ll[] = new int[] {1, 2, 3, 4}; // 动态初始化int数组元素默认值为0
    int lll[] = {1, 2, 3, 4};
    l[0] = 1;

    for (int i = 0; i < 3; i++) {
      System.out.println(lll[i]);
    }
    System.out.println(lll.length);
    //        aa.func4();
  }

  public void func1() {
    short s = 1;
    byte b = 2;
    String ss = "hello" + 1 + 2;
    String sss = 1 + 2 + "hello";
    System.out.println(s + b);
    System.out.println(ss);
    System.out.println(sss);
  }

  void func2() {
    int k = 7;
    byte kk = (byte) k;
    int i = 1;
    i *= 0.1;
    System.out.println(i);
    System.out.println(4 == 5);
    System.out.println(-8 >> 2);
    System.out.println(-8 >>> 2);
    System.out.println(4 & 5);
    System.out.println(~4);
    System.out.println(4 > 5 ? 4 : 5);
  }

  void func4() {
    int ii[][] = new int[3][3];
    int iii[][] = new int[3][3];
    ii = iii; // 赋值传地址
    // 可以使用for循环传值赋值
    // 数组之间的赋值是传递的地址，复制才是传递的值。
    func3();
  }
}
