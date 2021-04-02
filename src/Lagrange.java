class Lagrange
{
    static class Data
    {
        int x, y;

        public Data(int x, int y)
        {
            super();
            this.x = x;
            this.y = y;
        }

    };

    // function to interpolate the given data points using Lagrange's formula
    // xi corresponds to the new data point


    static double interpolate(Data f[], int xi, int n)
    {
        double result = 0;

        for (int i = 0; i < n; i++)
        {
            double term = f[i].y;
            for (int j = 0; j < n; j++)
            {
                if (j != i)
                    term = term*(xi - f[j].x) / (f[i].x - f[j].x);
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args)
    {
        // creating an array of 4 known data points
        // x is day, y is number of cases

        Data f[] = {new Data(8, 38226), new Data(13, 61049),
                new Data(18, 82329), new Data(20, 90980)};

        // Using the interpolate function to obtain
        // a data point corresponding to x=3
        System.out.print("Value of f(15) is : " +
                (int)interpolate(f, 15, 4));
    }
}


