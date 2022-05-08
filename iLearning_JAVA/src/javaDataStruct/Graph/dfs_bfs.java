package javaDataStruct.Graph;

import java.util.LinkedList;

class treeNode
{
    int val;
    treeNode left;
    treeNode right;
    treeNode(int x){this.val=x;}
    public void dfs(treeNode n)
    {
        if(n==null)
        {
            return;
        }
        System.out.println(n.val);
        if(n.left!=null)
        {
            dfs(n.left);
        }
        if(n.right!=null)
        {
            dfs(n.right);
        }
        return;
    }
    public void dfsStack(treeNode n)
    {
        if(n==null)
        {
            return;
        }
        LinkedList l=new LinkedList();
        l.addFirst(n);
        while(!l.isEmpty())
        {
            treeNode m= (treeNode) l.removeFirst();
            System.out.println(m.val);
            if(m.left!=null)
            {
                l.addFirst(m.left);
            }
            if(m.right!=null)
            {
                l.addFirst(m.right);
            }
        }
    }
    public void bfs(treeNode n)
    {
        if(n==null)
        {
            return;
        }
        LinkedList l=new LinkedList();
        l.addLast(n);
        while(!l.isEmpty())
        {
            treeNode m= (treeNode) l.removeFirst();
            System.out.println(m.val);
            if(m.left!=null)
            {
                l.addLast(m.left);
            }
            if(m.right!=null)
            {
                l.addLast(m.right);
            }
        }
    }
}
class testTreeNode
{
    public void test()
    {
        treeNode n=new treeNode(1);
        n.left=new treeNode(12);
        n.right=new treeNode(20);
        n.dfs(n);
        System.out.println();
        n.dfsStack(n);
        System.out.println();
        n.bfs(n);
    }
}

class graph2
{
    int numOfEdges;
    String [] vertexs;
    int[][] edges ={
    { 0, 1, 0, 0, 0, 1, 1, 0, 0 },
    { 1, 0, 1, 0, 0, 0, 1, 0, 1 },
    { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
    { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
    { 0, 0, 0, 1, 0, 1, 0, 1, 0 },
    { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
    { 0, 1, 0, 1, 0, 1, 0, 1, 0 },
    { 0, 0, 0, 1, 1, 0, 1, 0, 0 },
    { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
};  ;
    boolean [] isVisited;
    graph2(int n)
    {
        vertexs=new String[9];
//        edges=new int[n][n];
        isVisited=new boolean[9];
        numOfEdges=9;
    }
    public void dfsAll()
    {
    for (int i = 0; i < vertexs.length; i++) {
      if(!isVisited[i])
      {
          dfs(i);
      }
    }
    }
    public void dfs(int index)
    {
        
    }
}

public class dfs_bfs {
  public static void main(String[] args) {

  }
}
