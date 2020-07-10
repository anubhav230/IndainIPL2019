package com.bridgelabz.iplanalyser.adapter;

import com.bridgelabz.iplanalyser.dao.IPLDAO;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;

import java.util.List;

public class BattingAdapter extends IPLAdapter {

    @Override
    public List<IPLDAO> loadIPLCscData(String... csvFilePath) throws IPLAnalyserException {
        List<IPLDAO> indiaCensusList = super.loadIPLCscData(IndianBattingIPLCSV.class, csvFilePath[0]);
        return indiaCensusList;
    }
}
