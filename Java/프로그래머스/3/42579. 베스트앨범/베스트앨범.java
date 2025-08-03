import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
    TreeMap<String, Integer> tempMap = new TreeMap<>();
    for (int i = 0; i < genres.length; i++) {
      tempMap.put(genres[i], tempMap.getOrDefault(genres[i], 0) + plays[i]);
    }

    // 장르별 재생횟수를 기준으로 내림차순 정렬 후 TreeMap에 저장
    Comparator<String> genreComparator = (k1, k2) -> tempMap.get(k2).compareTo(tempMap.get(k1));
    TreeMap<String, Integer> genreMap = new TreeMap<>(genreComparator);
    genreMap.putAll(tempMap);

    // 장르별로 구분해서 HashMap에 저장
    Map<String, Set<GenreInfo>> genreInfoMap = new HashMap<>();

    Comparator<GenreInfo> DESC_BY_PLAYED_THEN_ASC_BY_NO =
        (g1, g2) -> {
          if (g1.playedCount != g2.playedCount) {
            return Integer.compare(g2.playedCount, g1.playedCount); // 내림차순
          }
          return Integer.compare(g1.no, g2.no); // 오름차순
        };

    for (String s : genreMap.keySet()) {
      genreInfoMap.putIfAbsent(s, new TreeSet<>(DESC_BY_PLAYED_THEN_ASC_BY_NO));
    }

    for (int i = 0; i < genres.length; i++) {
      genreInfoMap.get(genres[i]).add(new GenreInfo(i, plays[i]));
    }

    List<Integer> answerList = new ArrayList<>();

    for (String key : genreMap.keySet()) {
      Set<GenreInfo> genreInfos = genreInfoMap.get(key);
      if (genreInfos.size() == 1) {
        answerList.add(new ArrayList<>(genreInfos).get(0).no);
      } else {
        ArrayList<GenreInfo> genreInfoList = new ArrayList<>(genreInfos);
        answerList.add(genreInfoList.get(0).no);
        answerList.add(genreInfoList.get(1).no);
      }
    }

    int[] answers = answerList.stream()
        .mapToInt(Integer::intValue)
        .toArray();
    return answers;
  }

  public static class GenreInfo {

    int no;
    int playedCount;

    public GenreInfo(int no, int playedCount) {
      this.no = no;
      this.playedCount = playedCount;
    }
  }
}