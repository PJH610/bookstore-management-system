

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class TestControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    // 这个方法在每个方法执行之前都会执行一遍
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 初始化MockMvc对象
    }

    @Test
    public void testString()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/activity/list")
post("/api/user/alterPw") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("id","2") // 添加参数（可以添加多个）
//        .param("username", "测试用户1")
        .param("password", "1234561")
//        .param("phone", "123456")
//        .param("realname", "12")
//        .param("sex", "MAN")
//        .param("address", "123456")
//        .param("email", "123456")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString1()throws Exception {
        String responseString = mockMvc.perform(
                post("/api/product/add") // 请求的url，请求的方法是post
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("book_name","1")
                        .param("author","1")
                        .param("press","1")
                        .param("price","3")
                        .param("image","1")
                        .param("description","4")
                        .param("stock","1")
                        .param("status","1")
                        .param("create_time","2018-12-4")
                        .param("category_id","1")

        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }
}
