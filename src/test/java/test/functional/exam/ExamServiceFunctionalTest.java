package test.functional.exam;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.exam.dao.ExamDao;
import com.thoughtworks.gaia.exam.entity.Exam;
import com.thoughtworks.gaia.exam.model.ExamModel;
import com.thoughtworks.gaia.exam.service.ExamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyli on 16/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class ExamServiceFunctionalTest {
    @Autowired
    private ExamService examService;

    @Autowired
    private ExamDao examDao;

    @Test
    public void should_return_exam_entity_given_valid_template_id() throws Exception{
        Long templateId = 1L;
        Exam examEntity = examService.createExam(templateId);
        assertThat(examEntity.getTemplateId()).isEqualTo(templateId);
    }

    @Test(expected = BadRequestException.class)
    public void should_throw_exception_when_the_form_or_the_template_id_is_invalid() {
        Long templateId = -1L;
        examService.createExam(templateId);
    }
}
