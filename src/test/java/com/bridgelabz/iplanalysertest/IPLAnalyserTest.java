package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.models.IPLBowlingCSV;
import com.bridgelabz.iplanalyser.models.IndianBattingIPLCSV;
import com.bridgelabz.iplanalyser.services.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLAnalyserTest {

    String INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    String INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BOWLING = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLCSVFile_ReturnsCorrectRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            List numOfRecords = iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            Assert.assertEquals(100, numOfRecords.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_Should_ReturnTopBattingAvgPlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
           String sortCensusData  = iplAnalyser.sortBattingAverage();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals(83.2, iPLCSV[iPLCSV.length-1].battingAvg,0.0);
            Assert.assertEquals("MS Dhoni", iPLCSV[iPLCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIPLCSVFile_WhenSorted_ShouldReturns_TopStrikeRatePlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestStrikeRate();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals(333.33, iPLCSV[iPLCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Ishant Sharma", iPLCSV[iPLCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_ShouldReturns_TopSixHittingPlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestSixesHittingPlayer();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals("Andre Russell", iPLCSV[iPLCSV.length-1].player);
            Assert.assertEquals(52, iPLCSV[iPLCSV.length-1].six);

        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_ShouldReturns_TopFourHittingPlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestFourHittingPlayer();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals("Shikhar Dhawan", iPLCSV[iPLCSV.length-1].player);
            Assert.assertEquals(64, iPLCSV[iPLCSV.length-1].fours);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_ShouldReturns_TopStrikeRatePlayerNameAndSixesAndFours() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestStrikeRate();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals(333.33, iPLCSV[iPLCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Ishant Sharma", iPLCSV[iPLCSV.length-1].player);
            Assert.assertEquals(1, iPLCSV[iPLCSV.length-1].six);
            Assert.assertEquals(1, iPLCSV[iPLCSV.length-1].fours);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_Should_ReturnTopBattingAvgPlayerStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestRunsPlayer();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                            .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals(69.2, iPLCSV[iPLCSV.length-1].battingAvg,0.0);
            Assert.assertEquals("David Warner", iPLCSV[iPLCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_Should_ReturnTopRunsPlayerStrikeRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BATTING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BATTING);
            String sortCensusData  = iplAnalyser.sortHighestRunsPlayer();
            IndianBattingIPLCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IndianBattingIPLCSV[].class);
            Assert.assertEquals(143.86, iPLCSV[iPLCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("David Warner", iPLCSV[iPLCSV.length-1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBowlingIPLCSVFile_ReturnsCorrectRecords() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BOWLING);
            List numOfRecords = iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BOWLING);
            Assert.assertEquals(99, numOfRecords.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_Should_ReturnTopBowlingAvgPlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BOWLING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BOWLING);
            String sortCensusData  = iplAnalyser.sortTopBowlingAveragePlayer();
            IPLBowlingCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IPLBowlingCSV[].class);
            Assert.assertEquals(166.0, iPLCSV[iPLCSV.length-1].bowlingAverage,0.0);
            Assert.assertEquals("Krishnappa Gowtham", iPLCSV[iPLCSV.length-1].bPlayer);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSVFile_WhenSorted_Should_ReturnTopBowlingStrikeRatePlayer() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Type.BOWLING);
            iplAnalyser.loadIPLCscData(INDIA_IPL_CENSUS_CSV_FILE_PATH_FOR_BOWLING);
            String sortCensusData  = iplAnalyser.sortTopBowlingStrikeRatePlayer();
            IPLBowlingCSV[] iPLCSV = new Gson()
                    .fromJson(sortCensusData, IPLBowlingCSV[].class);
            Assert.assertEquals(120.0, iPLCSV[iPLCSV.length-1].bStrikeRate,0.0);
            Assert.assertEquals("Krishnappa Gowtham", iPLCSV[iPLCSV.length-1].bPlayer);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
