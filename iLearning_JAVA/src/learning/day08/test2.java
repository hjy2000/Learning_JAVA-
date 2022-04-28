package learning.day08;//包装类
class Date
{
    int day;
    int month;
    int year;
    Date(int day,int month,int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    @Override
    public String toString() {
        String str=day+month+year+"";
        return str;
    }
}
class chinese
{
    static String country;
    String name;
    int age;
    public static void c1()
    {
        System.out.println("c1方法测试");
    }
}

class Tools
{
    public static int a;
    int b=this.a;//合法
    public static boolean isEmptyStr(String s)//这种要注意 在static方法中就不能this.a了
    //static 常用于工具类 类被加载 静态方法就能用 优先级高于实例方法
    //权限允许直接类名访问就行
    {
//        int b=this.a;//不合法
     if(s!=null && !s.equals(""))
     {
         return true;//判不为null或者""则返回true
     }
     return false;
    }
}

public class test2 {
    public void t1()
    {
        Integer i = Integer.valueOf(111);//装箱 新版的写法
        Double d = Double.valueOf(12.8);
        Double dd=Double.valueOf("123");//使用字符串也可以 但是内容一定要是数字
        System.out.println(dd);
        Boolean b=Boolean.valueOf(false);
        Boolean b1=Boolean.valueOf("false");
        int ii=i.intValue();//拆箱
        ii=i.byteValue();//拆箱
        System.out.println(ii);
        System.out.println(b.booleanValue());
        System.out.println(b1.booleanValue());

        Integer i2=11;
        int i3=i2;//自动拆箱装箱

        Boolean b2=false;
        boolean b3=b2;//自动拆箱装箱

        //字符串转换为基础数据类型
        int i5=Integer.parseInt("12345");

        //基础数据类型转为String类型
        String s=String.valueOf(123);
        //或者简单粗暴
        String ss=5+"";
    }
    public void t2()
    {
        Date d=new Date(1,2,3);
        System.out.println(d);//打印这个就是调用的toString方法
        System.out.println(d.toString());//不重写toString的话 直接输出对象名和对象名toString都是输出对象地址
        //重写的话就不一样了 重写后两者都按重写逻辑打印
    }
    public void t3()
    {
        chinese.country="中国";//静态变量只需用类名赋值一遍就行
        chinese c1=new chinese();
        chinese c2=new chinese();
        chinese c3=new chinese();
//        System.out.println(c1.country);
//        System.out.println(c2.country);
//        System.out.println(c3.country);
        System.out.println(chinese.country);//类变量
    }
    public static void main(String[] args) {
        chinese.c1();//类方法不需要对象可以直接调用（静态方法中也可以调用）
        System.out.println(Tools.isEmptyStr("123"));
    }
}
