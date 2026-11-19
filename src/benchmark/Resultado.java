package benchmark;

public class Resultado {

    private String functionName;
    private long duration;
    private int sample;

    public Resultado(String functionName, long duration, int sample) {
        this.functionName = functionName;
        this.duration = duration;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public long getDuration() {
        return duration;
    }

    public int getSample() {
        return sample;
    }

    public double getMillis() {
        return duration / 1000000.0;
    }

    @Override
    public String toString() {
        return "Método: " + functionName
                + " | sample: " + sample
                + " | tiempo: " + getMillis() + " ms";
    }
}
