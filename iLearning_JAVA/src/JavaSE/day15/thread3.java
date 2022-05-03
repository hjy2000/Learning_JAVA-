package JavaSE.day15;
// 生产消费者问题
// 生产者每次将产品交给店员clerk
// 店员只能持有固定数量的产品 消费者从店员那里取走商品
// 如果店内商品满了 店员叫生产者暂停
// 如果店内商品没了 店员叫消费者暂停 有产品了再唤醒

class Clerk {
  public static int productNum = 0;
}

public class thread3 {
  public static void main(String[] args) {
    // 消费时不生产，生产时不消费
    Clerk c = new Clerk();
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronized (c) {
                  while (true) // 无限生产
                  {
                    if (Clerk.productNum == 0) {
                      System.out.println("数量为0，开始生产");
                      while (Clerk.productNum < 5) {
                        Clerk.productNum += 1;
                        System.out.println("库存:" + Clerk.productNum);
                      }
                      System.out.println("产品数达到5，停止生产");
                      c.notify(); // 唤醒消费者
                    } else {
                      try {
                        c.wait(); // 生产者等待
                      } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                      }
                    }
                  }
                }
              }
            },
            "生产者")
        .start();

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronized (c) {
                  while (true) // 无限消费
                  {
                    if (Clerk.productNum == 5) {
                      System.out.println("数量为5，开始消费");
                      while (Clerk.productNum > 0) {
                        Clerk.productNum -= 1;
                        System.out.println("库存:" + Clerk.productNum);
                      }
                      System.out.println("产品数达到0，停止消费");
                      c.notify(); // 唤醒生产者
                    } else {
                      try {
                        c.wait(); // 消费者等待
                      } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                      }
                    }
                  }
                }
              }
            },
            "消费者")
        .start();
  }
}
