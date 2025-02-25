import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int solution(String t, String p) {


        // 문자열을 현재시작위치 ~ 현재시작위치 + n 까지 자른후 문자열배열에 넣는다. -> i가 문자열의 길이 - n일때까지 반복
        // 3141592의 경우 314, 141, 415, 159, 592  <- i가 4일 경우 3141592에서 5의 위치에 해당한다.
        // 5에서 n칸 더가면 문자열의 끝이므로 종료

        List<String> sList = new ArrayList<>();

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (t.substring(i, i + p.length()).charAt(0) == '0' && t.substring(i, i + p.length()).length() == 1) {
                sList.add(t.substring(i, i + p.length()));
                continue;
            }
            if (t.substring(i, i + p.length()).charAt(0) == '0') {
                String tempS = t.substring(i, i + p.length());
                String transS = tempS.substring(1, tempS.length());
                sList.add(transS);
                continue;
            }
            sList.add(t.substring(i, i + p.length()));
        }

//        for(int i=0; i<sList.size(); i++){
////            System.out.print(sList.get(i) + ",");
//        }

        int answer = 0;

        long pLong = Long.parseLong(p);
        // p의 앞자리가 0으로 시작할 경우 0을 제거한다.
        if (Long.toString(pLong).charAt(0) == '0') {
    pLong = Long.parseLong(Long.toString(pLong).substring(1));
    }

    for (int i = 0; i < sList.size(); i++) {
        long currentValue = Long.parseLong(sList.get(i));
        if (currentValue <= pLong) {
            answer++;
        }
    }

        return answer;


    }
}