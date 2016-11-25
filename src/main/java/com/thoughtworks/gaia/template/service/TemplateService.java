package com.thoughtworks.gaia.template.service;

import com.thoughtworks.gaia.common.Loggable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TemplateService implements Loggable {

//    @Autowired
//    private TemplateMapper mapper;
//
//    @Autowired
//    private TemplateDao templateDao;
//
//    public Product getProduct(Long templateId) {
//        ProductModel productModel = productDao.idEquals(productId).querySingle();
//
//        TemplateModel templateModel = templateDao.idEquals().querySingle();
//        if (productModel == null) {
//            error("Product not found with id: " + templateId);
//            throw new NotFoundException();
//        }
//
//        return mapper.map(productModel, Product.class);
//    }
}
