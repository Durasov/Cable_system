package math_methods;

public class Gaus {
    public static double[] gaussSeidel(double[][] A, double[] b){
        int count = 0;
        boolean stop = false;

        double[] xNew = new double[b.length]; // x2 = 0, x3 = 0,
        double[] xOld = new double[b.length];

        do{
            for(int i = 0; i < A.length; i++){
                double sum = 0.0;
                double sum1 = 0.0;
                for(int j = 0; j < A.length; j++){
                    if( j != i)
                        sum += (A[i][j]*xOld[j]);
                    sum1 += (A[i][j]*xNew[j]);
                }
                xNew[i] = (b[i] - sum - sum1)*(1/A[i][i]);
                count++;

                if(Math.abs(xNew[i] - xOld[i]) > 1){
                    xNew[i] = xOld[i];
                }

                else{
                    stop = true;}
            }
        }while( !stop && count <= 8);
        return xNew;
    }
}
