package br.com.uniproof.estudo.zap.conta.bean;

import br.com.uniproof.estudo.zap.fiscal.bean.Tributavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrente extends AbstractConta implements Tributavel {

    @Autowired
    private ContaConfig contaConfig;

    public ContaCorrente() throws ContaException {
        super(1,1);
    };

    public ContaCorrente(Integer agencia, Integer conta) throws ContaException {
        super(agencia, conta);
    }

    @Override
    public Boolean saca(Double valor) {
        double saqueCC = valor + contaConfig.getTaxaSaqueCC();
        return super.saca(saqueCC);
    }

    public void deposita(Double valor) {
        super.saldo += valor;
    }

    @Override
    public Double getValorImposto() {
        return contaConfig.getImpostoCC();
    }
}
