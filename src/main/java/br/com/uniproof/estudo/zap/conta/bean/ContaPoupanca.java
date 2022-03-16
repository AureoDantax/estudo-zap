package br.com.uniproof.estudo.zap.conta.bean;

import org.springframework.stereotype.Service;

@Service
public class ContaPoupanca extends AbstractConta {

    private ContaPoupanca() throws ContaException {
        super(1,1);
    };

    public ContaPoupanca(Integer agencia, Integer conta) throws ContaException {
        super(agencia, conta);
    }

    public void deposita(Double valor) {
        super.saldo += valor;
    }
}