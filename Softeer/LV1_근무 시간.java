import java.io.*;
import java.util.*;
import java.text.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        Date startTime = new Date();
        Date endTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long sum = 0;
        
        for(int i = 0; i < 5; i++) {

            st = new StringTokenizer(br.readLine());

            try {
                startTime = sdf.parse(st.nextToken());
                endTime = sdf.parse(st.nextToken());
            } catch (Exception e) {
                e.printStackTrace();
            }

            sum += (endTime.getTime() - startTime.getTime()) / 60000;
            
        }

        System.out.println(sum);
    }
    
}