package com.bridgelabz.iplanalyser.services;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.csvbuilder.CSVBuilderException;
import com.csvbuilder.CSVBuilderFactory;
import com.csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLAnalyser {

    public int loadIPLCscData(String csvFilePath ) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IndianBattingIPLCSV> censusCSVList = csvBuilder.getCSVFileList(reader, IndianBattingIPLCSV.class);
            return censusCSVList.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.NO_DATA);
        }
    }
}
