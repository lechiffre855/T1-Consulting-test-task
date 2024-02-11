package ru.lechiffre.T1_test_task.controllers;

import org.springframework.web.bind.annotation.*;
import ru.lechiffre.T1_test_task.Utils;

/**
 * Класс-контроллер для работы с REST API
 * Принимает запросы по нижеуказанному единственному URL
 */

@RestController
@RequestMapping("/to_count_symbols")
public class SymbolController {

    /**
     * @param symbolsString Строка может быть из символов или пустая
     * @return Метод вычисления количества символов из строки в данных парметрах
     */
    @PostMapping
    public Object toCountSymbols(@RequestBody(required = false) String symbolsString) {
        return Utils.countSymbolsUtility(symbolsString);
    }
}