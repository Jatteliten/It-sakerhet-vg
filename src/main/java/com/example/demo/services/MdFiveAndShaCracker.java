package com.example.demo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MdFiveAndShaCracker {

    public String crackPassword(String input){
        String findPassword = scanFileForMatchingPassword(input);
        if(findPassword == null){
            return "Password not found";
        }
        return "Password is: " + findPassword;
    }

    private String scanFileForMatchingPassword(String input){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/hashes.txt"));
            String line;

            while((line = bf.readLine()) != null){
                String[] hashes = line.split(": ");
                if(hashes[1].equals(input) || hashes[2].equals(input)){
                    bf.close();
                    return hashes[0];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
