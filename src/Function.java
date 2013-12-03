public class Function {
    private static final double step = 0.0001;
    public double getVal(double arg){
        return Math.abs(2*arg*arg*arg - arg * arg + arg + 1);
    }

    public double max(double leftLimit, double rightLimit){
        double max = getVal(leftLimit);
        for (double x = leftLimit; x < rightLimit; x += step){
            double temp = getVal(x);
            if (temp > max) max = temp;
        }
        return max;
    }
}
