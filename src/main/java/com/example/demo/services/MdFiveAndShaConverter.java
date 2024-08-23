package com.example.demo.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MdFiveAndShaConverter {

    public String getMD5(String inputText) throws NoSuchAlgorithmException {
        StringBuilder hashText;
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(inputText.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }

        return String.valueOf(hashText);
    }

    public byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
