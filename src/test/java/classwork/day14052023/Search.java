package classwork.day14052023;

public class Search {
    public String user;
    public boolean strict;

    public Search(String user, boolean strict){
        this.user = user;
        this.strict = true;
    }

    public String getAlbert() {
        return user;
    }

    public void setAlbert(String albert) {
        this.user = albert;
    }

    @Override
    public String toString() {
        return "Search{" +
                "albert='" + user + '\'' +
                ", truefalse=" + strict +
                '}';
    }
}

