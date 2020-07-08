package com.bridgelabz.iplanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class IndianBattingIPLCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

}
