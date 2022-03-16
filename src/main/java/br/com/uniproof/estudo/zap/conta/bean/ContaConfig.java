package br.com.uniproof.estudo.zap.conta.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Configuration
@Data

@ConfigurationProperties(prefix = "server")
public class ContaConfig {

    @Value("${zap.cc.taxa.imposto}")
    private Double impostoCC;

    @Autowired
    @Value("${zap.cc.taxa.saque}")
    private Double taxaSaqueCC;

    @Value("${zap.cp.taxa.imposto}")
    private Double impostoCP;
}
