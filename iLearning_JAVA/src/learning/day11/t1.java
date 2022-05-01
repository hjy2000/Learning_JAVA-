package learning.day11;
// 泛型 JDK5 保证类型安全 只在编译阶段生效 运行时泛型信息会被擦除

interface I<T> {
  T test(T t);
}

class A<T> // 泛型任意取名
{
  // 泛型类
  private T key;

  public void set(T key) {
    this.key = key;
  }

  public T get() {
    return this.key;
  }
}

class B1<T> implements I<T> // 如果不传入实参类型 B右边要加<T>
// 如果传入了具体类型 B右边就不加<T>
{
  @Override
  public T test(T t) {
    return null;
  }
}

class B2 implements I<String> {
  // 发现T被替换 且B2不加<T>
  @Override
  public String test(String s) {
    return null;
  }
}

class C1<E> {
  E e;
  //    static E e1;//泛型不能static
  public static void test4() {
    //        System.out.println(this.e);//报错 无法从 static 上下文引用 'learning.day11.C1.this' 如果真要用
    // 也只能用在这个静态方法上定义的泛型
  }

  public <T> void test(T t) // 泛型方法
      {
    T ttt = t;
    System.out.println(this.e); // 可以使用泛型属性
    System.out.println(ttt);
  }

  public <T> T test1(T t2) {
    T t = t2;
    return t;
  }

  public <T> T test2(T... t) // 可变参数泛型方法
      {
    for (T tt : t) {
      System.out.println(tt);
    }
    return (T) t;
  }
}

public class t1 {
  public static void main(String[] args) {
    //    A<String> a=new A<String>();
    //    a.set("hjy");//这时候因为设置的泛型是String 所以T key需要的就是String类型
    //        A a1=new A();//
    //        a1.set(new Object());//这时候因为没有设置泛型是所以T就是Objetc类型
    //        //如果new的时候泛型类型不同 则对象不能相互赋值
    //        B1 b1=new B1();//默认为Object泛型
    //        B2 b2=new B2();//这里没办法指定泛型 否则会报错

    C1 c = new C1();
    c.test("hjy");
    c.test1(123);
    c.test2(1, 2, 3, 4, 5);
  }
}
