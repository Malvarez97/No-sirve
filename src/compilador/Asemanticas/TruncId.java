package compilador.Asemanticas;

import compilador.AnalizadorLex;

public class TruncId  extends AccionSemantica {
	
	private final static int maxString = 20;
	private final AnalizadorLex lexico;
	
	public TruncId(AnalizadorLex lexico) {
		this.lexico=lexico;
	}
	
	public void ejecutar() {
		if(maxString < tamString()) {
			truncaString(maxString);
			AnalizadorLex.Notificacion.addWarnings(lexico.getLineaActual(),null );
		}
	}
}
