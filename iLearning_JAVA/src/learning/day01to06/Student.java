package learning.day01to06;

public class Student {

    public int add(int x, int y, int z) {
        return x + y + z;
    }

    public int add(int x, int y) {
        return x + y;
    }
//java函数参数传递只能使用值传递 不能传地址 传值为拷贝
// 对象和字符串对象存在堆中 栈中存基础数据类型和对象地址
//    public static int add(int x[])//数组做函数形参 无参数要传递空数组或者null
//    {
//        int sum=0;
//        for(int i=0;i<x.length;i++)
//        {
//            sum+=x[i];
//        }
//        return sum;
//    }
    public static int add(int ... y)//java特有方式 无参数可以直接不写 若有其他参数 ...的要放最后面
    {
        int sum=0;
        for(int i=0;i<y.length;i++)
        {
            sum+=y[i];
        }
        return sum;
    }


    //方法重载 参数个数 顺序 或者参数数据类型不一致即可 和返回值类型无关
    public static void main(String args[])
    {
        s ss=new s("hjy");
        ss.show_NAME();
        new s("hjyyy").show_NAME();//匿名对象 常用作实参传递
        new s("hjy3290532").dataSwap();
        int x[]=new int[]{1,2,3,4,5};
        System.out.println(new Student().add(1,2,3));
        System.out.println(new Student().add(1,2));
        System.out.println(new Student().add(x));
        System.out.println(add(1,2,3,4,5));
        System.out.println(add());
    }
}

class s
{
    String name;
    int age;
    int score;

    public s(String n) {
        name=n;
    }

    public void show_NAME() {
        System.out.println(name);
    }

    public void dataSwap()
    {
        System.out.println("zzzttt");
    }
}