@Cache(value = {"data", "results"})
public class CashUtlity {
    private String data;

    public CashUtlity(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
