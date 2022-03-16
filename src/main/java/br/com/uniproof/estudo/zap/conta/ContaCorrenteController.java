package br.com.uniproof.estudo.zap.conta;

import br.com.uniproof.estudo.zap.conta.bean.ContaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaCorrenteController {
    @Autowired
    private ContaConfig contaConfig;

    @GetMapping("/getTaxa")
    public String getTaxa(){
        return "Taxa: " + contaConfig.getTaxaSaqueCC();
    }
}
