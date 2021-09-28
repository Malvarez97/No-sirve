package compilador.Asemanticas;

import compilador.AnalizadorLex;
import compilador.CodigoFuente;

public class NotError extends AccionSemantica{
    private String mensaje;
    private AnalizadorLex lexico;
    private CodigoFuente fuente;
    private boolean irreconocible;

    public NotError(String mensaje, AnalizadorLex lexico, CodigoFuente fuente, boolean irreconocible) {
        this.mensaje = mensaje;
        this.lexico = lexico;
        this.fuente = fuente;
        this.irreconocible = irreconocible;
    }

    @Override
    public void ejecutar() {
     String error ="";
     if(irreconocible){
         error += "El Simbolo "+irreconocible+"  no fue reconocido";
     }
     else error+=mensaje;

     Notificacion.addError(lexico.getLineaActual(),error);

    }
}