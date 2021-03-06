package com.bridgelabz.iplanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlingCSV {

    public IPLBowlingCSV() {
    }

    @CsvBindByName(column = "PLAYER", required = true)
    public String bPlayer;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double over;

    @CsvBindByName(column = "Runs", required = true)
    public int bowlerRuns;

    @CsvBindByName(column = "Wkts", required = true)
    public int wkts;

    @CsvBindByName(column = "Avg", required = true)
    public double bowlingAverage;

    @CsvBindByName(column = "SR", required = true)
    public double bStrikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWkts;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWkts;

    @CsvBindByName(column = "Econ", required = true)
    public double economy;


    public IPLBowlingCSV( double bowlingAverage ,String bPlayer, double bStrikeRate, int wkts, int fourWkts, int fiveWkts, double over) {
        this.bowlingAverage = bowlingAverage;
        this.bPlayer = bPlayer;
        this.bStrikeRate = bStrikeRate;
        this.wkts = wkts;
        this.fourWkts = fourWkts;
        this.fiveWkts = fiveWkts;
        this.over = over;
    }
}
