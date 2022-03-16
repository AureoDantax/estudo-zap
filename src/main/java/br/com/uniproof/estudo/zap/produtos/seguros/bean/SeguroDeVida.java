package br.com.uniproof.estudo.zap.produtos.seguros.bean;

import br.com.uniproof.estudo.zap.fiscal.bean.Tributavel;

public class SeguroDeVida implements Tributavel {

	@Override
	public Double getValorImposto() {
		return 0.04;
	}

}
