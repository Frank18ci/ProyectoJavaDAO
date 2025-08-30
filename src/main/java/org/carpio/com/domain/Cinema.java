package org.carpio.com.domain;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cinema {
    private Integer idCinema;
    private String name;
    private String direction;
}
