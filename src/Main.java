import java.util.*;

/*
Нам повторы не нужны "task0817"
Создать словарь (Маp<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод create Map() должен создавать и возвращать словарь Мар с типом элементов String, String состоящих из 10
записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeltemFromMapByValue().
*/

public class Main {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        /*map.put("Смирнов", "Иван");
        map.put("Сидоров", "Иван");
        map.put("Сухов", "Петр");
        map.put("Климов", "Кирилл");
        map.put("Фруктов", "Павел");
        map.put("Чемоданов", "Олег");
        map.put("Мамонтов", "Александр");
        map.put("Пушкин", "Иван");
        map.put("Молов", "Игорь");
        map.put("Роков", "Дмитрий");*/
        map.put("Смирнов", "Сильвестр");
        map.put("Иванов", "Дмитрий");
        map.put("Кузнецов", "Арнольд");
        map.put("Соколов", "Роман");
        map.put("Попов", "Максим");
        map.put("Лебедев", "Ярослав");
        map.put("Новиков", "Александр");
        map.put("Козлов", "Михаил");
        map.put("Морозов", "Илья");
        map.put("Петров", "Алексей");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> mapValues = new ArrayList<>(map.values());
        List<String> newList = new ArrayList<>();
        Set<String> setMapValue = new HashSet<>(mapValues);
        int count = 0;
        for (String e : setMapValue) {
            for (String m : mapValues) {
                if (e.contains(m)) {
                    count++;
                }
            }
            if (count > 1) {
                newList.add(e);
            }
            count = 0;
        }
        for (String c : newList) {
            removeItemFromMapByValue(map, c);
        }

        // Далее альтернативный вариант
        /*Map<String, String> copy = new HashMap<>(map);

        for (String name : copy.values()) {
            int count = 0;
            for (String nameTmp : map.values()) {
                if (nameTmp.equals(name)) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, name);
            }
        }*/

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        for(Map.Entry<String,String> m:map.entrySet()){
            System.out.print(m + "; ");
        }
        System.out.println();
        System.out.println();
        removeTheFirstNameDuplicates(map);
        for(Map.Entry<String,String> k:map.entrySet()){
            System.out.print(k + "; ");
        }

    }
}