public class Results {
    private String functionName;
    private long duration;
    private String sample;

    public Results(String functionName, long duration, String sample) {
        this.functionName = functionName;
        this.duration = duration;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {

        double segundos = duration / 1000000000;
        return "Results [functionName=" + functionName + ", duration=" + segundos + ", ns=" + duration + "s" + ", sample=" + sample + "]";
    }

    
}
