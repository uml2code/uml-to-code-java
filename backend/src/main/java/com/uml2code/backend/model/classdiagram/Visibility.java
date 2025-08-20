package com.uml2code.backend.model.classdiagram;

public enum Visibility {
    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PACKAGE_PRIVATE("");

    private final String keyword;

    Visibility(String keyword){
        this.keyword = keyword;
    }

    @Override
    public String toString(){
        return keyword;
    }
}
