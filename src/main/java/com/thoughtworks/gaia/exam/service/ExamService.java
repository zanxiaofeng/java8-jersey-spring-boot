package com.thoughtworks.gaia.exam.service;

import com.netflix.discovery.converters.Auto;
import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.common.exception.BadRequestException;
import com.thoughtworks.gaia.exam.ExamMapper;
import com.thoughtworks.gaia.exam.dao.ExamDao;
import com.thoughtworks.gaia.exam.entity.Exam;
import com.thoughtworks.gaia.exam.model.ExamModel;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by wyli on 16/11/24.
 */
@Component
@Transactional
public class ExamService implements Loggable {

    @Autowired
    private ExamMapper mapper;

    @Autowired
    private ExamDao examDao;

    public Exam createExam(Long templateId) {
        if (templateId <= 0L){
            error("The templateId that you chose is invalid!");
            throw new BadRequestException();
        }
        ExamModel examModel = new ExamModel();
        examModel.setTemplateId(templateId);
        examModel.setStartTime(new Date());
        examDao.save(examModel);

        return mapper.map(examModel, Exam.class);
    }
}

