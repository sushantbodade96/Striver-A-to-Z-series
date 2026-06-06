
public class logisticRegression {

    public static double logisticLoss(int[] yTrue, double[] yPred) {
        double epsilon = 1e-15;
        double loss = 0.0;
        int n = yTrue.length;

        for (int i = 0; i < n; i++) {
            double p = Math.max(Math.min(yPred[i], 1 - epsilon), epsilon);
            loss += yTrue[i] * Math.log(p) + (1 - yTrue[i]) * Math.log(1 - p);
        }
        return -loss / n;
    }

    public static void main(String[] args) {
        int[] yTrue = {1, 0, 1, 1};
        double[] yPred = {0.9, 0.1, 0.8, 0.3};

        double result = logisticLoss(yTrue, yPred);
        System.out.println("Logistic Loss:" + result);
    }
}
