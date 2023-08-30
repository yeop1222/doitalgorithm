package ch03.ch0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12891
public class Main009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] str = br.readLine().toCharArray();
        int[] answerArr = new int[4];
        int[] currArr = new int[4];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            answerArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<P; i++) {
            if(str[i] == 'A') {
                currArr[0]++;
            } else if(str[i] == 'C') {
                currArr[1]++;
            } else if(str[i] == 'G') {
                currArr[2]++;
            } else {
                currArr[3]++;
            }
        }
        answer += answerCheck(currArr, answerArr);

        for(int i=1; i<S-P+1; ++i) {
            currArr[getIndex(str[i-1])]--;
            currArr[getIndex(str[i+P-1])]++;
            answer += answerCheck(currArr, answerArr);
        }

        System.out.println(answer);
    }

    private static int answerCheck(int[] currArr, int[] answerArr) {

        for(int i=0; i<4; i++) {
            if (currArr[i] < answerArr[i]) {
                return 0;
            }
        }
        return 1;
    }

    private static int getIndex(char ch) {
        if(ch=='A') {
            return 0;
        } else if(ch=='C') {
            return 1;
        } else if(ch=='G') {
            return 2;
        } else {
            return 3;
        }
    }
}
