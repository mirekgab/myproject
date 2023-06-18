package pl.mirekgab.myproject.category;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CategoryControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void getAllCategories() throws Exception {
        //given
        List<Category> categoryList = createCategories();

        //when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories"));
        //then
        perform
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(categoryList.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(categoryList.get(0).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(categoryList.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(categoryList.get(1).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value(categoryList.get(1).getName()));
    }

    private List<Category> createCategories() {
        List<Category> categoryList = Arrays.asList(
                new Category(1L, "category 1"),
                new Category(2L, "category 2")
        );
        categoryRepository.saveAllAndFlush(categoryList);
        return categoryList;
    }
}