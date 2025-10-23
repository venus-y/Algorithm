import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

  static int N;


  public static void main(String[] args) throws Exception {
    Map<String, Integer> extMap = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String input;
    for (int i = 0; i < N; i++) {
      input = br.readLine();
      String[] parts = input.split("\\.");
      String ext = parts[1];
      extMap.put(ext, extMap.getOrDefault(ext, 0) + 1);
    }
    Set<String> keySet = extMap.keySet();
    ArrayList<String> extList = new ArrayList<>(keySet);
    Collections.sort(extList);

    for (int i = 0; i < extList.size(); i++) {
      String ext = extList.get(i);
      Integer count = extMap.get(ext);
      System.out.println(ext + " " + count);
    }


  }


}