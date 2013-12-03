public class Main {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int Iterations = 10000;
        int thrCount = Integer.parseInt(args[0]);
        double leftLim = Double.parseDouble(args[1]);
        double rightLim = Double.parseDouble(args[2]);

        Thread[] threads = new Thread[thrCount];
        MonteCarlo[] integrations = new MonteCarlo[thrCount];
        Function func = new Function();
        double intervalSize = (rightLim - leftLim)/thrCount;

        for (int i = 0; i < thrCount; i++){
            integrations[i] = new MonteCarlo(leftLim + intervalSize * i, leftLim + intervalSize * (i + 1), func, Iterations / thrCount);
            threads[i] = new Thread(integrations[i]);
            threads[i].start();
        }
        try {
            for(Thread thread : threads){
                thread.join();
            }
        }
        catch (Exception ex){
            return;
        }
        double result = 0;
        for(MonteCarlo integration : integrations){
            result += integration.getRes();
        }
        System.out.println("Res: " + result);
        System.out.println("Time: " +
                (double)(System.currentTimeMillis() - time) / 1000);
    }
}
