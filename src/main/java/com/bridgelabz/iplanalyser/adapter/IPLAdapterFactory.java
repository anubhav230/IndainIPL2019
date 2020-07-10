package com.bridgelabz.iplanalyser.adapter;

import com.bridgelabz.iplanalyser.dao.IPLDAO;
import com.bridgelabz.iplanalyser.exception.IPLAnalyserException;

import com.bridgelabz.iplanalyser.services.IPLAnalyser;

import java.util.List;

public class IPLAdapterFactory {
    public List<IPLDAO> getCensusData(IPLAnalyser.Type type, String... csvFilePath) throws IPLAnalyserException {
        if (type.equals(IPLAnalyser.Type.BATTING))
            return new BattingAdapter().loadIPLCscData(csvFilePath);
        else
            throw new IPLAnalyserException("Invalid Country", IPLAnalyserException.ExceptionType.INVALID_COUNTRY);
    }
}
