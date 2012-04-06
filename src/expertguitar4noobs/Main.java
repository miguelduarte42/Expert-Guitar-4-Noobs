package expertguitar4noobs;

public class Main {

    static Tab AM = new Tab(-1, 0, 2, 2, 2, 0, true);
    static Tab BM = new Tab(-1, 2, 4, 4, 4, 2, true);
    static Tab CM = new Tab(3, 3, 0, 2, 1, 0, true);
    static Tab DM = new Tab(-1, -1, 0, 2, 3, 2, true);
    static Tab EM = new Tab(0, 2, 2, 1, 0, 0, true);
    static Tab FM = new Tab(1, 3, 3, 2, 1, 1, true);
    static Tab GM = new Tab(3, 2, 0, 0, 3, 3, true);

    static Tab Am = new Tab(-1, -1, 2, 2, 1, 0, true);
    static Tab Bm = new Tab(-1, 2, 4, 4, 3, 2, true);
    //static Tab Cm_chord = new Tab(3, 3, 0, 2, 1, 0, true);
    static Tab Dm = new Tab(-1, -1, 0, 2, 3, 1, true);
    static Tab Em = new Tab(0, 2, 2, 0, 0, 0, true);
    static Tab Fm = new Tab(1, 3, 3, 1, 1, 1, true);
    static Tab Gm = new Tab(3, 5, 5, 3, 3, 3, true);

    // Smoke on the water
    /*static Tab Power1 = new Tab(3, 5, -1, -1, -1, -1, true);
    static Tab Power2 = new Tab(6, 8, -1, -1, -1, -1, true);
    static Tab Power3 = new Tab(8, 10, -1, -1, -1, -1, true);
    static Tab Power4 = new Tab(9, 11, -1, -1, -1, -1, true);
    static Tab Power5 = new Tab(-1, -1, -1, -1, -1, -1, true);*/

    // Run to the hills
    /*
    static Tab Power1 = new Tab(-1, 7, 9, -1, -1, -1, true);
    static Tab Power2 = new Tab(-1, 5, 7, -1, -1, -1, true);
    static Tab Power3 = new Tab(-1, 3, 5, -1, -1, -1, true);
    static Tab Power4 = new Tab(3, 5, -1, -1, -1, -1, true);
    static Tab Power5 = new Tab(5, 7, -1, -1, -1, -1, true);
    static Tab Power6 = new Tab(-1, -1, -1, -1, -1, -1, true);
    static Tab Power7 = new Tab(-1, -1, -1, -1, -1, -1, true);
    static Tab Power8 = new Tab(-1, -1, -1, -1, -1, -1, true);
    static Tab Power9 = new Tab(-1, -1, -1, -1, -1, -1, true);*/

    // Seven nation army
    static Tab Power1 = new Tab(7, 9, -1, -1, -1, -1, true);
    static Tab Power2 = new Tab(10, 12, -1, -1, -1, -1, true);
    static Tab Power3 = new Tab(5, 7, -1, -1, -1, -1, true);
    static Tab Power4 = new Tab(3, 5, -1, -1, -1, -1, true);
    static Tab Power5 = new Tab(2, 4, -1, -1, -1, -1, true);


    static Tab N1 = new Tab(2, 2, 2, -1, -1, -1, true);
    static Tab N2 = new Tab(5, 5, 5, -1, -1, -1, true);
    static Tab N3 = new Tab(6, 6, 6, -1, -1, -1, true);
    static Tab N4 = new Tab(7, 7, 7, -1, -1, -1, true);
    static Tab N5 = new Tab(10, 10, 10, -1, -1, -1, true);
    static Tab N6 = new Tab(11, 11, 11, -1, -1, -1, true);
    static Tab N7 = new Tab(12, 12, 12, -1, -1, -1, true);
    static Tab N8 = new Tab(0, 0, 0, -1, -1, -1, true);
    static Tab N9 = new Tab(3, 3, 3, -1, -1, -1, true);
    static Tab N10 = new Tab(5, 5, 5, -1, -1, -1, true);
    static Tab N11 = new Tab(-1, 2, 4, 4, -1, -1, true);
    static Tab N12 = new Tab(-1, 3, 5, 5, -1, -1, true);
    static Tab N13 = new Tab(-1, 1, 2, 3, -1, -1, true);
    static Tab N14 = new Tab(-1, 2, 4, 4, 0, 0, true);
    static Tab N15 = new Tab(-1, 2, 4, 4, 4, -1, true);


    public static void main(String[] args) throws InterruptedException, Exception {
       
        Guitar guitar = new Guitar();
        guitar.loadPreset("nation.egn");
        //guitar.loadPreset("smoke.egn");
        
        Thread.sleep(100000000);
    }
}
