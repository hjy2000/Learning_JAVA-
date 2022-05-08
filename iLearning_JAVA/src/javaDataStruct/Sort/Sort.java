package javaDataStruct.Sort;

// 内部排序 外部排序
// 时间复杂度：事后统计（要运行，浪费时间，计算机情况不一定相同） 事前估计（）
// 时间频度 算法中语句执行次数叫时间频度T(n)
// 时间复杂度计算（渐近时间复杂度） T(n)常数用1替代 O（n）计算时忽略常数 忽略低次项 忽略系数
// O(1)<O(log2n)<O(n)<O(nlog2n)<O(n^2)<O(n^k)<O(2^n)<O(n!)
// 平均时间复杂度和最坏时间复杂度

class MultiSort
{
    int[] m = new int[10000];
    MultiSort()
    {
    for (int i = 0; i < 10000; i++) {
      m[i]=(int)(Math.random() * 1000000);
    }
    }
    public void show() {
        for (int xx :this.m) {
            System.out.print(xx + " ");
        }
    System.out.println();
    }

    public void bubble() {
        //O(n^2)
        // 一共进行N-1趟排序 每趟次数是在不断减少的（每次确定一个数的位置）
        // 如果有一趟没发生交换 直接结束排序
        int temp = 0;
        boolean tag = false;
        for (int l = 1; l < m.length - 1; l++) {
            System.out.println("第"+l+"趟排序");
            tag = false;
            for (int i = 0; i < m.length - l; i++) {
                if (m[i] > m[i + 1]) {
                    temp = m[i + 1];
                    m[i + 1] = m[i];
                    m[i] = temp;
                    tag = true;
                }
            }
            this.show();
            if (tag == false) {
                System.out.println("提前break");
                break;
            }
        }
    }

    public void select()
    {
        //O(n^2)
        //一共n-1趟循环
        //在数组中寻找最小值 找到之后再和数组第一个元素交换
        //第二趟就是从第二个元素到数组尾部寻找最小 放到数组第二个位置 以此类推
        int temp=0;
        int index=0;
        int max=Integer.MIN_VALUE;
    for (int i = 0; i < m.length-1; i++) {
        System.out.println("第"+i+"趟排序");
      for (int j = 0; j < m.length-i-1 ;j++) {
        if(m[j]>=max)
        {
            max=m[j];
            index=j;
        }
      }
      temp=m[m.length-i-1];
      m[m.length-i-1]=max;
      m[index]=temp;
      max=Integer.MIN_VALUE;
      this.show();
    }
    }

    public void insert()
    {
        //O(n^2)
        //一般初始值把第一个元素作为有序表 其他是无序表
        //遍历无序表 将元素插入到有序表的指定位置
        //
        int temp=0;
        int max=Integer.MIN_VALUE;
        int index=1;
    for (int i = index; i < m.length; i++) {
      for (int j = 0; j < index; j++) {
        //寻找插入位置

      }
    }

    }

    public void Quicksort(int l,int h)//递归部分
    {
        //avg O(nlogn) ~ worst O(n^2)
    if (l > h) {
      return;
    }
    //分组
    int partition=partition(l,h);//返回分组交换后分界值的索引
        //左子组有序
        Quicksort(l,partition-1);
        //右子组有序
        Quicksort(partition+1,h);
    }
    public void Quicksort()
    {
        int l=0;
        int h=m.length-1;//length减一就是对应的数组下标
        Quicksort(l,h);
    }
    public int partition(int l,int r)
    {
        int pivot=m[l];//分界值
        int lo=l;//左指针最小索引处
        int hi=r+1;//右指针 最大索引处+1
        //切分
        while(true)
        {
            //从右开始扫描 找一个比分界值小的值后停止
            while(m[--hi]>pivot){
                //找到的值比分界值大就继续移动右指针
                if(hi==l)
                {
                    //如果移动到最左处，直接break
                    break;
                }
            }
            //从左往右扫描 找一个比分界值大的值停止
            while(m[++lo]<pivot)
            {
                if(lo==r)
                {
                    break;
                }
            }
            //判断跳出条件 即两个指针相遇
            if(lo>=hi)
            {
                break;//跳出
            }
            else{
                //否则交换两指针的元素
                int temp=m[lo];
                m[lo]=m[hi];
                m[hi]=temp;
            }
        }
        //最后交换分界值和hi指针所在的位置的元素(因为hi先动，所以hi一定OK的)
        int temp=m[hi];
        m[hi]=pivot;
        m[l]=temp;
        return hi;//返回分界值索引位置
    }
}

public class Sort {
  public static void main(String[] args) {
    MultiSort m=new MultiSort();
//    m.bubble();
//      m.select();
//      m.insert();
m.Quicksort();
m.show();
  }
}
