package com.github.matheushr97.eventaudit.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consumer {

    private Long id;
    private String name;

}
