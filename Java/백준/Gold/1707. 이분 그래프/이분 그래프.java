import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int v;
    static int e;

    static ArrayList<Integer>[] vertex;

    static String answer = "YES";

    static boolean[] check;

    static HashMap<Integer, color> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        k = Integer.parseInt(tokenizer.nextToken());

        int testCnt = 0;

        while (testCnt!= k){
           answer = "YES";

            tokenizer = new StringTokenizer(br.readLine());
        v = Integer.parseInt(tokenizer.nextToken());
        e = Integer.parseInt(tokenizer.nextToken());

        vertex = new ArrayList[v+1];
        check = new boolean[v+1];

        for(int i=1; i<=v; i++){
            vertex[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(tokenizer.nextToken());
            int v2 = Integer.parseInt(tokenizer.nextToken());

            vertex[v1].add(v2);
            vertex[v2].add(v1);
        }

        for(int i=1; i<vertex.length; i++){
            if(!check[i]){
                dfs(i, color.RED);
            }
        }

        System.out.println(answer);

        testCnt++;
        }




    }

    private static void dfs(int v, color color) {
        check[v] = true;
        hashMap.put(v, color);

        if(color == Main.color.RED){
            color = Main.color.BLUE;
        }else {
            color = Main.color.RED;
        }

        for(int i=0; i<vertex[v].size(); i++){
            if(!check[vertex[v].get(i)]){

                dfs(vertex[v].get(i), color);
            }else {
                if(hashMap.get(v).equals(hashMap.get(vertex[v].get(i)))){
                    answer = "NO";
                }
            }
        }

    }

    public enum color {
        RED, BLUE
    }


}



