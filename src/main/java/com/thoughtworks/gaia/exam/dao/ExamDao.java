package com.thoughtworks.gaia.exam.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.exam.model.ExamModel;
import org.springframework.stereotype.Component;

/**
 * Created by wyli on 16/11/24.
 */
@Component
public class ExamDao extends BaseDaoWrapper<ExamModel>{
    public ExamDao() {super(ExamModel.class);}
}
