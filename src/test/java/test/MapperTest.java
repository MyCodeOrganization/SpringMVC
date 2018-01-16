package test;

import com.alibaba.fastjson.JSON;
import com.wk.spring.JpaConfig;
import com.wk.spring.entity.ProvinceEntity;
import com.wk.spring.entity.UserEntity;
import com.wk.spring.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PackageName test
 * Created by wangkang on 2018/1/15.
 */
@EnableAutoConfiguration
@ComponentScan(value = {"com.wk.spring"})
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
@SpringBootTest
public class MapperTest {
//    @Autowired
//    private UserService userService;
    @Autowired
    private ProvinceService provinceService;
    @Test
    public void testInsert()throws Exception{
        UserEntity en = new UserEntity();
        en.setName("wk111");
        en.setAge(19);
        en.setSex(0);
//        userService.insert(en);
    }
    @Test
    public void testGet()throws Exception{
        ProvinceEntity entity = provinceService.getEntityById(1l);
        if (entity != null){
            String json = JSON.toJSONString(entity);
            System.out.println("json: " + json);
        }else {
            System.out.println("empty string!");
        }
    }
}
