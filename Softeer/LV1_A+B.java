import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int A, B;

        for(int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(A+B).append("\n");
            
        }

        System.out.println(sb.toString());
        
    }
}