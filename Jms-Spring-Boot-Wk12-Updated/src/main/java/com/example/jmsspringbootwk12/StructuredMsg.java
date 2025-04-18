package com.example.jmsspringbootwk12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StructuredMsg implements Serializable {
    private String name;
    private String message;

}
