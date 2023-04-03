package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element " + key + " not found!");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        /* if contains throw ElementAbuseException */
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] value = new String[]{"one", "two", "three", "four", "five"};
        String key = "six";
        try {
            int rsl = indexOf(value, key);
            System.out.println(rsl);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}