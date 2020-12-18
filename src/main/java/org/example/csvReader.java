package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;

import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
public class csvReader<T> implements Reader<T> {

    public void read(String targetPath, BuilderFunc<T> builderFunc) {
        try(FileReader filereader = new FileReader(targetPath))
        {
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();

            String[] rowValues;
            while ((rowValues = csvReader.readNext()) != null) {
                builderFunc.build(rowValues);
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
    }
}