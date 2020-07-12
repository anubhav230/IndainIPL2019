package com.bridgelabz.iplanalyser.adapter;

import com.bridgelabz.iplanalyser.dao.IPLDAO;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IPLBowlingCSV;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;

import java.util.List;

public class BowlingAdapter extends IPLAdapter {

    @Override
    public List<IPLDAO> loadIPLCscData(String... csvFilePath) throws IPLAnalyserException {
        List<IPLDAO> indiaLeagueList = super.loadIPLCscData(IPLBowlingCSV.class, csvFilePath[0]);
        return indiaLeagueList;
    }
}
