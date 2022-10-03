package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.List;

public class FullTr {

    public static void   Main(int bd, int on, int to){


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Main.id++;
                String outputFileName = "new" + bd + ".csv";
                String[] headers = new String[] {"id","name","salePriceU","subjectId","feedbacks","rating"};
                try (Writer writer = new FileWriter(outputFileName);
                     CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.POSTGRESQL_CSV.withHeader(headers))
                ) {
                    Http http = new Http();
                    int i = 1;
                    for (int j = on; j < to; j++) {
                        System.out.println(Main.id + " " + j);


                        while (true) {
                            try {

                                List<listJsion> prod = http.getProd(j, i);
                                if (prod.size() == 0 | prod==null) {
                                    break;
                                }
                                for (listJsion listJsion : prod) {
                                    if (Integer.valueOf(listJsion.getSalePriceU()) < 100000) {
                                        Main.id++;
                                        csvPrinter.printRecord(
                                                listJsion.getId(),
                                                listJsion.getName(),
                                                listJsion.getSalePriceU(),
                                                listJsion.getSubjectId(),
                                                listJsion.getFeedbacks(),
                                                listJsion.getRating()
                                        );
                                    }
                                }

                                i++;
                            } catch (Exception e){
                                break;
                            }
                        }
                        i=1;
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}
