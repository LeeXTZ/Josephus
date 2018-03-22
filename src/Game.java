import java.util.Scanner;
import java.util.Arrays;

/**
 * 第二次实习 题目1：用数组求解约瑟夫环
 * 模拟约瑟夫环游戏过程的类
 * 用两种不同方式分别实现游戏过程：
 * 方法Josephus_1()通过从数组中删除“被杀掉”玩家来模拟游戏
 * 方法Josephus_2()则通过将“被杀掉”玩家的isAlive属性置为false来模拟游戏
 * @author
 * 
 */

public class Game {
	private int amountOfPlayer;
	private Player[] queue;
	private int deathNumber; // 游戏中叫到deathNumber的玩家被杀掉
	private int startFrom; // 游戏从编号为startFrom的玩家开始

	public Game(int aOP, int dN, int sF) {
		amountOfPlayer = aOP;
		deathNumber = dN;
		startFrom = sF;
	}

	public Game(int aOP, int dN) { // 因为Java无法设置参数默认值，所以对构造函数进行重载
		amountOfPlayer = aOP;
		deathNumber = dN;
		startFrom = 1; // 若不输入startFrom，默认从1号开始
	}

	public void gatherThePlayers() {
		queue = new Player[amountOfPlayer];
		Player p = new Player();
		for (int i = 0; i < amountOfPlayer; ++i) {
			queue[i] = new Player();
			System.out.println("请输入" + (i + 1) + "号玩家姓名：");
			Scanner sc = new Scanner(System.in);
			queue[i].name = sc.next();
			queue[i].serialNumber = i + 1;
			queue[i].isAlive = true;
		}
	}

	public void josephus_1() {
		this.gatherThePlayers();
		System.out.println("\n>>>>>>>>>>josephus_1 Start");
		int number = 0; // 玩家喊的数字
		for (int i = startFrom - 1; queue.length > 1; ++i) {
			++number;
			if (number == deathNumber) {
				String name = queue[i].name;
				int sNumber = queue[i].serialNumber;
				System.out.println(sNumber + "号 " + name + " 被杀掉");
				for (int ii = i; ii < queue.length - 1; ++ii) {// 从数组中删除被杀掉的玩家
					queue[ii] = queue[ii + 1];
				}
				queue = Arrays.copyOf(queue, queue.length - 1);
				--i; // 删除被杀掉的玩家后，排在被杀掉玩家之后的玩家的数组索引都会减 1
				number = 0; // 有玩家出局后，重新开始报数

				System.out.println("剩下的玩家：");
				String nowQueue = "[";
				for (Player p : queue) {
					String pInfo = p.serialNumber + "号" + p.name + ", ";
					nowQueue += pInfo;
				}
				nowQueue += "]";
				System.out.println(nowQueue + "\n");
			}

			if (i >= (queue.length - 1)) // 如果轮到了队列最后一人，之后从第一个人开始
				i = -1;
		}
		System.out.println(">>>>>>>>>>>>josephus_1 End\n");
	}

	public void josephus_2() {
		this.gatherThePlayers();
		System.out.println("\n>>>>>>>>>>Josephus_2 start");
		int number = 0; // 玩家报的数字
		for (int i = startFrom - 1; amountOfPlayer > 1; ++i) {
			if (queue[i].isAlive) {
				++number;
				if (number == deathNumber) {
					queue[i].isAlive = false;
					String name = queue[i].name;
					int sNumber = queue[i].serialNumber;
					System.out.println(sNumber + "号 " + name + " 被杀掉");
					--amountOfPlayer;
					number = 0; // 有玩家出局后，下一个人重新开始报数

					System.out.println("剩下的玩家：");
					String nowQueue = "[";
					for (Player p : queue) {
						if (p.isAlive) {
							String pInfo = p.serialNumber + "号" + p.name + ", ";
							nowQueue += pInfo;
						}
					}
					nowQueue += "]";
					System.out.println(nowQueue + "\n");
				}
			}
			if (i == (queue.length - 1)) // 如果轮到队列的最后一人，之后从第一个人开始
				i = -1;
		}
		System.out.println(">>>>>>>>>>>>josephus_2 End");

	}

}
