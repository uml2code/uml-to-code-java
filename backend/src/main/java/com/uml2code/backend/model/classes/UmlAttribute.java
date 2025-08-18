package com.uml2code.backend.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmlAttribute {
    private String name;
    private String type;
    private Visibility visibility;
    private boolean isStatic;
    private String defaultValue;
}
