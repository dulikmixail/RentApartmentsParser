package by.dulik.RentApartmentsParser.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
class ResponseStringBuilder {
    StringBuilder getStringBuilderHttps(InputStream inputStream) {
        StringBuilder content = null;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream))) {

            String line;
            content = new StringBuilder();

            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}

