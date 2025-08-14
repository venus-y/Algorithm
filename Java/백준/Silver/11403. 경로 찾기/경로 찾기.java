import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int[][] maps;
  static int N;
  static Set<Integer> visitedVertexSet;
  static int[][] relationMap;
  static StringTokenizer st;
  static List<Integer>[] vertexList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    maps = new int[N][N];
    relationMap = new int[N][N];
    vertexList = new List[N];
    // 입력받은 인접행렬 상의 정점간의 관계를 maps에 저장
    for (int i = 0; i < maps.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < maps[i].length; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // vertexList에 List를 초기화
    for (int i = 0; i < vertexList.length; i++) {
      vertexList[i] = new ArrayList<>();
    }

    // 0~N-1번째 정점을 순회하며 maps[i][j]가 1인 경우 vertexList에 추가
    for (int i = 0; i < N; i++) {
      List<Integer> vertexRelation = vertexList[i];
      int[] map = maps[i];
      for (int j = 0; j < map.length; j++) {
        if (map[j] == 1) {
          vertexRelation.add(j);
        }
      }
    }

    // 각 정점들을 대상으로 순차적으로 dfs를 수행
    for (int i = 0; i < vertexList.length; i++) {
      visitedVertexSet = new HashSet<>();
      dfs(i);
      for (Integer visitedVertex : visitedVertexSet) {
        relationMap[i][visitedVertex] = 1;
      }
    }

    for (int i = 0; i < relationMap.length; i++) {
      for (int j = 0; j < relationMap[i].length; j++) {
        System.out.print(relationMap[i][j] + " ");
      }
      System.out.println();
    }


  }

  private static void dfs(int i) {
    List<Integer> vertexRelation = vertexList[i];
    for (int k = 0; k < vertexRelation.size(); k++) {
      Integer vertex = vertexRelation.get(k);
      if (visitedVertexSet.contains(vertex)) {
        continue;
      }
      visitedVertexSet.add(vertex);
      dfs(vertex);
    }
  }


}