package JavaSE.day09;
// 内部类实现了类似的多重继承功能
class A {
  public void AA() {
    new BB().tB();
    new CC().tC();
  }
  // A想同时获得B、C的方法或者属性（类似于多重继承）
  private class BB extends B {
    @Override
    public void tB() {
      System.out.println("重写的tB");
    }
  }

  private class CC extends C {
    @Override
    public void tC() {
      System.out.println("重写的tC");
    }
  }
}

class B {
  public void tB() {
    System.out.println("这是tB方法");
  }
}

class C {
  public void tC() {
    System.out.println("这是tC方法");
  }
}

public class test2 {
  public static void main(String[] args) {
    A a = new A();
    a.AA();
  }
}
