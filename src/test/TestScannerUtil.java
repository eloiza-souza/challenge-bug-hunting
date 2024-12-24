package test;

import util.DateUtil;
import util.ScannerUtil;

import java.util.Date;
import java.util.Scanner;

public class TestScannerUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = ScannerUtil.readString(scanner, "digite uma String: ");
        System.out.println("String digitada " + inputString);

        int inputInt = ScannerUtil.readInt(scanner,"Digite um inteiro: ");
        System.out.println("Int digitado " + inputInt);

        Date date = ScannerUtil.readDateFromScanner(scanner, "Digite uma data no formato " + DateUtil.DATE_FORMAT + ": ");
        System.out.println("Data digitada: " + DateUtil.toString(date));

        scanner.close();
    }
}
