import java.util.Scanner;
/**
 * 测试Game类
 * @author
 *
 */
public class Test {

	/**
	 * 实例化Game类对象，
	 * 对Game类中的两个方法Josephus_1()和Josephus_2()分别进行测试
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("游戏人数是？");
		int amountOfPlayer = sc.nextInt();
		System.out.println("叫到几的玩家被杀死？");
		int deathNumber = sc.nextInt();
		System.out.println("游戏从几号玩家开始？");
		int startFrom = sc.nextInt();
		Game testGame = new Game(amountOfPlayer, deathNumber, startFrom);
		System.out.println("========== josephus_1() =========");
		testGame.josephus_1();
		System.out.println("========== josephus_2() =========");
		testGame.josephus_2();
	}

}
