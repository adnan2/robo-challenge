package com.github.adnan2.robochallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "table")
public class TableConfig {
    private Integer rows;
    private Integer columns;
}
