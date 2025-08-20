package com.uml2code.backend.model.classdiagram;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmlMethod {
    private String name;
    private String returnType;
    private Visibility visibility;
    private List<UmlParameter> parameters;
    private boolean isAbstract;
    private boolean isStatic;
}
