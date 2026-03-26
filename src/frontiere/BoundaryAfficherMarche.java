package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerEtatMarche();
		if(infosMarche.length == 0){
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder message = new StringBuilder();
			message.append(nomAcheteur);
			message.append(", vous trouverez au marché :\n");
			for (int i = 0; i < infosMarche.length; i++) {
				message.append("- ");
				message.append(infosMarche[i]);
				i++;
				message.append(" qui vend ");
				message.append(infosMarche[i]);
				i++;
				message.append(" ");
				message.append(infosMarche[i]);
			}
			System.out.println(message.toString());
		}
	}
}
