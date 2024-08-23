package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MdFiveAndShaCracker {

    public String crackPassword(String input){
        List<String> pws = createLibraryList();
        return scanFileForMatchingPassword(pws, input);
    }

    private List<String> createLibraryList(){
        try {
            return Files.readAllLines(Paths.get("src/main/resources/hashes.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String scanFileForMatchingPassword(List<String> pws, String input){
        for(String line: pws){
            String[] parts = line.split(": ");
            if(input.equals(parts[1]) || input.equals(parts[2])){
                return parts[0];
            }
        }
        return "No password found";
    }

}
