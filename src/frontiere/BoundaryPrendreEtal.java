package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVeneurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVeneurConnu) {
			StringBuilder message = new StringBuilder();
			message.append("Je suis désolée ");
			message.append(nomVendeur);
			message.append(" mais il faut être un habitant du village pour  commercer ici.");
			System.out.println(message.toString());
		} else {
			StringBuilder message = new StringBuilder();
			message.append("Bonjour, ");
			message.append(nomVendeur);
			message.append(" je vais regarder si je peux vous trouver un étal.");
			System.out.println(message.toString());
			
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				message = new StringBuilder();
				message.append("Désolée ");
				message.append(nomVendeur);
				message.append(" d'étal qui ne soit pas éjà occupé.");
				System.out.println(message.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		message.append("Parfait, il me reste un étal pour vous !\n");
		message.append("Il me faudrait quelques renseignements :\n");
		message.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(message.toString());
		message = new StringBuilder();
		message.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(message.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			message = new StringBuilder();
			message.append("Le veneur ");
			message.append(nomVendeur);
			message.append(" s'est instllé à l'étal numéro ");
			message.append(numeroEtal);
			System.out.println(message.toString());
		}
	}
}
