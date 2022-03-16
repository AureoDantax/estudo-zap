package br.com.uniproof.estudo.zap;

import br.com.uniproof.estudo.zap.conta.bean.ContaConfig;
import br.com.uniproof.estudo.zap.conta.bean.ContaException;
import br.com.uniproof.estudo.zap.fiscal.bean.ImpostoServico;
import br.com.uniproof.estudo.zap.produtos.seguros.bean.SeguroDeVida;
import br.com.uniproof.estudo.zap.conta.bean.ContaCorrente;
import br.com.uniproof.estudo.zap.conta.bean.ContaPoupanca;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@EnableConfigurationProperties(value = ContaConfig.class)
@Slf4j
public class ContaTests {


    @Autowired
    private ContaConfig contaConfig;

    @Test()
    void contaImpostoTest() throws ContaException {

        log.info("Taxa: " + contaConfig.getTaxaSaqueCC());
        ContaCorrente cc = new ContaCorrente(01, 001);
        cc.deposita(120.0d);
        ContaPoupanca cp = new ContaPoupanca(01, 002);

        SeguroDeVida se = new SeguroDeVida();
        cc.deposita(230d);
        cc.transfere(20d, cp);
        log.info("Saldo Conta Corrente: " + cc.getSaldo());
        log.info("Saldo Conta Poupança: " + cp.getSaldo());

        ImpostoServico im = new ImpostoServico();
        im.registra(se);
        im.registra(cc);

        log.info("Valor do Imposto: " + im.getValorImposto());
        assertEquals(0.09d, im.getValorImposto());

    }

    @Test()
    void contaExceptionTest() {
        try {
            ContaCorrente cc = new ContaCorrente(-01, 001);
            ContaPoupanca cp = new ContaPoupanca(-01, 002);
            fail("Exception not thrown");
        } catch (Exception ex) {
        }
    }

}
