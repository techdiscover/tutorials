package net.techdiscover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String physicalAddress;
    private String emailAddress;
}
