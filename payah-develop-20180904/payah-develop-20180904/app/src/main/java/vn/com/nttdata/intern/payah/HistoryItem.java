package vn.com.nttdata.intern.payah;


public class HistoryItem {
    private String dateTra;
    private String timeTra;
    private String pirce;
    private String idTra;


    public String getPirce() {
        return pirce;
    }

    public void setPirce(String pirce) {
        this.pirce = pirce;
    }


    public String getDateTra() {
        return dateTra;
    }

    public void setDateTra(String dateTra) {
        this.dateTra = dateTra;
    }

    public String getTimeTra() {
        return timeTra;
    }

    public void setTimeTra(String timeTra) {
        this.timeTra = timeTra;
    }

    public String getIdTra() {
        return idTra;
    }

    public void setIdTra(String idTra) {
        this.idTra = idTra;
    }

    public HistoryItem(String dateTra, String timeTra, String idTra, String pirce) {
        this.dateTra = dateTra;
        this.timeTra = timeTra;
        this.pirce = pirce;
        this.idTra = idTra;
    }
}
