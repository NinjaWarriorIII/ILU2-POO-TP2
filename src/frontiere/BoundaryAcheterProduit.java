package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean isHabitant = controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur);
		if (isHabitant) {
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter ?\n");

			String produit = Clavier.entrerChaine(question.toString());

			Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurs(produit);
			if (vendeurs != null) {
				int choixVendeur = choisirUnVendeur(produit, vendeurs);
				Gaulois vendeur = vendeurs[choixVendeur];
				Etal etal = controlAcheterProduit.trouverEtal(vendeur);

				int quantite = choisirUneQuantite(nomAcheteur, produit, vendeur, etal);
				int quantiteAchete = etal.acheterProduit(quantite);
				afficherMessageAchat(quantite, quantiteAchete, nomAcheteur, produit, vendeur);

			} else {
				StringBuilder message = new StringBuilder();
				message.append("Personne ne vend sce produit au  marché.\n");
				System.out.println(message.toString());
			}

		} else {
			afficherExecuse(nomAcheteur);
		}
	}

	private int choisirUnVendeur(String produit, Gaulois[] vendeurs) {
		int choixVendeur = -1;
		while (choixVendeur < 0 || choixVendeur >= vendeurs.length) {

			StringBuilder message = new StringBuilder();
			message.append("Chez quel commerçant voulez vous acheter des ");
			message.append(produit);
			message.append(" ?\n");
			for (int i = 0; i < vendeurs.length; i++) {
				message.append(Integer.valueOf(i+1));
				message.append(" - ");
				message.append(vendeurs[i].getNom());
			}
			
			System.out.println(message.toString());
			choixVendeur = Clavier.entrerEntier("")-1;

		}
		return choixVendeur;
	}

	private int choisirUneQuantite(String nomAcheteur, String produit, Gaulois vendeur, Etal etal) {
		StringBuilder message = new StringBuilder();
		message.append(nomAcheteur);
		message.append(" se déplace jusqu'à l'étal du vendeur ");
		message.append(vendeur.getNom());
		message.append("\n Bonjour ");
		message.append(nomAcheteur);
		message.append(" combien de ");
		message.append(produit);
		message.append(" voulez-vous acheter ?");

		int quantite = 0;

		while (quantite <= 0) {
			quantite = Clavier.entrerEntier(message.toString());
		}

		return quantite;
	}

	private void afficherMessageAchat(Integer quantite, int quantiteAchete, String nomAcheteur, String produit,
			Gaulois vendeur) {
		StringBuilder message = new StringBuilder();
		if (quantiteAchete == 0) {
			message.append(nomAcheteur);
			message.append(" veut acheter ");
			message.append(Integer.valueOf(quantiteAchete));
			message.append(" ");
			message.append(produit);
			message.append(", malheureusement il n'y en a plus");
		} else if (quantiteAchete == quantite) {
			message.append(nomAcheteur);
			message.append(" achète ");
			message.append(Integer.valueOf(quantiteAchete));
			message.append(" ");
			message.append(produit);
			message.append("à");
			message.append(vendeur);

		} else {
			message.append(nomAcheteur);
			message.append("veut acheter  ");
			message.append(Integer.valueOf(quantite));
			message.append(" ");
			message.append(produit);
			message.append(", malheureusement ");
			message.append(vendeur);
			message.append(" n'en a plus que ");
			message.append(Integer.valueOf(quantiteAchete));
			message.append(nomAcheteur);
			message.append(" achète tout le stock de ");
			message.append(vendeur);
		}
		System.out.println(message.toString());
	}

	private void afficherExecuse(String nomAcheteur) {
		StringBuilder message = new StringBuilder();
		message.append("Je suis désolée ");
		message.append(nomAcheteur);
		message.append(" mais il faut être un habitant de notre village pour commercer ici\n");
		System.out.println(message.toString());
	}
}
