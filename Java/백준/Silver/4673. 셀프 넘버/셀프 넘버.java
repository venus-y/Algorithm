import java.io.IOException;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) throws IOException {

        HashSet<Integer> numbers = new HashSet<>();


        for (int i = 1; i <= 10000; i++) {
            if (!numbers.contains(i)) {
                System.out.println(i);
            }
            String parseValue = Integer.toString(i);
            int sum = i;
            for (int j = 0; j < parseValue.length(); j++) {
                sum += Integer.parseInt(String.valueOf(parseValue.charAt(j)));
            }
            numbers.add(sum);
        }

    }


}



