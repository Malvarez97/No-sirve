package compilador.Asemanticas;

import compilador.AnalizadorLex;
import compilador.MaquinaEstados.MaquinaEstados;
import compilador.TablaPalabrasReserv;

// corrobora si la palabra reservada es valida y agrega el token a la lista de tokens

public class GeneraTPr extends AccionSemantica{
    private MaquinaEstados maquina ;

    public GeneraTPr(MaquinaEstados maquina){
        this.maquina=maquina;
    }

    @Override
    public void ejecutar() {
        String palabra =getString();
        if(TablaPalabrasReserv.esReservada(palabra)){
            maquina.setVariablesSintactico(TablaPalabrasReserv.getToken(palabra),""); //
        }else
        {
            AnalizadorLex.Notificacion.addError(maquina.getLineaActual(),"la palabra resevada siguiente no fue encontrada como palabra reservada"+palabra);
            maquina.reiniciar();
        }

    }
}