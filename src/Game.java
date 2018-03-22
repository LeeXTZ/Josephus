import java.util.Scanner;
import java.util.Arrays;

/**
 * �ڶ���ʵϰ ��Ŀ1�����������Լɪ��
 * ģ��Լɪ����Ϸ���̵���
 * �����ֲ�ͬ��ʽ�ֱ�ʵ����Ϸ���̣�
 * ����Josephus_1()ͨ����������ɾ������ɱ���������ģ����Ϸ
 * ����Josephus_2()��ͨ��������ɱ������ҵ�isAlive������Ϊfalse��ģ����Ϸ
 * @author 114151��-������-20151001251
 * 
 */

public class Game {
	private int amountOfPlayer;
	private Player[] queue;
	private int deathNumber; // ��Ϸ�не�deathNumber����ұ�ɱ��
	private int startFrom; // ��Ϸ�ӱ��ΪstartFrom����ҿ�ʼ

	public Game(int aOP, int dN, int sF) {
		amountOfPlayer = aOP;
		deathNumber = dN;
		startFrom = sF;
	}

	public Game(int aOP, int dN) { // ��ΪJava�޷����ò���Ĭ��ֵ�����ԶԹ��캯����������
		amountOfPlayer = aOP;
		deathNumber = dN;
		startFrom = 1; // ��������startFrom��Ĭ�ϴ�1�ſ�ʼ
	}

	public void gatherThePlayers() {
		queue = new Player[amountOfPlayer];
		Player p = new Player();
		for (int i = 0; i < amountOfPlayer; ++i) {
			queue[i] = new Player();
			System.out.println("������" + (i + 1) + "�����������");
			Scanner sc = new Scanner(System.in);
			queue[i].name = sc.next();
			queue[i].serialNumber = i + 1;
			queue[i].isAlive = true;
		}
	}

	public void josephus_1() {
		this.gatherThePlayers();
		System.out.println("\n>>>>>>>>>>josephus_1 Start");
		int number = 0; // ��Һ�������
		for (int i = startFrom - 1; queue.length > 1; ++i) {
			++number;
			if (number == deathNumber) {
				String name = queue[i].name;
				int sNumber = queue[i].serialNumber;
				System.out.println(sNumber + "�� " + name + " ��ɱ��");
				for (int ii = i; ii < queue.length - 1; ++ii) {// ��������ɾ����ɱ�������
					queue[ii] = queue[ii + 1];
				}
				queue = Arrays.copyOf(queue, queue.length - 1);
				--i; // ɾ����ɱ������Һ����ڱ�ɱ�����֮�����ҵ�������������� 1
				number = 0; // ����ҳ��ֺ����¿�ʼ����

				System.out.println("ʣ�µ���ң�");
				String nowQueue = "[";
				for (Player p : queue) {
					String pInfo = p.serialNumber + "��" + p.name + ", ";
					nowQueue += pInfo;
				}
				nowQueue += "]";
				System.out.println(nowQueue + "\n");
			}

			if (i >= (queue.length - 1)) // ����ֵ��˶������һ�ˣ�֮��ӵ�һ���˿�ʼ
				i = -1;
		}
		System.out.println(">>>>>>>>>>>>josephus_1 End\n");
	}

	public void josephus_2() {
		this.gatherThePlayers();
		System.out.println("\n>>>>>>>>>>Josephus_2 start");
		int number = 0; // ��ұ�������
		for (int i = startFrom - 1; amountOfPlayer > 1; ++i) {
			if (queue[i].isAlive) {
				++number;
				if (number == deathNumber) {
					queue[i].isAlive = false;
					String name = queue[i].name;
					int sNumber = queue[i].serialNumber;
					System.out.println(sNumber + "�� " + name + " ��ɱ��");
					--amountOfPlayer;
					number = 0; // ����ҳ��ֺ���һ�������¿�ʼ����

					System.out.println("ʣ�µ���ң�");
					String nowQueue = "[";
					for (Player p : queue) {
						if (p.isAlive) {
							String pInfo = p.serialNumber + "��" + p.name + ", ";
							nowQueue += pInfo;
						}
					}
					nowQueue += "]";
					System.out.println(nowQueue + "\n");
				}
			}
			if (i == (queue.length - 1)) // ����ֵ����е����һ�ˣ�֮��ӵ�һ���˿�ʼ
				i = -1;
		}
		System.out.println(">>>>>>>>>>>>josephus_2 End");

	}

}
