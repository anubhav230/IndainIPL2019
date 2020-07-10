package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.bridgelabz.iplanalyser.services.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {


    String INDIA_IPL_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    //IPLAnalyser iplAnalyser = new IPLAnalyser();

    @Test
    public void givenIPLCensusCSVFile_ReturnsCorrectRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            List numOfRecords = iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCensusCSVFile_WhenSorted_Should_ReturnTopBattingAvgPlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH);
           String sortCensusData  = iplAnalyser.sortBattingAverage();
            IndianBattingIPLCSV[] indiaCensusCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals("MS Dhoni", indiaCensusCSV[indiaCensusCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIPLCensusCSVFile_WhenSorted_ShouldReturns_TopStrikeRatePlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH);
            String sortCensusData  = iplAnalyser.sortHighestStrikeRate();
            IndianBattingIPLCSV[] indiaCensusCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals("Ishant Sharma", indiaCensusCSV[indiaCensusCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
