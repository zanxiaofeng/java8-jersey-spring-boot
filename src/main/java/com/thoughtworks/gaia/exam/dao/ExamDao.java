package com.thoughtworks.gaia.exam.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.exam.model.ExamModel;

/**
 * Created by wyli on 16/11/24.
 */
public class ExamDao extends BaseDaoWrapper<ExamModel>{
    public ExamDao() {super(ExamModel.class);}
}
