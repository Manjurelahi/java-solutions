import java.util.*;

public class MapSortedByValue {
    public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> targetHashMap = new LinkedHashMap<>();
        hashMap.put(22,"A");
        hashMap.put(55,"B");
        hashMap.put(33,"Z");
        hashMap.put(44,"M");
        hashMap.put(99,"I");
        hashMap.put(88,"X");

        hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(s -> hashMap.forEach((key, value) -> {
            if (value.equals(s.getValue())) {
                targetHashMap.put(key, s.getValue());
            }
        }));
        targetHashMap.forEach((integer, s) -> System.out.println("Key: "+integer + " Value: "+s));
	}
}
/*
Output:
Key: 22 Value: A
Key: 55 Value: B
Key: 99 Value: I
Key: 44 Value: M
Key: 88 Value: X
Key: 33 Value: Z
*/