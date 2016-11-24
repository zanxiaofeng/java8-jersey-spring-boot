package com.thoughtworks.gaia.quizrepository.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.quizrepository.model.QuizRepositoryModel;
import org.springframework.stereotype.Component;

@Component
public class QuizRepositoryDao extends BaseDaoWrapper<QuizRepositoryModel> {
    public QuizRepositoryDao() {
        super(QuizRepositoryModel.class);
    }
}
