package com.bridgelabz.iplanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class IndianBattingIPLCSV {

//    @CsvBindByName(column = "POS", required = true)
//    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

//    @CsvBindByName(column = "Mat", required = true)
//    public int mat;
//
//    @CsvBindByName(column = "Inns", required = true)
//    public int inns;
//
//    @CsvBindByName(column = "NO", required = true)
//    public int no;
//
//    @CsvBindByName(column = "Runs", required = true)
//    public int runs;
//
//    @CsvBindByName(column = "HS", required = true)
//    public int hs;
//
    @CsvBindByName(column = "Avg", required = true)
    public double battingAvg;

//    public IndianBattingIPLCSV(IndianBattingIPLCSV next) {
//    }


    @Override
    public String toString() {
        return "IndianBattingIPLCSV{" +
                //"player='" + player + '\'' +
                ", battingAvg='" + battingAvg + '\'' +
                '}';
    }
}
