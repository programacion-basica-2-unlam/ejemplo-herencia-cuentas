package ar.edu.unlam.herencia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CuentasTest {


    @Test
    public void extraerDesdeUnaCuenta() throws FondosInsuficientesException {

         Persona luke = new Persona("Luke", "Skywalker", "31232432");
         Cuenta unaCuenta = new Cuenta("2202028348394", 50000d, luke);

         Double montoParaExtraer = 2000d;

         Double saldoAntesDeExtraer = unaCuenta.getSaldo();
         unaCuenta.extraer(montoParaExtraer);
         Double saldoDespuesDeExtraer = unaCuenta.getSaldo();
         Double esperado = saldoAntesDeExtraer - montoParaExtraer;

         assertEquals(esperado, saldoDespuesDeExtraer);

    }

    @Test
    public void noSePuedeExtraerUnMontoMayorAlSaldoDeUnaCuenta() throws FondosInsuficientesException {

        Persona luke = new Persona("Luke", "Skywalker", "31232432");
        Cuenta unaCuenta = new Cuenta("2202028348394", 50000d, luke);

        unaCuenta.extraer(52000d);

        assertEquals(50000d, unaCuenta.getSaldo());
    }

    @Test
    public void queSePuedaDepositarEnUnaCuenta(){

        Persona luke = new Persona("Luke", "Skywalker", "31232432");
        Cuenta unaCuenta = new Cuenta("2202028348394", 50000d, luke);

        Double montoADepositar = 5000d;
        Double saldoAntesDeDepositar = unaCuenta.getSaldo();

        unaCuenta.depositar(montoADepositar);

        Double esperado = saldoAntesDeDepositar + montoADepositar;
        assertEquals(esperado, unaCuenta.getSaldo());

    }

    @Test
    public void queSePuedaGirarEnDescubierto() throws FondosInsuficientesException {

        Double montoEnDescubierto = 2000d;
        Persona luke = new Persona("Luke", "Skywalker", "31232432");
        CuentaCorriente unaCuenta = new CuentaCorriente("2202028348394", 5000d, luke, montoEnDescubierto);

        Double montoAExtraer = 6000d;

        Double saldoEsperado = -1000d;

        unaCuenta.extraer(montoAExtraer);

        assertEquals(saldoEsperado, unaCuenta.getSaldo());
    }

    @Test
    public void queNoSePuedaExtraerMasDelGiroEnDescubierto() throws FondosInsuficientesException {


        Double montoEnDescubierto = 2000d;
        Persona luke = new Persona("Luke", "Skywalker", "31232432");
        CuentaCorriente unaCuenta = new CuentaCorriente("2202028348394", 5000d, luke, montoEnDescubierto);

        Double montoAExtraer = 8000d;

        Double saldoEsperado = 5000d;

        unaCuenta.extraer(montoAExtraer);

        assertEquals(saldoEsperado, unaCuenta.getSaldo());

    }


    @Test
    public void queLuegoDeGirarEnDesubiertoDepositoYseActualizaElSaldo() throws FondosInsuficientesException {

        Double montoEnDescubierto = 2000d;
        Persona luke = new Persona("Luke", "Skywalker", "31232432");
        CuentaCorriente unaCuenta = new CuentaCorriente("2202028348394", 5000d, luke, montoEnDescubierto);
        
        Double montoAExtraer = 6000d;
        unaCuenta.extraer(montoAExtraer);

        Double montoADepositar = 2000d;
        unaCuenta.depositar(montoADepositar);

        Double saldoEsperado = 1000d;
        assertEquals(saldoEsperado, unaCuenta.getSaldo());

    }

    //Agregar un test que prueba los fondos insuficientes

}
