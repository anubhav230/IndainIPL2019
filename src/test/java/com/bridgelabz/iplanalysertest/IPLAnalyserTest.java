package com.bridgelabz.iplanalysertest;

import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;
import com.bridgelabz.iplanalyser.services.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {

    @Test
    public void givenIPLCensusCSVFile_ReturnsCorrectRecords() {
        String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            int numOfRecords = iplAnalyser.loadIPLCscData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
