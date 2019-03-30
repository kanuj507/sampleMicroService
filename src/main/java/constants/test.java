package constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 20;
        Integer m = new Integer(a);
        Integer m1 = Integer.valueOf(a);
        Integer m2 = a;
        System.out.println(m + " " + m1 + " " + m2);

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            sc.nextLine();
            int arrEle = sc.nextInt();
            String st = sc.nextLine();
            char[] ch = st.toCharArray();
            StringBuilder sr = null;
            sc.nextLine();
            List<Integer> arr = new ArrayList<Integer>();
            for (int t = 0; t < arrEle; t++) {
                // arr.add(sc.hasNext());
            }
            int size = arr.size();
            int[] pendulamArray = new int[arrEle];
            Collections.sort(arr);
            int mid;
            if (size % 2 == 1) {
                mid = (size / 2);

            } else {
                mid = (size / 2) - 1;
            }
            pendulamArray[mid] = arr.get(0);
            for (int j = 1, k = 1; k < arr.size(); k++, j++) {
                pendulamArray[mid + j] = arr.get(k);
                if (mid - j >= 0) {
                    k++;
                    pendulamArray[mid - j] = arr.get(k);
                }
            }

            for (int r : pendulamArray) {
                System.out.print(r + " ");
            }
        }
    }

}
