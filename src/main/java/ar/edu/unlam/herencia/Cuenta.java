package ar.edu.unlam.herencia;

public class Cuenta {

    protected String numeroCuenta;
    protected Double saldo;
    protected Persona titular;

    public Cuenta(String numeroCuenta, Double saldo, Persona titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cuenta(){}


    public void extraer(Double monto) throws FondosInsuficientesException {
        //logica para extraer

        if( puedoExtraer(monto) ){

            this.saldo -= monto;
        }

    }

    protected boolean puedoExtraer(Double monto) {

        return this.saldo >= monto && monto > 0;
    }


    public void depositar(Double monto){
        //logica para depositar

        if(monto > 0){
            this.saldo += monto;
        }

    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }

}
