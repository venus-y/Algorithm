import java.util.*;

class Solution {
    public static int solution(String[][] clothes) {
    Map<String, Integer> categoryCounterMap = new HashMap<>();
    
    int answer = 1;
        
        
    for(int i=0; i<clothes.length; i++) {
        String category = clothes[i][1];
        categoryCounterMap.put(category, categoryCounterMap.getOrDefault(category,0)+1);
        
            
    }
        
    for(String key : categoryCounterMap.keySet()){
            answer *= categoryCounterMap.get(key) + 1;
        }    
        
        
        if(answer == 1) {
            return answer;
        }
        
        return answer - 1;
}
    
}