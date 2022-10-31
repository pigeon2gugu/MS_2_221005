package com.springboot.hospitalserchapi.parser;

import com.springboot.hospitalserchapi.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() {

        return new ReadLineContext<Hospital>(new HospitalParser());
    }
}
