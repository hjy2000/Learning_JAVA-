package javaDataStruct.Linear;
//线性结构(一对一) 分为顺序表和链表 常见的有数组 链表 队列 栈
//非线性结构 多维数组 广义表 图 树
//五子棋 存盘 很多无意义的0-->稀疏数组 保存不同的值 第一行记录有几行几列共几个不同的值（行，列，值） 下面的每行记录在某个行列位置的值

class SparseArray
{
  int a[][]=new int[11][11];//0无棋子 1黑子 2蓝字
  int[][] z = new int[3][3];//稀疏数组
  int notZ=0;
  SparseArray()
  {
    a[1][2]=1;
    a[2][3]=2;
    show();
  }
  public void show()
  {
    for (int[]aa : a) {
      for (int aaa :aa ) {
        if(aaa!=0)
        {
          notZ+=1;
        }
        System.out.print(aaa+" ");
      }
      System.out.println();
    }
  }
  public void showzip()
  {
    for (int[]aa : z) {
      for (int aaa :aa ) {
        System.out.print(aaa+" ");
      }
      System.out.println();
    }
  }

  public void zip() {
    z[0][1] = this.a[0].length;
    z[0][0] = this.a.length;
    z[0][2] = this.notZ;
    int tag = 1;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (a[i][j] != 0) {
          z[tag][0] = i;
          z[tag][1] = j;
          z[tag][2] = a[i][j];
          tag += 1;
        }
      }
    }
  }
}

class queue
{
  //队列 先进先出线性表

}
public class linear1 {
  public static void main(String[] args) {
    SparseArray s=new SparseArray();
    s.zip();
    s.showzip();
    }
}
