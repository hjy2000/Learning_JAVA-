package javaDataStruct.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class graph1
{
    //无向图
    private ArrayList<String> Vertex;//顶点
    private int[][] edges;//邻接矩阵
    private int numOfEdges;//边数量
    private boolean[] isVisited;//记录是否被访问
    graph1(int n)
    {
        //初始化矩阵和节点
        edges=new int[n][n];
        isVisited=new boolean[n];
        Vertex=new ArrayList<String>(n);
        numOfEdges=0;
    }
    public int getFirstNeighbor(int index)
    {
    // 得到某节点的第一个邻接节点的下标 若为-1则不存在
    for (int j = 0; j < Vertex.size(); j++){
      if(edges[index][j]>0)
      {
          return j;
      }
    }
    return -1;
    }

    public int getNextNeighbor(int v1,int v2)
    {
    // 根据上一个邻接节点获取下一个邻接节点（v2找不到邻接节点了）
    for (int j = v2+1; j < Vertex.size(); j++) {
        //从v1的邻接节点的下一个位置开始遍历
      if(edges[v1][j]>0)
      {
          return j;
      }
    }
        return -1;
    }
    public void insertV(String s)//插入节点
    {
        Vertex.add(s);
    }

    /**
     *
     * @param v1 第一个节点对应的下标
     * @param v2 第二个节点对应的下标
     * @param weight 边的权重
     */
    public void insertE(int v1,int v2,int weight)//插入边
    {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
    public int getNumOfVertex()
    {
        //返回节点的个数
        return Vertex.size();
    }
    public int getNumOfEdges() {
        //返回边的个数
        return numOfEdges;
    }
    public String getVertexInfo(int v)
    {
        return Vertex.get(v);
    }
    public int getWeight(int v1,int v2)
    {
        return edges[v1][v2];
    }
    public void showMatrix()
    {
        for (int [] a : edges) {
            System.out.println(Arrays.toString(a));
        }
    }
    private void DFS(int index)//对一个节点进行DFS
    {
    // 访问第一个节点 然后输出 bool值设为1
    System.out.print(getVertexInfo(index)+"-->");
    this.isVisited[index]=true;
    //查找第一个邻接节点
    int w=getFirstNeighbor(index);
    if(w==-1)
    {

    }
    else{
        while(w!=-1)//有邻接节点
        {
            if(this.isVisited[w]!=true)
            {
                DFS(w);
            }
            else{
                w=getNextNeighbor(index,w);
            }
        }
    }
    }

    public void DFS()//重载，遍历所有节点
    {
    for (int i = 0; i < getNumOfVertex(); i++) {
        if(this.isVisited[i]==false)
        {
            DFS(i);
        }
    }
    }

    public void BFS(int index)//对一个节点进行BFS
    {
        int u;//队首下标
        int w;//邻接节点下标
        LinkedList queue =new LinkedList<>();//单链表模拟队列
    // 访问节点
        System.out.print(getVertexInfo(index)+"-->");
        this.isVisited[index]=true;
    //节点入队
        queue.addLast(index);
        while(!queue.isEmpty())//队列非空
        {
            u= (int) queue.removeFirst();
            w= getFirstNeighbor(u);//取邻接节点
            while(w!=-1)//存在邻接节点
            {
                if(this.isVisited[w]==false)
                {
                    System.out.print(getVertexInfo(w)+"-->");
                    this.isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);//找next 广度优先
            }
        }
    }
    public void BFS()
    {
    for (int i = 0; i < Vertex.size(); i++) {
      if(this.isVisited[i]!=true)
      {
          BFS(i);
      }
    }
    }
}
public class graph {
  public static void main(String[] args) {
      graph1 g=new graph1(8);
//    String v[]={"A","B","C","D","E"};
      String v[]={"1","2","3","4","5","6","7","8"};
    for (String s : v) {
        g.insertV(s);//添加节点
    }
//    //关系 AB AC BC BD BE
//      g.insertE(0,1,1);
//      g.insertE(0,2,1);
//      g.insertE(1,2,1);
//      g.insertE(1,4,1);
//      g.insertE(1,3,1);

      g.insertE(0,1,1);
      g.insertE(0,2,1);
      g.insertE(1,3,1);
      g.insertE(1,4,1);
      g.insertE(3,7,1);
      g.insertE(4,7,1);
      g.insertE(2,5,1);
      g.insertE(2,6,1);
      g.insertE(5,6,1);
      g.showMatrix();
      System.out.println(g.getNumOfVertex());
      g.DFS();
//    g.BFS();
  }
}
