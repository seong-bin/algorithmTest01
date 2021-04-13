package algorithm01;

public class OneTowFourCountry {
//	124 ���� �ֽ��ϴ�. 124 ���󿡼��� 10������ �ƴ� ������ ���� �ڽŵ鸸�� ��Ģ���� ���� ǥ���մϴ�.
//
	//	124 ���󿡴� �ڿ����� �����մϴ�.
	//	124 ���󿡴� ��� ���� ǥ���� �� 1, 2, 4�� ����մϴ�.
//	���� �� 124 ���󿡼� ����ϴ� ���ڴ� ������ ���� ��ȯ�˴ϴ�.
	//10���� 124����   10���� 124����
	//	1	1		6	14
	//	2	2		7	21
	//	3	4		8	22
	//	4	11		9	24
	//	5	12		10	41
//	�ڿ��� n�� �Ű������� �־��� ��, n�� 124 ���󿡼� ����ϴ� ���ڷ� �ٲ� ���� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
	public static void main(String[] args) {
		System.out.println("solution = "+solution(15));

	}

	public static String solution(int n) {
		String[] numbers = {"4", "1", "2"};
        String answer = "";
        
        int num = n;
        
        while(num > 0){
            int remainder = num % 3;
            System.out.println("remainder = "+remainder);
            num /= 3;
            System.out.println("num /= 3 = "+num);
            if(remainder == 0) {
            	num--;
                System.out.println("num-- = "+num);
            }
            System.out.println("----------------");
            answer = numbers[remainder] + answer;
        }
        
        return answer;
    }
}
