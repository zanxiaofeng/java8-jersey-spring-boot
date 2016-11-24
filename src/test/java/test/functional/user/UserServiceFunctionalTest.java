package test.functional.user;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.user.entity.User;
import com.thoughtworks.gaia.user.dao.UserDao;
import com.thoughtworks.gaia.user.model.UserModel;
import com.thoughtworks.gaia.user.service.UserService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

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

//    @Test
//    public void should_get_product_with_id() throws Exception {
//        UserModel userModel = new UserModel();
//
//        userModel.setuserId("test");
//        userModel.setPasswor
//        productDao.save(productModel);
//        Long productId = productModel.getId();
//
//        User product = productService.getProduct(productId);
//
//        assertThat(product.getId()).isEqualTo(productId);
//    }
}
