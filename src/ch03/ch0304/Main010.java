package ch03.ch0304;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 11003
public class Main010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Data> deque = new LinkedList<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 이값보다 큰 것 삭제
            while(!deque.isEmpty() && deque.getLast().value > num) {
                deque.removeLast();
            }
            // 맨 뒤에 추가
            deque.addLast(new Data(i, num));

            // window 범위 벗어난것 제거
            if(deque.getFirst().index < i-L+1) {
                deque.removeFirst();
            }
            // 최소값(첫번째 값) 작성
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
    }

    static public class Data {
        public int index;
        public int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
