package com.bridgelabz.iplanalyser.adapter;

import com.bridgelabz.iplanalyser.dao.IPLDAO;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IPLBowlingCSV;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.csvbuilder.CSVBuilderException;
import com.csvbuilder.CSVBuilderFactory;
import com.csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class IPLAdapter {

    public abstract List<IPLDAO> loadIPLCscData(String... csvFilePath) throws IPLAnalyserException;

    public <E> List<IPLDAO> loadIPLCscData(Class<E> classType, String csvFilePath) throws IPLAnalyserException {
        List<IPLDAO> iPLCscDAOList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, classType);
            switch (classType.getSimpleName()) {
                case"IndianBattingIPLCSV":
                while (csvFileIterator.hasNext())
                    iPLCscDAOList.add(new IPLDAO((IndianBattingIPLCSV) csvFileIterator.next()));
                break;
                case"IPLBowlingCSV":
                    while (csvFileIterator.hasNext())
                        iPLCscDAOList.add(new IPLDAO((IPLBowlingCSV) csvFileIterator.next()));
                    break;
            }
            return iPLCscDAOList;
        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                      IPLAnalyserException.ExceptionType.NO_DATA);
        }
    }
}
