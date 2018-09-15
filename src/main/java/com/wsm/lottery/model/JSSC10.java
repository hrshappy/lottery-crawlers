package main.java.com.wsm.lottery.model;

import java.util.Date;
import java.util.List;

public class JSSC10 {
    private String period;
    private Date drawTime;
    private List<Integer> ballNames;

    @Override
    public String toString() {
        return "JSSC10{" +
                "period='" + period + '\'' +
                ", drawTime='" + drawTime + '\'' +
                ", ballNames=" + ballNames +
                '}';
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public List<Integer> getBallNames() {
        return ballNames;
    }

    public void setBallNames(List<Integer> ballNames) {
        this.ballNames = ballNames;
    }
}
