import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static boolean validateWordsSimilarity(String word, String word2) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == word2.charAt(i)) {
        count++;
      }
    }
    return count + 1 == word.length();
  }
    
    public int solution(String begin, String target, String[] words) {
    // 단어를 담을 큐
    Queue<String> wordQueue = new LinkedList<>();
    // 현재 단어가 몇 번이나 변환되었는지를 기록하는 Map
    Map<String, Integer> recordingAboutUsedCountMap = new HashMap<>();
    // 사용할 수 있는 words를 Set에 저장
    Set<String> wordSet = new HashSet<>(List.of(words));
    // target이 wordSet에 존재하지 않을 경우 0을 반환
    if (!wordSet.contains(target)) {
      return 0;
    }
    // 이미 변환에 사용된 단어를 체크하기 위한 Set
    Set<String> usedWords = new HashSet<>();
    // 변환횟수를 의미하는 answer
    int answer = 0;
    //시작단어부터 wordQueue, recordingAboutUsedCountMap, usedWords에 저장하는 것으로 초기화한다.
    wordQueue.add(begin);
    recordingAboutUsedCountMap.put(begin, 0);
    usedWords.add(begin);
    //이후 시작단어부터 큐에서 poll한 후 시작단어에서 변환이 가능한 단어들을 wordQueue, recordingAboutUsedCountMap, usedWords에 추가하는 것을 반복한다.
    while (!wordQueue.isEmpty()) {
      String word = wordQueue.poll();
      Integer level = recordingAboutUsedCountMap.get(word);
      if (word.equals(target)) {
        return level;
      }
      for (int i = 0; i < words.length; i++) {
        if (usedWords.contains(words[i])) {
          continue;
        }
        if (validateWordsSimilarity(word, words[i])) {
          wordQueue.add(words[i]);
          recordingAboutUsedCountMap.put(words[i], level + 1);
          usedWords.add(words[i]);
        }
      }
    }

    //위 과정을 반복하면서 target을 찾았을 경우 그 시점의 변환횟수를 반환한다.

    // wordQueue의 사이즈가 0이 되었을 때까지 target을 찾지 못할 경우 0을 반환

    return answer;
  }
}