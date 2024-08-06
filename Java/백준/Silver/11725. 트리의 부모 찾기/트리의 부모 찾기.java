import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] vertexList;
    static boolean[] checkList;

    static Integer N;
    static int[] parentNodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        vertexList = new ArrayList[N+1];

        for(int i=0; i<vertexList.length; i++){
            vertexList[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            vertexList[v1].add(v2);
            vertexList[v2].add(v1);
        }

        checkList = new boolean[N+1];

        parentNodeList = new int[N+1];



        dfs(1);
        for(int i=2; i<parentNodeList.length; i++){
            System.out.println(parentNodeList[i]);
        }
    }

    public static void dfs(int v){
        checkList[v] = true;
        for(int i=0; i<vertexList[v].size(); i++){
            Integer currentV = vertexList[v].get(i);
            if(!checkList[currentV]){
                parentNodeList[currentV] = v;
                dfs(currentV);
            }
        }

    }

}

