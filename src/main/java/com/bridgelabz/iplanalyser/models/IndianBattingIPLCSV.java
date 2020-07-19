package com.bridgelabz.iplanalyser.models;

import com.opencsv.bean.CsvBindByName;


public class IndianBattingIPLCSV {

    public IndianBattingIPLCSV() {
    }

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Runs", required = true)
    public int run;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg")
    public double battingAvg;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int centuary;

    @CsvBindByName(column = "50", required = true)
    public int halfCentuary;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int six;

    public IndianBattingIPLCSV(double battingAvg, double strikeRate, String player, int six, int fours, int run) {
        this.battingAvg = battingAvg;
        this.strikeRate = strikeRate;
        this.player = player;
        this.six = six;
        this.fours = fours;
        this.run = run;
    }
}
