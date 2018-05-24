package math_methods;

public class Gaus {

    private static int u;
    private static double[][] A;
    private static double [] Y;
    private static int i,j,k,m;
    private static double temp;

    public static void init  (int u1,double [][] A1,double [] Y1){
        u = u1;
        A = A1;
        Y = Y1;
    }

    public static void algGaus(){
        isMatr();

    }
    private static int n = 0;
    private static void isMatr(){
        //n = 0;
        //n++;
        boolean f = false;
        for(k = n;k<=u;k++){
            if(A[k][n] != 0){
                N1();
                break;
            }
            else{
                System.out.println("МАТРИЦА ВЫРОЖДЕНА");
                System.exit(0);
            }
        }
    }

    private static void N1(){
        if(k == n){
            N2();
        } else {
            j = u + 1;
            for (m = n; m < j; m++) {
                temp = A[n][m];
                A[n][m] = A[k][m];
                A[k][m] = temp;
            }
        }
    }

    private static void N2(){
        for (j = u + 1; j > n; j--){
            A[n][j] = A[n][j]/A[n][n];
            m = u + 1;
        }
        for (i = k + 1; i < u; i++){
            for (j = n + 1; j < m; j++){
                A[i][j] = A[i][j] - A[i][n] * A[n][j];
            }
        }
        if (n != u) {
            n++;
            k++;
            isMatr();
        } else {
            for (i = u; i > 1; i--){
                Y[i] = A[i][m];
                for (k = i - 1; k > 1; k--){
                    A[k][m] = A[k][m] - A[k][i] * Y[i];
                }
            }
        }
    }
}
