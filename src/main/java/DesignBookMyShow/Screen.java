package DesignBookMyShow;

import java.util.List;

public class Screen {
    private int screenId;
    private List<Seat> seatList;

    public Screen() {
    }

    public Screen(int screenId, List<Seat> seatList) {
        this.screenId = screenId;
        this.seatList = seatList;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
