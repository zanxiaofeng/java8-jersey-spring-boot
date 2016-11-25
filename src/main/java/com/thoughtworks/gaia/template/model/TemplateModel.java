package com.thoughtworks.gaia.template.model;

import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CREATE TABLE `TEMPLATE` (
 `ID` int(11) NOT NULL AUTO_INCREMENT,
 `NAME` varchar(100) NOT NULL,
 `description` varchar(1000) DEFAULT NULL,
 `logic_question_repository_id` int(11) NOT NULL,
 `logic_question_hard_number` int(11) NOT NULL,
 `logic_question_middle_number` int(11) NOT NULL,
 `logic_question_easy_number` int(11) NOT NULL,
 `program_question_list` varchar(100) NOT NULL,
 PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
@Entity
@Table(name = "TEMPLATE")
public class TemplateModel extends IdBaseModel {


    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @Column(name = "logic_question_repository_id", nullable = false, length = 11)
    private int logic_question_repository_id;


    @Column(name = "logic_question_hard_number", nullable = false)
    private int logic_question_hard_number;

    @Column(name = "logic_question_middle_number", nullable = false)
    private int logic_question_middle_number;

    @Column(name = "logic_question_easy_number", nullable = false)
    private int logic_question_easy_number;

    @Column(name = "program_question_list", nullable = false)
    private String program_question_list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLogic_question_repository_id() {
        return logic_question_repository_id;
    }

    public void setLogic_question_repository_id(int logic_question_repository_id) {
        this.logic_question_repository_id = logic_question_repository_id;
    }

    public int getLogic_question_hard_number() {
        return logic_question_hard_number;
    }

    public void setLogic_question_hard_number(int logic_question_hard_number) {
        this.logic_question_hard_number = logic_question_hard_number;
    }

    public int getLogic_question_middle_number() {
        return logic_question_middle_number;
    }

    public void setLogic_question_middle_number(int logic_question_middle_number) {
        this.logic_question_middle_number = logic_question_middle_number;
    }

    public int getLogic_question_easy_number() {
        return logic_question_easy_number;
    }

    public void setLogic_question_easy_number(int logic_question_easy_number) {
        this.logic_question_easy_number = logic_question_easy_number;
    }

    public String getProgram_question_list() {
        return program_question_list;
    }

    public void setProgram_question_list(String program_question_list) {
        this.program_question_list = program_question_list;
    }
}
