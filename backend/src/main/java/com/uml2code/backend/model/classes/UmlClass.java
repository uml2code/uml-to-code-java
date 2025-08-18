package com.uml2code.backend.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmlClass {
    private String name;
    private List<UmlAttribute> attributes;
    private List<UmlMethod> methods;
    private Visibility visibility;
    private boolean isAbstract;
    private UmlClass superClass;
    private List<String> interfaces;
}
