import java.util.Scanner;
/**
 * ����Game��
 * @author 114151��-������-20151001251
 *
 */
public class Test {

	/**
	 * ʵ����Game�����
	 * ��Game���е���������Josephus_1()��Josephus_2()�ֱ���в���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��Ϸ�����ǣ�");
		int amountOfPlayer = sc.nextInt();
		System.out.println("�е�������ұ�ɱ����");
		int deathNumber = sc.nextInt();
		System.out.println("��Ϸ�Ӽ�����ҿ�ʼ��");
		int startFrom = sc.nextInt();
		Game testGame = new Game(amountOfPlayer, deathNumber, startFrom);
		System.out.println("========== josephus_1() =========");
		testGame.josephus_1();
		System.out.println("========== josephus_2() =========");
		testGame.josephus_2();
	}

}
