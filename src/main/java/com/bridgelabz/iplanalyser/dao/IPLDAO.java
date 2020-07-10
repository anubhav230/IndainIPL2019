package com.bridgelabz.iplanalyser.dao;

import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;

public class IPLDAO {


    public String player;
    public double strikeRate;
    public double battingAvg;

    public IPLDAO(IndianBattingIPLCSV indianBattingIPLCSV) {
        battingAvg = indianBattingIPLCSV.battingAvg;
        strikeRate = indianBattingIPLCSV.strikeRate;
        player = indianBattingIPLCSV.player;
    }
}
