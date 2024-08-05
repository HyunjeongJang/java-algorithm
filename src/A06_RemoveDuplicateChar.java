/*

6. 중복문자제거

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하 세요.
제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.

입력예제
ksekkset

출력예제
kset

 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A06_RemoveDuplicateChar {

    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public String solution2(String str) {
        return IntStream.range(0, str.length())
                .filter(i -> str.indexOf(str.charAt(i)) == i)
                .mapToObj(str::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        A06_RemoveDuplicateChar T = new A06_RemoveDuplicateChar();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
