package learning.test;

public class test2 {
    private int age;
    public test2(){
        age=22;
    }
//    public test2(int a){
//        age=a;
//    }
    public test2(int age){
        this.age=age;//C++的this指针 py的self
    }
    public void printAge1()
    {
        System.out.println(this.age);//使用this()可以调用构造函数 如果这样用的话只能放在方法的首行 且不能出现构造器循环调用 至少要有一个构造器不调用this()
    }
    public void setAge(int a)
    {
        if(a>0&&a<100)
        {
            age=a;
        }
        else
        {
            System.out.println("年龄错误");
        }
    }
    public void printAge()
    {
        System.out.println(age);
    }
}

class tt
{
    tt(){}//默认构造方法 无修饰符的类构造方法默认页无修饰符 显示定义构造方法后使用自定义的不用默认的 构造方法不可继承
    public static void main(String[] args) {
        test2 t2=new test2();
        test2 t22=new test2(23);
        t2.setAge(51000);
        t2.printAge1();
        t22.printAge1();
    }
}