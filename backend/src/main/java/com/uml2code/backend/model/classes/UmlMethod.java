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
public class UmlMethod {
    private String name;
    private String returnType;
    /// TODO: Visibility (ENUM)
    private Visibility visibility;
    private List<UmlParameter> parameters;
    private boolean isAbstract;
    private boolean isStatic;
}
