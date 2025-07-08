package QuyHoachDong;

public class CoinRow {

    public static void main(String[] args) {
        int[] C = {5, 1, 2, 10, 6, 2};
        System.out.println(coinRow(C));

    }

    private static int coinRow(int[] C) {
        int[] F = new int[C.length];
        F[0] = 0;
        F[1] = C[0];
        for (int i = 2; i < C.length; i++) {
            F[i] = Math.max(C[i] + F[i - 2], F[i - 1]);
        }
        return F[C.length - 1];
    }
}
