package com.bridgelabz.iplanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class IndianBattingIPLCSV {




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










//    @CsvBindByName(column = "PLAYER", required = true)
//    public String player;
//
//    @CsvBindByName(column = "Avg", required = true)
//    public double battingAvg;

//    @CsvBindByName(column = "SR", required = true)
//    public int strikingRate;
//

//    public IndianBattingIPLCSV(IndianBattingIPLCSV next) {
//    }


//    @Override
//    public String toString() {
//        return "IndianBattingIPLCSV{" +
//                "player='" + player + '\'' +
//                ", battingAvg=" + battingAvg +
//                //", strikingRate=" + strikingRate +
//                '}';
//    }
}
