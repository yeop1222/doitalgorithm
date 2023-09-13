package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1541
public class Main036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        String[] str1 = formula.split("-");
        int answer = 0;
        for(int i=0; i< str1.length; i++) {
            int num = 0;
            String[] str2 = str1[i].split("\\+");
            for(String t : str2) {
                num += Integer.parseInt(t);
            }
            if(i == 0) {
                answer += num;
            } else {
                answer -= num;
            }
        }
        System.out.println(answer);
    }
}
