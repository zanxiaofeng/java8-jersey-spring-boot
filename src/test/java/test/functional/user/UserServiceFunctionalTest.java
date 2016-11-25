package test.functional.user;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.user.dao.UserDao;
import com.thoughtworks.gaia.user.entity.User;
import com.thoughtworks.gaia.user.model.UserModel;
import com.thoughtworks.gaia.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class UserServiceFunctionalTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp(){
        UserModel userModel = new UserModel();
        userModel.setUserId("abc");
        userModel.setPassword("000000");
        userDao.save(userModel);
    }

    @Test
    public void should_create_a_new_user_given_an_user_id_and_password(){
        //given
        String userId = "test";
        String password = "123456";

        //when
        User user = userService.createUser(userId, password);

        //then
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getPassword()).isEqualTo(password);
        UserModel userModel = userDao.idEquals(user.getId()).querySingle();
        assertThat(userModel.getId()).isEqualTo(user.getId());
    }

    @Test
    public void should_throw_bad_request_exception_given_an_empty_user_id(){
        //given
        String userId = "";
        String password = "123456";

        //when, then
        assertThatThrownBy(() -> userService.createUser(userId, password)).isInstanceOf(BadRequestException.class);
    }

    @Test
    public void should_throw_bad_request_exception_given_an_existed_user_id(){
        //given
        String userId = "test";
        String password = "123456";

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setPassword("");
        userDao.save(userModel);

        //when, then
        assertThatThrownBy(() -> userService.createUser(userId, password)).isInstanceOf(BadRequestException.class);
    }

    @Test
    public void should_return_user_entity_given_valid_message() throws Exception{
        User user = new User();
        user.setId(1L);
        user.setAge(21);
        user.setRealname("Jack");
        user.setGrade("大三");
        user.setPhone("13000909900");
        user.setSchool("Harvard");
        user.setSex(1);

        User user1 = userService.updateUser(user);
        assertThat(user1.getAge()).isEqualTo(user.getAge());
        assertThat(user1.getPhone()).isEqualTo(user.getPhone());
    }

    @Test
    public void should_throw_bad_request_exception_given_invalid_phone_num() {
        User user = new User();
        user.setId(1L);
        user.setAge(21);
        user.setRealname("Jack");
        user.setGrade("大三");
        user.setPhone("12233222");
        user.setSchool("Harvard");
        user.setSex(1);


        assertThatThrownBy(() -> userService.updateUser(user)).isInstanceOf(BadRequestException.class);
    }

    @Test
    public void should_throw_bad_request_exception_given_invalid_id() {
        User user = new User();
        user.setId(-1L);
        user.setAge(21);
        user.setRealname("Jack");
        user.setGrade("大三");
        user.setPhone("13000909900");
        user.setSchool("Harvard");
        user.setSex(1);


        assertThatThrownBy(() -> userService.updateUser(user)).isInstanceOf(BadRequestException.class);
    }
}
