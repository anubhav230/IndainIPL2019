package com.bridgelabz.iplanalyser.dao;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.bridgelabz.iplanalyser.services.IPLAnalyser;

public class IPLDAO {


    public String player;
    public double strikeRate;
    public double battingAvg;
    public int six;
    public int fours;

    public IPLDAO(IndianBattingIPLCSV indianBattingIPLCSV) {
        battingAvg = indianBattingIPLCSV.battingAvg;
        strikeRate = indianBattingIPLCSV.strikeRate;
        player = indianBattingIPLCSV.player;
        six = indianBattingIPLCSV.six;
        fours = indianBattingIPLCSV.fours;
    }

    public Object getIPLDTOS(IPLAnalyser.Type type) {
        if (type.equals(IPLAnalyser.Type.BATTING))
            return new IndianBattingIPLCSV(battingAvg, strikeRate, player, six, fours);
        else
            return null;
    }
}
