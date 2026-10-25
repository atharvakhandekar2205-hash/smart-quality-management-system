public class ReportManager {

    int totalTokens = 0;
    int servedTokens = 0;

    public void tokenGenerated() {
        totalTokens++;
    }

    public void tokenServed() {
        servedTokens++;
    }

    public String getReport() {
        return "Total: " + totalTokens + " | Served: " + servedTokens;
    }
}