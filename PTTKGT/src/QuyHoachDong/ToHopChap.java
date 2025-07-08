package QuyHoachDong;

import java.util.Arrays;

public class ToHopChap {

    public static void main(String[] args) {

        int n = 10;
        int k = 10;
        int[][] C = new int[n + 1][k + 1];  // cần mảng đủ chỗ cho C[n][k]

        // Gán giá trị cho C[0][i] và C[i][i]
        for (int i = 0; i <= n; i++) {
            C[0][i] = 1;    // Có 1 cách chọn 0 phần tử
            C[i][i] = 1;    // Có 1 cách chọn toàn bộ i phần tử
        }

        // Sử dụng công thức tổ hợp động
        for (int i = 1; i <= k; i++) {        // số phần tử muốn chọn
            for (int j = i + 1; j <= n; j++) {  // số phần tử trong tập gốc
                C[i][j] = C[i - 1][j - 1] + C[i][j - 1];
            }
        }

        // In kết quả tổ hợp C[k][n]
        System.out.println("Tổ hợp C(" + n + ", " + k + ") = " + C[k][n]);

        // Nếu muốn in nguyên bảng:
        System.out.println(Arrays.deepToString(C));

    }
}
