package second;

import java.util.*;

public class StudentListManager {

   public static void main(String[] args) {
	   HashMap<String, Student> st = new HashMap<>();
	   
	   st.put("유재석", new Student());

      HashMap<String, Integer> map = new HashMap<>();
      map.put("이동국", 88);
      map.put("이천수", 99);
      map.put("최용수", 77);

      System.out.println(map + "\n");
      
      System.out.println(map.get("이동국"));
      map.put("이동국", 75);
      double average = calculateAverage(map);
      System.out.println("Average score: " + average);
      System.out.println(map);
      map.remove("이천수");
      System.out.println(map);
      

   }

   public static double calculateAverage(HashMap<String, Integer> map) {
      double sum = 0;
      for (int score : map.values()) {
         sum += score;
      }
      return sum / map.size();
   }

}
