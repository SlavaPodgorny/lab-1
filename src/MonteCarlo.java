import java.util.Random;

public class MonteCarlo implements Runnable {
    private double left;
    private double right;
    private Function func;
    private double res;
    private int i;

    public MonteCarlo(double left, double right, Function func, int it){
        this.left = left;
        this.right = right;
        this.func = func;
        this.i = it;
    }
    @Override
    public void run() {
        double min = 0;
        double max = Math.abs(func.max(left, right));
        Random rand = new Random();

        int k = 0;
        for (int i = 0; i < this.i; i++)
        {
            double randX = left + rand.nextDouble() * (right - left);
            double randY = min + rand.nextDouble() * (max - min);
            if (randY < func.getVal(randX)){
                k++;
            }
        }
        res = (right - left) * (max - min) * ((double)k / (double) i);
    }

    public double getRes(){
        return res;
    }
}
