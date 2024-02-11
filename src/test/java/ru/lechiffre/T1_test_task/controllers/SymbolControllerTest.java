package ru.lechiffre.T1_test_task.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Класс служит для тестирования (REST API)-приложения с помощью имитации POST-запроса со строкой в теле
 */

@SpringBootTest
@AutoConfigureMockMvc
class SymbolControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * Пустая строка
     */
    final String NOTHING = "";

    /**
     * Тест на запрос с пустой строкой
     */
    @Test
    void getCountOfNothing() throws Exception {

        var requestBuilder = MockMvcRequestBuilders.post("/to_count_symbols")
                .content(NOTHING);

        this.mockMvc.perform(requestBuilder)
                .andExpect(content().string(NOTHING));
    }

    /**
     * Тест на запрос со строкой из пробелов
     */

    @Test
    void getCountOfSpacesOnly() throws Exception {

        final String SPACES = "     ";
        var requestBuilder = MockMvcRequestBuilders.post("/to_count_symbols")
                .content(SPACES);

        this.mockMvc.perform(requestBuilder)
                .andExpect(content().string(NOTHING));
    }

    /**
     * Тест на запрос со строкой из специальных символов, цифр, букв и пробелов в теле
     */
    @Test
    void getCountOfCharactersAndSpaces() throws Exception {

        final String CHARACTERSandSPACES = "ab  bc . /1DD ЭЭЭяяй ";
        var requestBuilder = MockMvcRequestBuilders.post("/to_count_symbols")
                .content(CHARACTERSandSPACES);

        this.mockMvc.perform(requestBuilder)
                .andExpect(content().json("""
                {
                    "Э": 3,
                    "b": 2,
                    "D": 2,
                    "я": 2,
                    "a": 1,
                    "c": 1,
                    ".": 1,
                    "/": 1,
                    "1": 1,
                    "й": 1
                }
                """
                ));
    }

}