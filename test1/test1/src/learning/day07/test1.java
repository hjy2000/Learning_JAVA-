package learning.day07;
//day7_8后面再回来看 没完全听明白
//static修饰的方法不能被重写，只能被继承。而属性也是只有重新声明和继承,没有重写的概念。 虽然，子类不能重写父类的静态方法和属性，但是java允许子类重新创建一个符合重写规则的静态方法和属性。但是要注意子类的这个按照重写规则创建的静态方法和属性并不是重写。
public class test1 {
    public static void main(String[] args) {
//        Student s=new Student();
//        s.setAge(100);
//        System.out.println(s.getAge());
        //System.out.println(s.age);//子类不能使用父类中private的属性和方法 和C++差不多 子类父类在同一个包中的话 只要不是private都能使用 如果不在同一个包中 子类只能使用protected和public
        Uni_student u=new Uni_student();
        u.test();

        Student s=new Student();
        person p=new person("?");
        s.test=123;//合法
        //上面是正常情况
        //下面是对象多态的例子
        person e=new Student();//父类引用对象可以指向子类的实例 子类可以看作特殊父类 子类对象向上转型 此时e不能访问子类的属性和方法 只是子类对象实例的一部分 这叫动态绑定
//        e.test=321;//非法 此时e不能访问子类的属性了 属性在编译时确定 此时e为person的属性还没有在运行时变为student类型
        e.getAge();//此时调用的是student的方法 因为方法是运行时调用的 这叫虚拟方法调用
//        Uni_student r=new Student(); 非法 属性多的子类可以初始化属性少的父类 否则反之
        System.out.println(s instanceof Student);
        System.out.println(s instanceof person);//子类对象对于父类也是true
        System.out.println(p instanceof Student);
        System.out.println(e instanceof person);
        System.out.println(e instanceof Student);//如果使用了动态绑定，两个都是true
        //类的实例包含本身的实例，以及所有直接或间接子类的实例 null用instanceof跟任何类型比较时都是false
        //instanceof左边显式声明的类型与右边操作元必须是同种类或存在继承关系，也就是说需要位于同一个继承树，否则会编译错误
    }
}

class person
{
    protected int age=50;
    protected String name;

    person(String s)
    {
        System.out.println("这是person类的构造器");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = 20;
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
    protected int age=30;
    protected int test;
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

    @Override
    public int getAge() {
        return super.getAge();
    }
}

class Uni_student extends Student {
    Uni_student()
    {
        System.out.println("这是Uni类的构造器");//默认会调用父类无参构造器 从上倒下调用 先有爹才有儿子 和C++一样
        //构造器不能继承，所以不能被重写 父类没有空的构造器时（即父类只有有参构造器时） 需要显式在第一行调用this()或者super()指定构造器
    }
    public void test() {
        System.out.println(super.age);//person.age为50 student.age=30 输出了30说明super会被最近父类属性截留
        //super.age不合法 因为age是private
        this.id = 2018;//这里写super或者this都可以 因为this在本类找不到属性会去父类找
        super.name="hjy";//super可以使用非直接父类的合法修饰符的值 或者方法
        super.setAge(1);
        //方法被重写时，super执行直接父类的方法 若直接父类有对间接父类的方法重写 重写时也是使用的super方法则可以访问到间接子类中的方法 哪一层没有super的话 最底层子类就只能super到断的那一层
        System.out.println(super.getAge());
    }
}
/*
1.构造器先执行方法体然后进栈 父类最后进栈 所以父类出栈时先执行
2.多态表现在两个方面，一是重载和重写 而是对象的多态
引用变量分为编译时和运行时 编译时和运行时不一致则为对象多态
 */