import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int N;
  public static int M;
  public static int V;
  public static StringTokenizer st;
  public static ArrayList<Integer>[] lines;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    lines = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      lines[i] = new ArrayList<>();
    }
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      lines[a].add(b);
      lines[b].add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(lines[i]);
    }

    dfs(V);
    // 여기서부터 dfs
    System.out.println();
    visited = new boolean[N + 1];
    bfs(V);

  }

  public static void dfs(int v) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    System.out.print(v + " ");
    for (int j : lines[v]) {
      if (!visited[j]) {
        dfs(j);
      }
    }
  }

  public static void bfs(int v) {
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    visited[v] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();
      System.out.print(cur + " ");
      for (int j : lines[cur]) {
        if (!visited[j]) {
          visited[j] = true;
          q.add(j);
        }
      }
    }

  }


}

