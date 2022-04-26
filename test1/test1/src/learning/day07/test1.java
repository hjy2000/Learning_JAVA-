package learning.day07;

public class test1 {
    public static void main(String[] args) {
//        Student s=new Student();
//        s.setAge(100);
//        System.out.println(s.getAge());
        //System.out.println(s.age);//子类不能使用父类中private的属性和方法 和C++差不多 子类父类在同一个包中的话 只要不是private都能使用 如果不在同一个包中 子类只能使用protected和public
        Uni_student u=new Uni_student();
        u.test();
    }
}

class person
{
    private int age;
    protected String name;
    person(String s)
    {
        System.out.println("这是person类的构造器");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
class Student extends person//java不支持多重继承（很多个爹） 但是可以多层继承
{
    protected int id;
    Student()
    {
        super("显式调用父类有参构造器，否则报错");
        //父类没有空的构造器时（即父类只有有参构造器时） 需要显式在第一行调用this()或者super()指定本类或者父类构造器 且要写在第一行
        //儿子要配合爸爸
        System.out.println("这是Student类的构造器");
    }
    Student(String s)
    {
        this();
    }
    //重写父类方法只能重写方法体 其他不能变
    //被重写方法为static时重写也要是static的
    @Override
    //默认执行重写的方法
    public void setAge(int age)
    //重写方法权限修饰符不能使用比父类更严格 重写是子类重写父类方法 重载是一个类可以有很多同名方法 重写的参数与父类必须相同 否则为子类中的函数重载而非重写
    {
        super.setAge(10);
    }
}

class Uni_student extends Student {
    Uni_student()
    {
        System.out.println("这是Uni类的构造器");//默认会调用父类无参构造器 从上倒下调用 先有爹才有儿子 和C++一样
        //构造器不能继承，所以不能被重写 父类没有空的构造器时（即父类只有有参构造器时） 需要显式在第一行调用this()或者super()指定构造器
    }
    public void test() {
        //super.age不合法 因为age是private
        this.id = 2018;//这里写super或者this都可以 因为this在本类找不到属性会去父类找
        super.name="hjy";//super可以使用非直接父类的合法修饰符的值 或者方法
        super.setAge(1);//方法被重写时，super执行直接父类（最近父类？）的重写后的方法 并且重写参数不一致时强制使用最近父类的参数列表
    }
}
