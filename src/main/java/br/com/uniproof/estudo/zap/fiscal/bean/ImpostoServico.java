package br.com.uniproof.estudo.zap.fiscal.bean;

public class ImpostoServico {

    double TotalImposto;

    public void registra(Tributavel t) {
        double valor = t.getValorImposto();
        this.TotalImposto += valor;
    }

    public Double getValorImposto() {
        return TotalImposto;
    }

}
