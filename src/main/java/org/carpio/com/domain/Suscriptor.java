package org.carpio.com.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Suscriptor {
    private Integer idSuscriptor;
    private String name;
    private String lastname;
    private String number;
    private Boolean isActive;
    private Integer idCinema;
}
