import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        if(n%3 ==0){
            answer = n/3;
        }else if(n%3 !=0 ){
            int total = n;
            int count = 1;
            int increase = 3;
            while (total >= increase) {
                int left = total - increase;
                if(left%5==0){
                    answer = count + left/5;
                }
                count++;
                increase+=3;
            }

        }
        if(n%5 ==0){
            answer = n/5;
        }
        if(n%5 != 0){
            int total = n;
            int count = 1;
            int increase = 5;
            while (total >= increase) {
                int left = total - increase;
                if(left%3==0){
                    answer = count + left/3;
                }
                count++;
                increase+=5;
            }
        }

        System.out.println(answer);


    }



}

