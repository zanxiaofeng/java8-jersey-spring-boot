package com.thoughtworks.gaia.template.entity;

public class Template {
    private Long id;

    private String name;

    private String description;

    private LogicQuestion logicQuestion;

    private int[] programQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LogicQuestion getLogicQuestion() {
        return logicQuestion;
    }

    public void setLogicQuestion(LogicQuestion logicQuestion) {
        this.logicQuestion = logicQuestion;
    }

    public int[] getProgramQuestion() {
        return programQuestion;
    }

    public void setProgramQuestion(int[] programQuestion) {
        this.programQuestion = programQuestion;
    }

    private class LogicQuestion {

        private int hardQuestionNumber;

        private int middleQuestionNumber;

        public int getHardQuestionNumber() {
            return hardQuestionNumber;
        }

        public void setHardQuestionNumber(int hardQuestionNumber) {
            this.hardQuestionNumber = hardQuestionNumber;
        }

        public int getMiddleQuestionNumber() {
            return middleQuestionNumber;
        }

        public void setMiddleQuestionNumber(int middleQuestionNumber) {
            this.middleQuestionNumber = middleQuestionNumber;
        }

        public int getEasyQuestionNumber() {
            return easyQuestionNumber;
        }

        public void setEasyQuestionNumber(int easyQuestionNumber) {
            this.easyQuestionNumber = easyQuestionNumber;
        }

        private int easyQuestionNumber;

    }



}
