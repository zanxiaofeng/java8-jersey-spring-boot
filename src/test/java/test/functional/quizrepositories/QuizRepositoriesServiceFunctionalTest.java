package test.functional.quizrepositories;

/**
 * Created by boliu on 24/11/2016.
 */

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.quizrepository.dao.QuizRepositoryDao;
import com.thoughtworks.gaia.quizrepository.entity.QuizRepository;
import com.thoughtworks.gaia.quizrepository.model.QuizRepositoryModel;
import com.thoughtworks.gaia.quizrepository.service.QuizRepositoryService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class QuizRepositoriesServiceFunctionalTest {
    @Autowired
    private QuizRepositoryService qrService;

    @Autowired
    private QuizRepositoryDao qrDao;

    @Test
    public void should_get_all_quiz_repositories() throws Exception {
        //given
        QuizRepositoryModel qrModel1 = dummyQuizRepositoryModel();
        qrDao.save(qrModel1);

        QuizRepositoryModel qrModel2 = dummyQuizRepositoryModel();
        qrDao.save(qrModel2);

        //when
        List<QuizRepository> qrs = qrService.getAllQuizRepositories();

        //then
        assertThat(qrs.size()).isEqualTo(2);

        assertThat(qrs.get(0).getName()).isEqualTo("name");
        assertThat(qrs.get(0).getDescription().equalsIgnoreCase("description"));
        assertThat(qrs.get(1).getName()).isEqualTo("name");
        assertThat(qrs.get(1).getDescription().equalsIgnoreCase("description"));

    }

    private QuizRepositoryModel dummyQuizRepositoryModel() {
        QuizRepositoryModel qrModel = new QuizRepositoryModel();
        qrModel.setName("name");
        qrModel.setDescription("description");
        qrModel.setModifiedTime(DateTime.now().toDate());
        return qrModel;
    }


//    @Test
//    public void should_get_quiz_list_by_id() throws Exception {
//        QuizRepositoryModel qrModel = dummyProductModel();
//        qrDao.save(qrModel);
//        Long qrId = qrModel.getId();
//
//        QuizRepository qr = qrService.getAllQuizRepositories();
//
//        assertThat(qr.getId()).isEqualTo(qrId);
//    }

//    private QuizRepositoryModel dummyProductModel() {
//        QuizRepositoryModel qrModel = new QuizRepositoryModel();
//        qrModel.setName("name");
//        qrModel.setDescription("description");
//        qrModel.setModifiedTime(DateTime.now().toDate());
//        return qrModel;
//    }

    /*
    @Test(expected = NotFoundException.class)
    public void should_throw_exception_when_not_found() {
        productService.getProduct(-1L);
    }*/

}
