package org.example;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    static int id = 0;

    public static void main(String[] args) {

        FullTr.Main(1, 1, 200000);
        FullTr.Main(2, 200001, 400000);
        FullTr.Main(3, 400001, 600000);
        FullTr.Main(4, 600001, 800000);
        FullTr.Main(5, 800001, 1000000);
        FullTr.Main(6, 1000001, 1200000);
        FullTr.Main(7, 1200001, 1400000);
        FullTr.Main(8, 1400001, 1600000);

    }

}