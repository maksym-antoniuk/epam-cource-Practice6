package ua.nure.antoniuk.Practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by Max on 05.12.2017.
 */
public class Part1 {
    public static final InputStream STD = System.in;
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("asd asdf asd asdf asdf 43 asdsf 43 43 434".getBytes(ENCODING)));
        WordContainer.main(args);
        System.setIn(STD);
    }
}
