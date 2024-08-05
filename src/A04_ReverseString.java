/*

4. 단어 뒤집기

설명
N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

입력예제
3
good
Time
Big

출력예제
doog
emiT
giB

 */

import java.util.*;
import java.util.stream.Collectors;

public class A04_ReverseString {

    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public List<String> solution2(int n, String[] str) {
        return Arrays.stream(str)
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
    }

    public ArrayList<String> solution3(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        A04_ReverseString T = new A04_ReverseString();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}



