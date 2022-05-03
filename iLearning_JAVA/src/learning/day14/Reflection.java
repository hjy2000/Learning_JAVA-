package learning.day14;
// 通过反射reflection JVM可以通过类名找到类的具体信息 前提是内存中加载了这个类
// 反射主要API java.lang.class java.lang.reflect.method java.lang.reflect.filed
// java.lang.reflect.constructor
// 代表类 类方法 类属性 构造器

import java.lang.reflect.*;

interface I1 {

  public void t1();
}

interface I2 {
  public void t2();
}

class I implements I1, I2 {

  @Override
  public void t1() {
    System.out.println("I1");
  }

  @Override
  public void t2() {
    System.out.println("I2");
  }
}

class proxy implements InvocationHandler {
  // 需求：在方法执行前打印方法开始执行 执行完毕后打印执行完毕  且其中方法名需要对应
  Object obj; // 被代理的对象 一个对象要被代理 那就要有实现的接口和实现类？？

  public proxy(Object o) {
    this.obj = o; // 传值
  }

  public void out() {}

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(method.getName() + "开始执行");
    Object rs = method.invoke(this.obj, args);
    System.out.println(method.getName() + "执行完毕");
    return rs;
  }
}

class Person {
  String s;
  int a;
}

class Student extends Person implements I1, I2 {
  String school;
  private int i;

  protected Student(double d) {
    System.out.println(d);
  }

  public Student() {}

  Student(String s) {
    this.school = s;
  }

  private Student(int a) {
    System.out.println(a);
  }

  private Student(int a, int b) {
    System.out.println(a + b);
  }

  public void show() {
    System.out.println(this.school);
  }

  private void show1(int a) {
    System.out.println("private");
  }

  double show2(double b) {
    System.out.println(b);
    return b;
  }

  @Override
  public void t1() {
    System.out.println("学习");
  }

  @Override
  public void t2() {
    System.out.println("跑步");
  }
}

class test {
  public void t() throws ClassNotFoundException {
    Person p = new Person();
    Class clazz = p.getClass();
    // 这里class的C是大写 返回类名 class类 这个方法是在object类中定义的 每个类在JVM中只有一个Class类实例
    // 即每个class对象对应一个.class文件 通过Class能够得到一个类的完整信息
    System.out.println(clazz);

    // 创建基本方式
    // 类名创建
    Class c1 = Person.class;
    // getClass方法 通过实例创建
    Class clazzz = p.getClass();
    // 通过Class.forname方法创建 需要抛出异常（找不到这个类的时候）
    Class c2 = Class.forName("learning.day14.Person"); // 这里类名是全路径 类名.包名 比较常用
    //
  }
}

class All {
  // 通过反射获取类的完整结构
  public void t() throws ClassNotFoundException {
    Class c1 = Class.forName("learning.day14.Student");
    Class superc1 = c1.getSuperclass(); // 获取父类
    System.out.println(superc1.getName());
    Class[] cc = c1.getInterfaces(); // 获取接口列表
    for (Class interface1 : cc) {
      System.out.println(interface1.getName());
    }

    //    Constructor [] cons =c1.getConstructors();//获取公有构造器数组
    //    for (Constructor c : cons) {
    //      System.out.println(c.getName()+"  "+c.getModifiers());//获取公有构造方法名+获取构造方法修饰符 1代表public
    //    }

    Constructor[] cons1 = c1.getDeclaredConstructors(); // 获取所有构造方法
    for (Constructor c : cons1) {
      System.out.println(
          c.getName() + "  " + c.getModifiers()); // 获取构造方法名+获取构造方法修饰符 1代表public 2代表private
      /*
      修饰符	对应的int类型
      public	1
      private	2
      protected	4
      static	8
      final	16
      synchronized	32
      volatile	64
      transient	128
      native	256
      interface	512
      abstract	1024
      strict	2048
      多个的话使用二进制加起来
      */
      Class[] c2 = c.getParameterTypes();
      for (Class cc1 : c2) {
        System.out.println("构造方法参数类型" + cc1.getName()); // 获取参数类型
      }
    }
  }

  public void tt()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          InvocationTargetException, NoSuchMethodException {
    Class c1 = Class.forName("learning.day14.Student");
    Constructor[] cons1 = c1.getDeclaredConstructors(); // 获取所有构造方法
    // getDeclaredConstructor()方法会根据他的参数对该类的构造函数进行搜索并返回对应的构造函数，没有参数就返回该类的无参构造函数，然后再通过newInstance进行实例化。
    // 使用Class类生成对象

    //    c1.newInstance();//被弃用了 会直接调用该类的无参构造函数进行实例化
    Student s = (Student) cons1[2].newInstance("666"); // 这样可以调用非private的构造方法生成对象 可以指定构造方法
    s.show();

    // 或者 这个方法同上
    Constructor cc = c1.getDeclaredConstructor(String.class); // 获取有一个参数且为String类型的构造器
    Student s1 = (Student) cc.newInstance("123");
    s1.show();

    // 可以通过反射 强制调用私有构造方法
    Constructor ccc =
        c1.getDeclaredConstructor(new Class[] {int.class}); // 获取有一个参数且为int类型的构造器 即私有的构造器
    //    Student s2 = (Student) ccc.newInstance(1);//报错 私有构造器不能newInstance
    ccc.setAccessible(true); // 解除私有封装后可以用上面的去访问
    Student s2 = (Student) ccc.newInstance(1);
  }

  public void getMethods() {
    // 获取所有方法
    try {
      Class c1 = Class.forName("learning.day14.Student");
      Method[] ms1 = c1.getMethods(); // 获取公有方法
      Method[] ms2 = c1.getDeclaredMethods(); // 获取所有方法
      for (Method m : ms2) {
        // System.out.println("---------------------");
        System.out.println("方法名" + m.getName());
        System.out.println("返回值" + m.getReturnType());
        System.out.println("修饰符" + m.getModifiers());
        Class[] params = m.getParameterTypes();
        if (params != null && params.length > 0) {
          for (Class a : params) {
            System.out.println("参数类型" + a.getName());
          }
          System.out.println("---------------------");
        }
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void getFields() {
    // 获取所有Field
    try {
      Class c1 = Class.forName("learning.day14.Student");
      Field[] f =
          c1.getDeclaredFields(); // 获取本类所有属性（不包括从父类继承的） 注意 getFields是包括父类继承来的公有属性的 其他同类型函数也类似
      for (Field ff : f) {
        System.out.println("修饰符 " + ff.getModifiers());
        System.out.println("属性类型 " + ff.getType());
        System.out.println("属性名称 " + ff.getName());
        System.out.println("----------------------");
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void getPackage() {
    try {
      Class c1 = Class.forName("learning.day14.Student");
      Package p = c1.getPackage(); // 获取所在的包
      System.out.println(p.getName());
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void invoke() {
    // 反射调用属性和方法
    try {
      Class c1 = Class.forName("learning.day14.Student");
      Constructor cc = c1.getDeclaredConstructor(String.class); // 获取有一个参数且为String类型的构造器
      Student s1 = (Student) cc.newInstance("123");

      Method m = c1.getDeclaredMethod("show2", double.class); // 方法名 + 方法参数类型
      double d =
          (double)
              m.invoke(s1, 12.0); // 参数1是对象 参数二是实际参数 这里如果用getMethod只能调用public.. 同样可以解除私有封装 强调私有方法
      System.out.println(d); // 接收return并打印
      System.out.println(s1.school);
      Field f = c1.getDeclaredField("school"); // 获取属性
      f.set(s1, "niubi"); // 设置属性
      System.out.println(s1.school);
    } catch (ClassNotFoundException
        | NoSuchMethodException
        | InstantiationException
        | IllegalAccessException
        | InvocationTargetException
        | NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }

  public void dynamicProxy() {
    // 动态代理
    // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用。
    I ii = new I();
    ii.t1();
    ii.t2();
    System.out.println("------------------");
    InvocationHandler handler = new proxy(ii);
    // 第一个参数 类加载器 第二个参数 被代理对象的接口 第三个参数 被代理对象
    // 返回值是被代理后的对象 Object类型 要转换一下
    I1 iii =
        (I1)
            Proxy.newProxyInstance(
                handler.getClass().getClassLoader(), ii.getClass().getInterfaces(), handler);
    iii.t1(); // 这里使用接口来接受对象的... why? 一个对象要被代理 那就要有实现的接口和实现类
    System.out.println("------------------");
    I2 iiii =
        (I2)
            Proxy.newProxyInstance(
                handler.getClass().getClassLoader(), ii.getClass().getInterfaces(), handler);
    iiii.t2();
  }
}

public class Reflection {
  public static void main(String[] args)
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    All a = new All();
    a.dynamicProxy();
  }
}
