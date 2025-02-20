class Solution {
      public static String solution(String s) {
//        문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
//                str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
//    예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

        // 문자열을 공백 단위로 잘라서 새로운 문자열 배열에 담는다.
        String[] sArr = s.split("\\s+");

        // 최댓값 최솟값을 담을 min, max 변수를 선언 후 sArr의 첫번째 요소를 정수로 변환 후 담아준다.
        int min = Integer.parseInt(sArr[0]);
        int max = Integer.parseInt(sArr[0]);

        // 반복문으로 sArr를 순회하며 순회중인 sArr의 요소를 정수로 형변환했을 때 현재 min, max 값보다 작거나 크다면
        // min, max 값을 순회중인 요소의 값으로 대체한다.

        for(String parseS : sArr){
            if(max < Integer.parseInt(parseS))
                max = Integer.parseInt(parseS);
            else if(min > Integer.parseInt(parseS))
                min = Integer.parseInt(parseS);

        }

        // min + " " + max 의 값을 반환

        return min + " " + max;


    }
}