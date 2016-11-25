package test.functional.template;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.gaia.template.dao.TemplateDao;
import com.thoughtworks.gaia.template.model.TemplateModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class TemplateServiceFunctionalTest {


    @Autowired
    private TemplateDao templateDao;

    @Test
    public void should_return_template_with_id()  throws Exception{

        TemplateModel templateModel = dummyTemplateModel();

        templateDao.save(templateModel);

//        long templateId=templateModel.getId();

//        templateDao.where("")



    }

    private TemplateModel dummyTemplateModel() {
        TemplateModel dummyTemplateModel=new TemplateModel();
        dummyTemplateModel.setId(1L);
        dummyTemplateModel.setDescription("哈哈");
        dummyTemplateModel.setLogic_question_easy_number(5);
        dummyTemplateModel.setLogic_question_middle_number(3);
        dummyTemplateModel.setLogic_question_hard_number(2);
        dummyTemplateModel.setLogic_question_repository_id(2);
        dummyTemplateModel.setProgram_question_list("[2,5,8]");





        return dummyTemplateModel;
    }


    public TemplateDao getTemplateDao() {
        return templateDao;
    }

    public void setTemplateDao(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }
}
