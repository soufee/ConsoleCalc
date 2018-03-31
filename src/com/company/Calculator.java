package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shoma on 31.03.2018.
 */
public class Calculator {

    private String string;
    private Operations operation;

    public Calculator(String s) {
        string = s;
        operation = readOperation(string);
    }

    public void calculate() throws Exception {
        float[] nums = getNums(string);
        if (nums != null) {
            switch (operation) {
                case PLUS:
                    System.out.println(nums[0] + nums[1]);
                    break;
                case MINUS:
                    System.out.println(nums[0] - nums[1]);
                    break;
                case DEVIDE:
                    System.out.println(nums[0] / nums[1]);
                    break;
                case MULTIPLY:
                    System.out.println(nums[0] * nums[1]);
                    break;
            }
        }
    }
    private float[] getNums(String s) {
        String[] strings = null;
        float[] result = new float[2];
        switch (operation) {
            case PLUS:
                strings = s.split("\\+");
                for (int i = 0; i < strings.length; i++) {
                    result[i] = Float.valueOf(strings[i].trim());
                }
                return result;

            case MINUS:
                strings = s.split("\\-");
                for (int i = 0; i < strings.length; i++) {
                    result[i] = Float.valueOf(strings[i].trim());
                }
                return result;

            case DEVIDE:
                strings = s.split("\\/");
                for (int i = 0; i < strings.length; i++) {
                    result[i] = Float.valueOf(strings[i].trim());
                }
                return result;


            case MULTIPLY:
                strings = s.split("\\*");
                for (int i = 0; i < strings.length; i++) {
                    result[i] = Float.valueOf(strings[i].trim());
                }
                return result;

            case UNKNOWN:
                System.out.println("Введена некорректная строка");
                break;
        }
        return null;
    }


    private static Operations readOperation(String s) {
        Pattern p = Pattern.compile("\\d+([-+*/])\\d+");
        Pattern p1 = Pattern.compile("\\d+\\s([-+*/])\\s\\d+");
        Pattern pPlus = Pattern.compile("\\+");
        Pattern pMinus = Pattern.compile("\\-");
        Pattern pMultiply = Pattern.compile("\\*");
        Pattern pDevide = Pattern.compile("\\/");
        Matcher m = p.matcher(s);
        Matcher m1 = p1.matcher(s);

        if ((m.matches()) || (m1.matches())) {

            if (pPlus.matcher(s).find()) {
                return Operations.PLUS;
            } else if (pMinus.matcher(s).find()) {
                return Operations.MINUS;
            } else if (pMultiply.matcher(s).find()) {
                return Operations.MULTIPLY;
            } else if (pDevide.matcher(s).find()) {
                return Operations.DEVIDE;
            } else return Operations.UNKNOWN;
        }
        return Operations.UNKNOWN;
    }

}
