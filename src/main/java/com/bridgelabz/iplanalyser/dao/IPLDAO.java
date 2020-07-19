package com.bridgelabz.iplanalyser.dao;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IPLBowlingCSV;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.bridgelabz.iplanalyser.services.IPLAnalyser;

public class IPLDAO {


    public double over;
    public int match;
    public double economy;
    public int fiveWkts;
    public int fourWkts;
    public int wkts;
    public double bStrikeRate;
    public int bowlerRuns;
    public String bPlayer;
    public double bowlingAverage;
    
    
    public int run;
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
         run = indianBattingIPLCSV.run;
    }


    public IPLDAO(IPLBowlingCSV iplBowlingCSV) {
        bPlayer = iplBowlingCSV.bPlayer;
        bowlerRuns = iplBowlingCSV.bowlerRuns;
        bStrikeRate = iplBowlingCSV.bStrikeRate;
        bowlingAverage = iplBowlingCSV.bowlingAverage;
        wkts = iplBowlingCSV.wkts;
        fourWkts = iplBowlingCSV.fourWkts;
        fiveWkts = iplBowlingCSV.fiveWkts;
        economy = iplBowlingCSV.economy;
        match = iplBowlingCSV.match;
        over = iplBowlingCSV.over;
    }

    public Object getIPLDTOS(IPLAnalyser.Type type) {
        if (type.equals(IPLAnalyser.Type.BATTING))
            return new IndianBattingIPLCSV(battingAvg, strikeRate, player, six, fours, run);
        if (type.equals(IPLAnalyser.Type.BOWLING))
            return new IPLBowlingCSV(bowlingAverage, bPlayer, bStrikeRate, wkts, fourWkts, fiveWkts, over);
        else
            return null;
    }
}
