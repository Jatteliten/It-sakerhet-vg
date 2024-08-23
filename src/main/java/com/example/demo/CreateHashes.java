package com.example.demo;

import com.example.demo.services.MdFiveAndShaConverter;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class CreateHashes implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        MdFiveAndShaConverter converter = new MdFiveAndShaConverter();
        try {
            List<String> pws = Files.readAllLines(Paths.get("src/main/resources/pws.dict"));

            List<String> hashedLines = pws.stream()
                    .map(line -> {
                        try {
                            return line + ": " + converter.getMD5(line) + ": "
                                    + converter.toHexString(converter.getSHA(line));
                        } catch (NoSuchAlgorithmException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());

            String hashes = String.join("\n", hashedLines);

            Path outputPath = Paths.get("src/main/resources/hashes.txt");
            Files.write(outputPath, hashes.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch(IOException e){
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}
