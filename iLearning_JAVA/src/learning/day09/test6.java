package learning.day09;
abstract class Person
{
    int age;
    String name;
    public abstract void s();
}

interface I3
{
    void s1();
}
interface I4
{
    void s2();
}
class Teacher extends Person implements I3,I4
{
    @Override
    public void s() {
        System.out.println("这是老师");
        s1();
        s2();
    }

    @Override
    public void s1() {
        System.out.println("老师会唱歌");
    }

    @Override
    public void s2() {
        System.out.println("老师会炒菜");
    }
}

public class test6 {
    public static void main(String[] args) {
        Teacher t=new Teacher();
        t.s();
        I3 i=new Teacher();//使用接口接受实现类对象 对象多态 但是这时候实现类的除了接口本来有的方法外其他方法都丢失
        //接口也可以继承接口
        //抽象类抽象出的是属性和方法 如果只需要抽象处方法 则使用接口
        i.s1();
    }
}
