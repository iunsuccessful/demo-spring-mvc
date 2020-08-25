package iunsuccessful.demo.refactor.intellij;

/**
 * 依韵 2020/5/4
 */
public class ExtractSuperClassDemo2 {
    public static final int CONSTANT = 0;
    public int varInt;
    private double varDouble;

    public void setVarDouble(double var) {
        this.varDouble = var;
    }

    public double getVarDouble() {
        return varDouble;
    }
}
