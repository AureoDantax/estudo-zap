package br.com.uniproof.estudo.zap.conta.bean;

import br.com.uniproof.estudo.zap.cliente.bean.Cliente;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public abstract class AbstractConta {

    protected Double saldo;
    private Integer agencia;
    private Integer numero;
    private Cliente titular;
    private static Integer total = 0;

    // CONSTRUTOR ESPECÍFICO - Recebe agencia e conta

    public AbstractConta(Integer agencia, Integer numero) throws ContaException {
        setAgencia(agencia);
        setNumero(numero);
        setSaldo(0d);
        total++;
    }

    public abstract void deposita(Double valor);

    public Boolean saca(Double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public Boolean transfere(Double valor, AbstractConta destino) {
        if (saca(valor)) {
            destino.deposita(valor);
            return true;

        } else {
            return false;
        }
    }

    public void setNumero(Integer numero) throws ContaException {
        if (numero <= 0) {
            throw new ContaException("Conta inválida (" + numero + ")");
        }
        this.numero = numero;
    }

    public void setAgencia(Integer agencia) throws ContaException {
        if (agencia <= 0) {
            throw new ContaException("Esse número de agencia (" + agencia + ") não é válido");
        }
        this.agencia = agencia;
    }
}
