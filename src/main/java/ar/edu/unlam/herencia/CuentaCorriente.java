package ar.edu.unlam.herencia;

public class CuentaCorriente extends Cuenta{


    private Double montoEnDescubierto;


    public CuentaCorriente(String numeroCuenta, Double saldo, Persona titular, Double montoEnDescubierto) {
        super(numeroCuenta, saldo, titular);
        this.montoEnDescubierto = montoEnDescubierto;
    }


    @Override
    public void extraer(Double monto){

        if(puedoExtraer(monto)){

            this.saldo -= monto;
        }


    }

    @Override
    protected boolean puedoExtraer(Double monto){

        return (this.saldo + montoEnDescubierto) >= monto && monto >0;
    }


















}
