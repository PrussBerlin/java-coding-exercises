public class SimpleCalculator {

    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber() {
        return this.firstNumber;
    }

    public double getSecondNumber() {
        return this.secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult() {
        double sum = this.firstNumber + this.secondNumber;
        return sum;
    }

    public double getSubstractionResult() {
        double sum = this.firstNumber - this.secondNumber;
        return sum;
    }

    public double getMultiplicationResult() {
        double sum = this.firstNumber * this.secondNumber;
        return sum;
    }

    public double getDivisionResult() {
        if(this.secondNumber == 0) {
            return 0;
        } else {
            double sum = this.firstNumber / this.secondNumber;
            return sum;
        }

    }
}
