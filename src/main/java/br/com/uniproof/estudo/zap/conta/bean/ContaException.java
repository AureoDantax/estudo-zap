package br.com.uniproof.estudo.zap.conta.bean;

public class ContaException extends Exception{
    public ContaException(String errorMessage) {
        super (errorMessage);
    }
}
