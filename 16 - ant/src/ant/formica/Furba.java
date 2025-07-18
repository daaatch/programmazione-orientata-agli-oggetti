package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_BIANCA;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Direzione;

public class Furba extends Inseguitrice {

	static private int progId=0;

	public Furba(Ambiente ambiente) {
		super(ambiente,progId++);
	}

	@Override
	protected Direzione scegliDirezioneDopoPerditaTraccia(Set<Direzione> possibili) {
		/* se ho cibo attorno vado verso di esso */
		final Direzione direzioneCibo = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if(direzioneCibo!=null)
			return direzioneCibo;
		/* altrimenti imbocco una direzione a caso */
		return Direzione.scegliAcasoTra(possibili);	
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_BIANCA;
	}

}
