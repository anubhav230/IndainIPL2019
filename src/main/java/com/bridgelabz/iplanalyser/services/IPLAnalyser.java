package com.bridgelabz.iplanalyser.services;

import com.bridgelabz.iplanalyser.adapter.IPLAdapterFactory;
import com.bridgelabz.iplanalyser.dao.IPLDAO;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {
    List<IPLDAO> iPLCSVList;
    private Type type;

    public enum Type {
        BATTING, BOWLING
    }

    public IPLAnalyser(Type type) {
        this.type = type;
    }

    public List<IPLDAO> loadIPLCscData(String... csvFilePath) throws IPLAnalyserException {
        this.iPLCSVList = new IPLAdapterFactory().getCensusData(type, csvFilePath);
        return iPLCSVList;
    }

    public String sortBattingAverage() throws IPLAnalyserException {
        if (iPLCSVList == null || iPLCSVList.size() == 0)
            throw new IPLAnalyserException("No data", IPLAnalyserException.ExceptionType.NO_DATA);
        Comparator<IPLDAO> IPLComparator = Comparator.comparing(census -> census.battingAvg);
        iPLCSVList.sort(IPLComparator);
        String sortedStateCensusJson = new Gson().toJson(iPLCSVList);
        return sortedStateCensusJson;
    }

    public String sortHighestStrikeRate() throws IPLAnalyserException {
        if (iPLCSVList == null || iPLCSVList.size() == 0)
            throw new IPLAnalyserException("No data", IPLAnalyserException.ExceptionType.NO_DATA);
        Comparator<IPLDAO> IPLComparator = Comparator.comparing(census -> census.strikeRate);
        ArrayList leagueDTO = iPLCSVList.stream()
                .sorted(IPLComparator)
                .map(censusDAO -> censusDAO.getIPLDTOS(type))
                .collect(Collectors.toCollection(ArrayList::new));
        //iPLCSVList.sort(IPLComparator);
        String sortedStateCensusJson = new Gson().toJson(leagueDTO);
        return sortedStateCensusJson;
    }

    public String sortHighestSixes() throws IPLAnalyserException {
        if (iPLCSVList == null || iPLCSVList.size() == 0)
            throw new IPLAnalyserException("No data", IPLAnalyserException.ExceptionType.NO_DATA);
        Comparator<IPLDAO> IPLComparator = Comparator.comparing(census -> census.six);
        ArrayList leagueDTO = iPLCSVList.stream()
                .sorted(IPLComparator)
                .map(censusDAO -> censusDAO.getIPLDTOS(type))
                .collect(Collectors.toCollection(ArrayList::new));
        //iPLCSVList.sort(IPLComparator);
        String sortedStateCensusJson = new Gson().toJson(leagueDTO);
        return sortedStateCensusJson;
    }
}
