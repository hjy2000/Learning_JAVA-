package learning.day08;
// 单例设计模式 加入实例化这个类要耗费很多资源
// java自带的runtime类就是饿汉式的单例
class singleTon_hungery {
  private static singleTon_hungery single =
      new singleTon_hungery(); // 类内执行私有构造器 static保证只存在一个single对象
  ; // 私有构造器

  private singleTon_hungery() {}

  public static singleTon_hungery getInstance() // 通过这里返回这个对象
      {
    return single;
  }
}

class singleTon_lazy // 非线程安全的 要修复
 {
  private static singleTon_lazy single = null; // 对象先是null null是基础数据类型
  ;

  // 一开始对象为null，有人new对象后，所有再new的都用这个对象
  private singleTon_lazy() {}

  public static singleTon_lazy getInstance() {
    if (single == null) {
      single = new singleTon_lazy();
    }
    return single; // 后面都直接return了同一个对象 因为single是static的
  }
}

public class test3 {
  public static void main(String[] args)
        // 这里的main不是关键字 但是是jvm可以识别的特殊标识 默认情况下jvm传的是一个没有元素的字符串对象 即new String[0] 没办法args[0]去访问
        // 这样的话其实我们也可以给主函数传值...
      {
    //        singleTon_hungery s1=new singleTon_hungery();//非法
    singleTon_hungery s2 = singleTon_hungery.getInstance(); // 合法 且无论执行几次都只存在一个对象
    singleTon_hungery s3 = singleTon_hungery.getInstance();
    System.out.println(s2.equals(s3)); // 为true 说明确实只存在一个对象

    singleTon_lazy s4 = singleTon_lazy.getInstance(); // 合法 且无论执行几次都只存在一个对象
    singleTon_lazy s5 = singleTon_lazy.getInstance();
    System.out.println(s4.equals(s5)); // 为true 说明确实只存在一个对象
  }
}
