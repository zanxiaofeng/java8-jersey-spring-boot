package com.thoughtworks.gaia.template.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import org.springframework.stereotype.Component;
import com.thoughtworks.gaia.template.model.TemplateModel;

/**
 * Created by jfyang on 11/24/16.
 */
@Component
public class TemplateDao extends BaseDaoWrapper<TemplateModel> {
    public TemplateDao() {
        super(TemplateModel.class);
    }
}
