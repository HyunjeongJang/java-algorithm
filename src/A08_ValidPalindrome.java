import java.util.Scanner;

/*

8. 유효한 팰린드롬

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다. 알파벳 이외의 문자들의 무시합니다.

입력설명
첫 줄에 길이 100을 넘지 않는 문자열이 주어집니다.

출력설명
첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.

입력예제
found7, time: study; Yduts; emit, 7Dnuof

출력예제
YES

 */
public class A08_ValidPalindrome {

    public String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]",""); // 대문자 아닌것 제거
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) {
            answer = "YES";
        }
        return answer;
    }

    public String solution2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 왼쪽 포인터가 알파벳이 아닌 경우 오른쪽으로 이동
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            // 오른쪽 포인터가 알파벳이 아닌 경우 왼쪽으로 이동
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            // 대소문자 무시하고 비교
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return "NO";
            }
            left++;
            right--;
        }

        return "YES";
    }


    public static void main(String[] args) {
        A08_ValidPalindrome T = new A08_ValidPalindrome();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }

}
