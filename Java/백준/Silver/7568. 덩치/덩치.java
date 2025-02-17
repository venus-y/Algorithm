import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Human[] humans = new Human[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            humans[i] = new Human(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                humans[i].compare(humans[j]);
            }
        }

        for(int i=0; i<humans.length; i++) {
           if(i != humans.length - 1) {
               System.out.print(humans[i].rank + " ");
           }else {
               System.out.print(humans[i].rank);
           }
        }




    }

    public static class Human {
        int weight;
        int height;
        int rank = 1;
        public Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public void compare(Human other) {
            if(this.weight < other.weight && this.height < other.height) {
                this.rank++;
            }
        }

    }



}
