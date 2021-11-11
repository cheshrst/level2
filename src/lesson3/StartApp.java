package lesson3;
import java.util.*;


public class StartApp {
    public static void main(String[] args) {

        words();
        System.out.println("Телефонная книга");
        Phonebook phonebook = new Phonebook();


        phonebook.add(123123, "Игорь");
        phonebook.add(122222, "Игнат");
        phonebook.add(133333, "Артур");
        phonebook.get("Артур");

    }

    static void words() {
        List<String> strings = new ArrayList<>();
        Map<String, Integer> wordsCount = new HashMap<>();

        strings.add("Жульба");
        strings.add("Бульба");
        strings.add("Ба");
        strings.add("Игорь");
        strings.add("Жульба");
        strings.add("Ба");
        strings.add("Антон");
        strings.add("Жул");
        strings.add("Бульба");
        strings.add("Антон");
        strings.add("Игорь");

        Set<String> unique = new HashSet<>(strings);
        unique.forEach(System.out::println);
        System.out.println("\n В количестве \n");

        for (String s : strings) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        wordsCount.entrySet().forEach(System.out::println);
    }



}






//        System.out.println("\nБез повторов: ");
//        Set<String> unique = new HashSet<>(strings);
//        unique.forEach(System.out::println);




//            }System.out.println(s = " = " + numOfOccurence);



//        for(int i = 0; i< strings.size(); i++){
//            int count = 1;
//            stringsHash.add(strings.get(i));
//            for(int j = 0; j < strings.size(); j++){
//                if (strings.get(i).equals(strings.get(j)) && (i != j) ) count++;}
//            System.out.println(strings.get(i) + " встречается " + count + " раз.");
//        }
//        stringsHash.forEach(System.out::println);
//






//    int num = (int) strings.stream().distinct().count();

//        System.out.println(hashStrings);
//        Iterator<String> iterator = strings.iterator();
//        strings.forEach(System.out::println);
//        while(iterator.hasNext()){
//        }
//    }
//}