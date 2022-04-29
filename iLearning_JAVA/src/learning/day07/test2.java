package learning.day07;
//Object类主要方法有public Object()构造器 public boolean equals()方法比较引用类型
// public int hashcode()获取hash码 public String toString()方法供对象打印调用
//
public class test2 {
    public void t(Object obj)//确定形参是类但是不知道什么类 可以使用根父类 接受子类对象
    {

    }

    public static void main(String[] args) {
        test2 t2=new test2();
        person p=new person("hjy");
        person pp=new person("1234");
        Student s=new Student();
        t2.t(p);
        t2.t(s);//此时可以传入任何对象
        System.out.println(p.equals(s));
        System.out.println(p.equals(pp));//仍为fasle 生成了新对象 地址不同
        p=pp;
        System.out.println(p.equals(pp));//此时为true p和pp都指向了堆中的pp

        Object h = new Object();
        System.out.println(h.hashCode());
        System.out.println(h.toString());
        System.out.println(s.toString());
    }
}
