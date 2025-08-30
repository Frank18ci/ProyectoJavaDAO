package org.carpio.com.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Worker {
    private Integer idWorker;
    private String name;
    private String lastName;
    private String direction;
    private String number;
    private Integer idCinema;
}
