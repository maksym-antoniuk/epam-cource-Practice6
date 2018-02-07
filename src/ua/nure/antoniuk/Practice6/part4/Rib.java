package ua.nure.antoniuk.Practice6.part4;

public class Rib {
    private int from;
    private int to;

    public Rib(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rib)) {
            return false;
        }

        if ((from == ((Rib) o).from && to == ((Rib) o).to) || (to == ((Rib) o).from && from == ((Rib) o).to)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = from + to;
        result = 31 * result + result;
        return result;

    }
}
