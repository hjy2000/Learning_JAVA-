package learning.day11;
//final实例变量必须显示地被赋初始值，而且本质上final实例变量只能在构造器中被赋初始值
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

class D
{
    @TestAnn(id = 1,desc = "name")//这里不写的话就是default的值 写了就是传进去的
    String ann;
    public void test(List<?> l)//泛型通配符
    {}
    public void test1(List<? extends A2> l)//通配符限制为A2及其子类
    {}
    public void test2(List<? super A1> l)//通配符限制为A1及其父类
    {}
    public void test3(List<? extends I123> l)//通配符限制为I123的实现类
    {}
}

class A1
{

}
class A2 extends A1
{

}

class A3 extends A2
{

}
interface I123
{ }
class II implements I123
{ }

interface It
{
    void test();
}
enum Season implements It//枚举类也可以实现接口
{
    SPRING("春天","s"),
    SUMMER("夏天","ss"),
    FALL("秋天","f"),
    WINTER("冬天","w");//相当于调用构造方法

    private final String name;
    private final String desc;

    private Season(String name,String desc)//私有构造器
    {
        this.desc=desc;
        this.name=name;
    }
    @Deprecated//过时方法 仍可调用但是会看到是过时的
    public void show()
    {
        System.out.println(this.name+this.desc);
    }

    @Override
    public void test() {
        System.out.println("枚举类实现及接口方法");
    }
}
public class t2 {
    @SuppressWarnings({})
    public static void main(String[] args) {
        D d=new D();
        List<String> ll=new ArrayList<String>();
        d.test(ll);

        List<A1> ll1=new ArrayList<A1>();
        List<A3> ll2=new ArrayList<A3>();
        d.test1(ll2);//可以
//        d.test1(ll1);//报错 通配符限制为A2及其子类 A1是父类

        d.test2(ll1);//可以
//        d.test2(ll2);//报错 限制为A1及其父类了
        List<II> ll3=new ArrayList<II>();
        d.test3(ll3);//合法
//        d.test3(ll1);//非法 ll1不是I123的是实现类

        Season s=Season.SPRING;//返回春天对象
        s.show();//还是可以用的.. 只不过emm
        s.test();
        Season s1=Season.SPRING;//返回春天对象
        s1.show();

        System.out.println(s.equals(s1));//true 说明枚举类中同一个枚举都是返回同一个对象 即单例模式
        //这里这个equals是用==实现的 与==相同
        //枚举类实现了comparable接口 compareTo方法可以比较枚举常量对象的大小 即比较声明的前后顺序
        @SuppressWarnings({"警告测试","unused","spillingerror"})
        List<II> lllllll=new ArrayList();//比如无泛型限制会有警告 上面加@SuppressWarnings可以抑制编译器警告
    }
}

@Target(ElementType.FIELD)//表示这个注解类是为了注解类属性的
@Retention(RetentionPolicy.RUNTIME)//表示注解的生命周期为程序运行时
@Documented
@interface TestAnn//注解类
{
    public int id() default 0;
    public String desc() default "";
}
//注解：详细见文章https://zhuanlan.zhihu.com/p/37701743
//@Override 重写方法
//@Deprecated 过时方法 仍可调用但是会看到是过时的
//@SuppressWarnings 可以去除警告
//可以自定义注解
/*
(01) @interface

使用 @interface 定义注解时，意味着它实现了 java.lang.annotation.Annotation 接口，即该注解就是一个Annotation。

定义 Annotation 时，@interface 是必须的。
注意：它和我们通常的 implemented 实现接口的方法不同。Annotation 接口的实现细节都由编译器完成。通过 @interface 定义注解后，该注解不能继承其他的注解或接口。

(02) @Documented

类和方法的 Annotation 在缺省情况下是不出现在 javadoc 中的。如果使用 @Documented 修饰该 Annotation，则表示它可以出现在 javadoc 中。

定义 Annotation 时，@Documented 可有可无；若没有定义，则 Annotation 不会出现在 javadoc 中。

(03) @Target(ElementType.TYPE)

前面我们说过，ElementType 是 Annotation 的类型属性。而 @Target 的作用，就是来指定 Annotation 的类型属性。

@Target(ElementType.TYPE) 的意思就是指定该 Annotation 的类型是 ElementType.TYPE。这就意味着，MyAnnotation1 是来修饰"类、接口（包括注释类型）或枚举声明"的注解。

定义 Annotation 时，@Target 可有可无。若有 @Target，则该 Annotation 只能用于它所指定的地方；若没有 @Target，则该 Annotation 可以用于任何地方。

(04) @Retention(RetentionPolicy.RUNTIME)

前面我们说过，RetentionPolicy 是 Annotation 的策略属性，而 @Retention 的作用，就是指定 Annotation 的策略属性。

@Retention(RetentionPolicy.RUNTIME) 的意思就是指定该 Annotation 的策略是 RetentionPolicy.RUNTIME。这就意味着，编译器会将该 Annotation 信息保留在 .class 文件中，并且能被虚拟机读取。

定义 Annotation 时，@Retention 可有可无。若没有 @Retention，则默认是 RetentionPolicy.CLASS。
 */