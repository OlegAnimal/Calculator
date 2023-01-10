import java.util.TreeMap;
import java.util.Map;


class Roman {
    private final static Map<String, Integer> numberMap = new TreeMap<>();

    static {
        numberMap.put("I", 1);
        numberMap.put("II", 2);
        numberMap.put("III", 3);
        numberMap.put("IV", 4);
        numberMap.put("V", 5);
        numberMap.put("VI", 6);
        numberMap.put("VII", 7);
        numberMap.put("VIII", 8);
        numberMap.put("IX", 9);
        numberMap.put("X", 10);
    }

    private final static TreeMap<Integer, String> initMap = new TreeMap<Integer, String>();

    static {
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");

    }


    public static String getRomanNum(int number) {    //перевод результата из арабских в римские
        int i = initMap.floorKey(number);
        if (i == number) {
            return initMap.get(number);
        } else return initMap.get(i) + getRomanNum(number - i);

    }

    public static boolean isItRoman(String number) {  //поиск римских цифр из введенных
        return numberMap.containsKey(number);
    }

    public static int getArabNum(String number) {
        return numberMap.get(number);                //перевод римского в арабское
    }
}
