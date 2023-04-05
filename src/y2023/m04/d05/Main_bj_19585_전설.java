package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Main_bj_19585_전설 {
    static class Node {
        boolean end;
        Node[] child = new Node['z'-'a'+1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        System.out.print(sb);
        br.close();
    }
}
