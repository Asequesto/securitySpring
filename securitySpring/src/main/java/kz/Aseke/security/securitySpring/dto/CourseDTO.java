package kz.Aseke.security.securitySpring.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private int price;

}
