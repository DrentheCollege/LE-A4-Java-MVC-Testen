package h4.oefening5;

public class Btw {
    
    private int btw = 21;
    private double prijs;

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getBtw() {
        return btw;
    }

    public void setBtw(int btw) {
        this.btw = btw;
    }
    
    public double getPrijsInclusiefBtw(){
        return prijs*(btw/100);
    }
    
}
