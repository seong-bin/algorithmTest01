package algorithm01;

//���α׷��ӽ� �ٸ��� ������ Ʈ��
//Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. 
//��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. 
//Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
//�� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.
public class TruckPassBridge {

	public static void main(String[] args) {
		int time = solution(2, 10, new int[] {7,4,5,6});
		System.out.println("��� Ʈ���� �ǳʴµ� �ɸ� �ð� = "+time);

	}
	//�ٸ� ���� bridge_length
	//�ٸ��� �ߵ� �� �ִ� ���� weight
	//Ʈ���� ���� truck_weights
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sec = 0;
        int[] passTruck = new int[truck_weights.length];

        while(passTruck.length == truck_weights.length) {
        	
        }
        
        return answer;
    }

}
