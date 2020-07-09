package com.bridgelabz.iplanalyser.services;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.csvbuilder.CSVBuilderException;
import com.csvbuilder.CSVBuilderFactory;
import com.csvbuilder.ICSVBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class IPLAnalyser {
    List<IndianBattingIPLCSV> iPLCSVList;

    public List<IndianBattingIPLCSV> loadIPLCscData(String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iPLCSVList =csvBuilder.getCSVFileList(reader, IndianBattingIPLCSV.class);
            return iPLCSVList;
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.NO_DATA);
        }
    }

    public String sortBattingAverage() throws IPLAnalyserException {
        if (iPLCSVList == null || iPLCSVList.size() == 0)
            throw new IPLAnalyserException("No data", IPLAnalyserException .ExceptionType.NO_DATA);
        Comparator<IndianBattingIPLCSV> IPLComparator = Comparator.comparing(census -> census.battingAvg);
        iPLCSVList.sort(IPLComparator);
        System.out.println(iPLCSVList);
        String sortedStateCensusJson = new Gson().toJson(iPLCSVList);
        System.out.println(sortedStateCensusJson);
        return sortedStateCensusJson;
    }

    public String sortHighestStrikeRate() throws IPLAnalyserException {
        if (iPLCSVList == null || iPLCSVList.size() == 0)
            throw new IPLAnalyserException("No data", IPLAnalyserException .ExceptionType.NO_DATA);
        Comparator<IndianBattingIPLCSV> IPLComparator = Comparator.comparing(census -> census.strikeRate);
        iPLCSVList.sort(IPLComparator);
        System.out.println(iPLCSVList);
        String sortedStateCensusJson = new Gson().toJson(iPLCSVList);
        System.out.println(sortedStateCensusJson);
        return sortedStateCensusJson;
    }
}
