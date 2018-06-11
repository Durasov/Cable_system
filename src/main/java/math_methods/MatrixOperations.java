package math_methods;

public class MatrixOperations {
    public static double[][] Mul_Matr_33_33(double[][] A, double[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static double[][] New_Transp_Matr_33 (double[][] A){

        double[][] B = new double[A.length][A.length];
        for (int i = 0; i < 3; i++) { // aRows
            for (int j = 0; j < 3; j++) { // bColumn
                B[i][j] = A[j][i];
            }
        }
        return B;
    }

    public static double[] Mul_Matr_88_81 (double[][] A, double[] B){

        double[] C = new double[8];
        for (int i = 0; i < 8; i++) {
            C[i] = 0.00000;
            for (int j = 0; j < 8; j++){
                C[i] += A[i][j] * B[j];
            }
        }
        return C;
    }

    public static void Vect_Vect_31 (double[] A, double[] B, double[] C){
        C[0] = A[1]*B[2]-A[2]*B[1];
        C[1] = A[2]*B[0]-A[0]*B[2];
        C[2] = A[0]*B[1]-A[1]*B[0];
    }

    public static double[] Mul_Matr_33_31 (double[][] A, double[] B){

        double[] C = new double[3];
        for (int i = 0; i < 3; i++) {
            C[i] = 0.00000;
            for (int j = 0; j < 3; j++){
                C[i] += A[i][j] * B[j];
            }
        }
        return C;
    }
    public static double[] Mul_Matr_31_Num(double[] A, double Num, double[] B){
        for(int i = 0; i < 2; i++) {
            B[i] = A[i] * Num;
        }
        return B;
    }

    public static double[] Add_Matr_31 (double[] A, double[] B){

        double[] C = new double[3];
        for (int i = 0; i < 3; i++) {
            C[i] = 0.00000;
            C[i] = A[i] + B[i];
        }
        return C;
    }

    public static double[] AddM_Matr_31 (double[] A, double[] B){

        double[] C = new double[3];
        for (int i = 0; i < 3; i++) {
            C[i] = 0.00000;
            C[i] = A[i] - B[i];
        }
        return C;
    }

    public static double Modul_Vect(double[] A){
        double Prom = 0;

        for (int j = 0; j < 2; j++){
            Prom += Math.pow(A[j],2);
        }
        return Math.sqrt(Prom);
    }
}
