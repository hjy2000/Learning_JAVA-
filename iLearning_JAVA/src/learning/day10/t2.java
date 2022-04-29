package learning.day10;

//赋值操作在运行期间执行,两个变量的引用将会发生改变.因此这时用”=="相比时将会得到false
//(在运行期间所得到的字符串内容,将不会放到所谓的"文字池"之中,因为如果有相同内容的变量引用相同内容,这样作的话需要每次字符串改变时需要检查它的内容,再在文字池中查找看是否有相同内容的常量,太过浪费效率.)

//Hashset（set最常用）
//不能保证有序，不可重复，非线程安全，元素可以为null
//存入元素时调用hashcode函数获取hashcode值，根据值决定存放位置，所以不保证顺序
//不可重复：两个元素equals返回true，但是hashcode不同的话，hashset存储再不同位置
//即equals返回true 且hashcode一致才是相同 两个值一般同时相等或者不相同
//hashset实现set接口 set接口继承collections接口
import java.rmi.MarshalledObject;
import java.util.*;

class A1
{

}

class B implements Comparator<B>//实现定制排序 比较接口
{
    int age;
    String name;
    B(){}
B(int age)
{
    this.age=age;
}
    @Override
    public int compare(B o1, B o2) {//重写了比较方法
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

class C implements Comparator<C>
{
    int id;
    String name;
    C()
    {

    }
    C(int a,String s)
    {
        this.id=a;
        this.name=s;
    }
    @Override
    public int compare(C o1, C o2) {
        if(o1.id>o2.id)
        {
            return 1;
        }
        else if (o1.id<o2.id)
        {
            return -1;
        }
        else {
            return 0;
        }
    }
}
public class t2 {
    public void test()
    {
        A1 a1=new A1();
        A1 a2=new A1();
        Set s=new HashSet();//这个其实没有指定泛型 所以是Object为泛型
        s.add(1);
        s.add(1);//存值不重复
        String ss1=new String("hjy");
        String ss2=new String("hjy");
        System.out.println(ss2.equals(ss1));//true
//        s.add("hjy");
        s.add(ss1);
        s.add(ss2);//这样也存不进去两个hjy 说明字符串是euqals值的
        System.out.println(a1.equals(a2));//false 能存两个 因为equals是false
        s.add(a1);
        s.add(a2);
        System.out.println(s);
        System.out.println(s.contains(1));//判断是否包含某元素
        s.remove("hjy");
        System.out.println(s);
        s.clear();//清空集合

        for (int i = 0; i < 5; i++) {
            s.add(i);
        }

        Iterator it =s.iterator();//声明迭代器
        while(it.hasNext())//有下一个就输出
        {
            System.out.println(it.next());
        }

        for (Object obj:s) {//把s中每个元素取出来赋值给obj 然后打印输出
            System.out.println(obj);
        }

        System.out.println(s.size());//集合大小

        Set <Integer>s1=new HashSet<Integer>();//指定整型为泛型
        s1.add(1);//合法
//        s1.add("123");//非法

        //treeset 自然排序 定制排序 保证元素有序 定制排序需要像下面一样实现定制的comparator对象来决定排序逻辑
        Set <Integer>s2=new TreeSet<Integer>();
        s2.add(6);
        s2.add(3);
        s2.add(99);
        s2.add(2);
        System.out.println(s2);//自动排序了 调用了Compare(Object obj)方法默认升序排列 this>obj返回1 <返回-1 相等返回0
        //String类、包装类等实现了Comparable接口，所以向TreeSet中添加字符串类型的元素时，无需再次实现Comparable接口，会自动进行排序。
        //对于没有实现Comparable接口的类，如果需要排序，需要自定义类实现Comparable接口，重写CompareTo()方法
        s2.remove(6);
        System.out.println(s2);
        System.out.println(s2.contains(3));
//        s2.clear();
        Iterator<Integer> it1=s2.iterator();
        while(it1.hasNext())
        {
            System.out.println(it1.next());
        }

        for (Integer i:s2//这里不同Object 直接用泛型类型
        ) {
            System.out.println(i);
        }

        Set <B> s3=new TreeSet<B>(new B());//这里要写newB
        s3.add(new B(3));
        s3.add(new B(77));
        s3.add(new B(45));
        for (B b:s3
        ) {
            System.out.println(b.age);//可以看到按照年龄排序了
        }
    }

    public void test2()//ArrayList不是线程安全的
    {
        List<String> li = new ArrayList<String>();//实现类为ArrayList
        //可以重复 有序 按照输入顺序排序 可以使用索引位置访问元素
        li.add("a");
        li.add("a");
        li.add("a");//可重复
        li.add("g");
        li.add("d");
        li.add("b");
        System.out.println(li);
        System.out.println(li.get(0));
        li.add(2,"指定位置插入");
        System.out.println(li);
        List<String> li1 = new ArrayList<String>();
        li1.add("集合");
        li1.add("jihe");
        li.addAll(3,li1);//指定位置插入集合
        System.out.println(li);
        System.out.println(li.indexOf("d"));//首次出现的索引
        System.out.println(li.lastIndexOf("d"));//最后一次出现的索引
        li.remove("集合");
        li.set(4,"hhhhhh");//修改指定位置元素
        System.out.println(li);
        List li2=li.subList(3,5);//截取第三到四个元素
        System.out.println(li2);
        System.out.println(li.size());
        Collections.swap(li,0,5);//按照索引下标交换元素
        System.out.println(li);
        System.out.println("最大最小值");
        System.out.println(Collections.max(li));
        System.out.println(Collections.min(li));
        System.out.println(Collections.frequency(li,"a"));//返回指定元素出现的次数
        Collections.replaceAll(li,"a","aaa");//使用新值替换所有的旧值

        System.out.println(li);
    }

    public void test3()
    {
        //hashmap不是线程安全的 允许存在一个为null的key hashtable线程安全 不允许存在null的key
        //这两者和hashset一样 不保证元素顺序
        //判断key相等是euqals为true，且hashcode相同
        //hashtable判断集合相等的话，是通过调用equalsHashMap方法比较两个value返回true

        //一对一映射 key不允许重复
        Map<String,String> map=new HashMap<String,String>();
        map.put("zzt","ttzt");//添加数据
        map.put("zzzt","ttzetwt");//添加数据
        map.put("tt","ttzt");//key一定要不同 值随意
        System.out.println(map);
        System.out.println(map.get("tt"));//根据key取值
        map.remove("tt");//根据key移除键值对
        System.out.println(map.size());//长度
        System.out.println(map.containsKey("zzt"));//是否存在键
        System.out.println(map.containsValue("ttzt"));//是否存在值
//        map.clear();//清空

        //遍历方式一
        Set<String> s=map.keySet();//获取所有键给s
        for (String key:s
             ) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        //遍历方式二
        Set<Map.Entry<String, String>> E =map.entrySet();
        for (Map.Entry<String,String> e:E
        ){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
    }
    }

    public void test4()
    {
        //treeMap
        Map<Integer,String> treeMap=new TreeMap<Integer,String>();
        treeMap.put(0,"ttt");
        treeMap.put(1,"tta");
        treeMap.put(2,"ttb");
        treeMap.put(3,"ttz");
        System.out.println(treeMap);//默认实现了comparable 按照key自然排序 可以通过实现comparator接口实现定制排序
        //输出 {0=ttt, 1=tta, 2=ttb, 3=ttz}

        Map<String,String> treeMap1=new TreeMap<String, String>();
        treeMap1.put("a","ttt");
        treeMap1.put("bc","tta");
        treeMap1.put("bd","ttb");
        treeMap1.put("A","ttz");
        treeMap1.put("1","asda");
        treeMap1.put("10","asfa");
        System.out.println(treeMap1);//默认实现了comparable 按照key自然排序 字母顺序 多个字母按首个字母
        //输出 {1=asda, 10=asfa, A=ttz, a=ttt, bc=tta, bd=ttb}
    }

    public void test5()
    {
        //collections工具类
        List<String> l=new ArrayList<String>();
        l.add("1");
        l.add("a");
        l.add("asf");
        l.add("bc");
        l.add("b");
        System.out.println(l);
        Collections.reverse(l);
        System.out.println(l);//逆转字典
        Collections.shuffle(l);
        System.out.println(l);//随机排序字典
        Collections.sort(l);
        System.out.println(l);//升序排序字典

        C c1=new C(154,"h");
        C c2=new C(15,"g");
        C c3=new C(18,"sdgs");
        C c4=new C(45,"sgd");

        List<C>l1=new ArrayList<C>();
        l1.add(c1);
        l1.add(c2);
        l1.add(c3);
        l1.add(c4);
        for (C c:l1
             ) {
            System.out.println(c.id+c.name);
        }

        Collections.sort(l1,new C());//sort实现按照类中重写的Comparator排序
        for (C c:l1
        ) {
            System.out.println(c.id+c.name);
        }

        System.out.println((Collections.max(l1,new C())).name);//实现自定义Comparator排序的最大值
    }
    public static void main(String[] args)
    {
        t2 T=new t2();
//        T.test();
        T.test2();
//        T.test3();
//        T.test4();
//        T.test5();
    }
}
