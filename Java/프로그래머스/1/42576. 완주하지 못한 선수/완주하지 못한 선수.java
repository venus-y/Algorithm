import java.util.HashMap;
import java.util.Objects;


public class Solution {


    public static String solution(String[] participant, String[] completion) {
    // 참여자를 HashMap<String, Integer>에 담는다
    // 동명이인의 경우 기존 value + 1 처리한다.
    HashMap<String, Integer> participantMap = new HashMap<>();
    for (String s : participant) {
      participantMap.put(s, participantMap.getOrDefault(s, 0) + 1);
    }
    // 완주자목록을 HashMap<String, Integer>에 담는다.
    HashMap<String, Integer> completionMap = new HashMap<>();
    // 마찬가지로 동명이인의 경우 기존 value + 1 처리한다.
    for (String s : completion) {
      completionMap.put(s, completionMap.getOrDefault(s, 0) + 1);
    }

    // 참가자 목록을 반복문으로 순회하면서 완주자 목록의 Key값과 참가자목록의 Key값으로 value를 조회했을 때 값이 서로 다른 경우를 찾아 반환한다.
    for (String key : participantMap.keySet()) {
      if (!Objects.equals(completionMap.get(key), participantMap.get(key))
          || participantMap.get(key) == null) {
        return key;
      }
    }
    return "";
  }
}
