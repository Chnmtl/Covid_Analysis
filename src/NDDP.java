import java.text.*;
import java.math.*;

class NDDP {
    // Function to find the product term
    static float proterm(int i, float value, float x[])
    {
        float pro = 1;
        for (int j = 0; j < i; j++) {
            pro = pro * (value - x[j]);
        }
        return pro;
    }

    // Function for calculating
    static void dividedDiffTable(float x[], float y[][], int n)
    {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (x[j] - x[i + j]);
            }
        }
    }

    // Function for applying NDDP formula
    static float applyFormula(float value, float x[],
                              float y[][], int n)
    {
        float sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (proterm(i, value, x) * y[0][i]);
        }
        return sum;
    }

    // Function for displaying divided difference table
    static void printDiffTable(float y[][],int n)
    {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                String str1 = df.format(y[i][j]);
                System.out.print(str1+"\t ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        // number of inputs given
        int n = 4;
        float value, sum;
        float y[][]=new float[10][10];
        float x[] = { 8, 13, 18, 20 };

        // y[][] is used for divided difference
        // table where y[][0] is used for input
        y[0][0] = 38226;
        y[1][0] = 61049;
        y[2][0] = 82329;
        y[3][0] = 90980;

        dividedDiffTable(x, y, n);
        printDiffTable(y,n);
        value = 15;  // April 15
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("\nValue at "+df.format(value)+" is "
                +df.format(applyFormula(value, x, y, n)));
    }
}

