package servlets;

public class MotATrouver {
    private String motATrouver;
    private StringBuilder motDevine;

    public MotATrouver(String motATrouver) {
        this.motATrouver = motATrouver;
        this.motDevine = new StringBuilder("_".repeat(motATrouver.length()));
    }

    public boolean test(char carac) {
        boolean res = false;
        for (int last = motATrouver.indexOf(carac); last != -1; last = motATrouver.indexOf(carac, last + 1)) {
            res = true;
            motDevine.setCharAt(last, carac);
        }
        return res;
    }

    public String getMotATrouver() {
        return motATrouver;
    }

    public String getMotDevine() {
        return motDevine.toString();
    }
}
