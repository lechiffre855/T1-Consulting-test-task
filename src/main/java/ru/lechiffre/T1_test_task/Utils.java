package ru.lechiffre.T1_test_task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lechiffre
 * Вспомогательный класс для вычислений
 */

public class Utils {

    /**
     * Вычисляет количество символов в строке из параметров
     * @param symbolsString Строка с символами
     * @return В случае если строка в параметрах пустая или состоит только из пробелов, возвращает пустую строку.
     В случае если строка не пустая, возвращает LinkedMap, где ключ - символ из строки, а значение - кол-во повторений
     данного символа в строке.
     Результат отсортирован по убыванию количества вхождений символа в строку.
     Пробелы при подсчете не учитываются.
     */
    public static Object countSymbolsUtility(String symbolsString) {

        if(symbolsString!=null && !symbolsString.isBlank())
            return symbolsString
                    .chars()
                    .mapToObj(i -> (char) i)
                    .filter(i -> !i.equals(' '))
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            entry -> entry.getKey().toString(),
                            entry -> entry.getValue().intValue(),
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));
         else
            return "";

    }
}