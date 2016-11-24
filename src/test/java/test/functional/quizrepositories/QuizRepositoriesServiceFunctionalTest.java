package test.functional.quizrepositories;

/**
 * Created by boliu on 24/11/2016.
 */

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.product.dao.ProductDao;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.model.ProductModel;
import com.thoughtworks.gaia.product.service.ProductService;
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


public class QuizRepositoriesServiceFunctionalTest {
}
