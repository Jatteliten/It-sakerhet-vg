package com.example.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MdFiveAndShaConverterTest {

    MdFiveAndShaConverter converter = new MdFiveAndShaConverter();
    @Test
    void getMD5() {
        try {
            Assertions.assertEquals(converter.getMD5("hej").length(),32);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getSHA() {
        try {
            Assertions.assertEquals(converter.toHexString(converter.getSHA("hej")).length(), 64);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}