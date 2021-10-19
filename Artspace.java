package 반복5;

/*
 * 당신은 미술품 경매에 참여합니다.
 * 총 3명이 참여하고 돌아가면서 금액을 부릅니다.
 * 제일 큰 금액을 부른사람과 그 사람이 부른 가격을 출력합니다.
 * 턴은 입력받은 만큼 돌아갑니다.
 * 
 * -1 를 입력할 시 포기신호로 간주하고 해당 선수는 제외합니다. 뒤에 있는 선수들은 자동으로 앞쪽 번호로 이동하도록 합니다.
 * 입찰 시작 시 진행자는 시작 가격을 입력합니다. 선수들은 시작가격 이상으로 제시하고 그러지 않을 시 포기로 간주합니다.
 * 선수들 세명이 모두 0, 0, 0을 입력 시 3 2 1을 출력하고(카운트다운) 후에 max와 who값을 입력한다.
 */

import java.util.Scanner;
public class Artspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int max = 0, who=0;
		int count=0, i, turn = 0, result = 0, check=0, same = 0;
		
		System.out.print("턴을 몇번 돌릴까요 ? : "); 
				
		try {
			turn = scan.nextInt(); //오류가 날 가능성이 있는 입력받는 문장입니다(ex: ㅁㅁ, aa)
			/*입력을 int형으로 받고 int형으로 입력을 받지 않았을 때 
			 * catch로 받아서 오류가 났다는 문장을 출력하게 합니다.
			 */
		}catch(Exception e){
			System.out.println("정수형으로만 입력이 가능합니다.");//try에서 오류가 발생하면 출력하는 문장입니다.
			check = 1; // 아래에 있는 while문에서 사용예정입니다. 입력이 정수가 아닐때 check를 1로 변환합니다.
		}finally { //반드시 실행
			System.out.println(turn + "번의 턴을 진행합니다.");
			//입력에 오류가 나지 않았을 경우 출력문장입니다.
		}
		while(check==0) { 
			/*check == 1일때는 입력이 정수가 아닐때로 while문이 실행되지않고 프로그램이 끝납니다.
			 *check == 0일때는 입력이 정수형으로 while문을 실행합니다. 
			 */
			for(i = 1; i<=turn; i++) { //입력받은 턴의 횟수만큼 for문을 활용하여 현재의 턴 횟수를 출력합니다.
				System.out.println(i + "번째 턴입니다. ");
				for(int j = 1; j<=3; j++) { //한번의 턴 당 세명의 선수의 금액을 입력받습니다.
					System.out.print(j + "번째 사람 : ");
					int n = scan.nextInt(); //금액을 입력받는 부분입니다.
					same += n; //세명의 선수들이 똑같은 금액을 입력받을 시에 사용할 수식입니다. 
					           //입력받은 금액을 모두 same에 더해 저장합니다.
					if(n==0) { //세명의 선수가 모두 0을 입력받았을때 사용할 문장입니다.
						count++; //입력받은 수가 0일 때 count를 1씩 증가시킵니다.
					}
					if(n>max) { //입력받은 수가 최대값(max)보다 크면
						max = n; //n값을 max에 넣어줍니다.
						who = j; //금액을 입력한 선수의 번호를 who에 넣어줍니다. 
					}
					if(j==3&&same == n*3&&same!=0) { 
						/*만약 세명의 선수가 입력한 금액을 모두 저장한 same이 n*3과 같다면
						 * 세명의 선수가 모두 같은 금액을 입력한 것이라고 알 수 있습니다.
						 * 이때 same이 0과 같다면 세 선수가 모두 0을 입력한 것이므로 else문으로 이동합니다.*/
						System.out.println("세 선수가 같은 금액을 입력하였습니다. 방금 턴으로 다시 되돌아갑니다.");
						same = 0;
						i--;
						/*세 선수의 금액이 모두 같다는 문장을 출력하고 방금의 턴을 다시 진행하기 위해 i에 1을 감소시킵니다.
						 * 새로 진행하는 턴에서도 세 선수가 같은 금액을 입력할 수 있으므로 
						 * 새로 계산하기 위해 same을 0으로 초기화 시킵니다.*/
					}else{
						continue; //continue를 사용해 아래에 있는 if문(세 선수 기권시)으로 이동합니다.
					}
				}
				if(count==3) { //위에서 사용했던 count변수가 3일때 (세명의 선수가 모두 0을 입력했을 떄)
					System.out.println("세 선수가 모두 기권하였습니다. 카운트 다운을 시작합니다.");
					//세 선수를 모두 기권으로 간주하고 더이상 다음턴을 진행하지 않습니다.
					for(i = 3; i>= 1; i--) {
						System.out.println(i);
						//카운트다운 출력 부분입니다.
					}
					System.out.println("최종 입찰자는 이러합니다.");
					break;
					//다음턴으로 진행하지 않기위해 break문을 사용하여 빠져나갑니다.
				}
			}
			System.out.println("제일 큰 금액은 " + max + "원, 가격을 부른 사람은 " + who + "번째 사람입니다.");
			check = 1;
			//최종 출력문장을 출력하고 check를 1로 바꾸어 더이상 while문이 진행되지 못하게 합니다.
			//프로그램을 종료합니다.
		}
	}
}

