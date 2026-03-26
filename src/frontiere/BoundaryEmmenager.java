package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder questionGaulois = new StringBuilder();
					questionGaulois.append("Bienvenue villageois ");
					questionGaulois.append(nomVisiteur);
					questionGaulois.append("\n");
					questionGaulois.append("Quelle est votre force ?\n");
					int force = Clavier.entrerEntier(questionGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionDruide = new StringBuilder();
		questionDruide.append("Bienvenue druide ");
		questionDruide.append(nomVisiteur);
		questionDruide.append("\n");
		questionDruide.append("Quelle est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(questionDruide.toString());
		int effetPotionMax = -1;
		int effetPotionMin = 0;
		questionDruide = new StringBuilder();
		while(effetPotionMax < effetPotionMin) {
			questionDruide.append("Quel est la force de potion la plus faible que vous prouisez ?\n");
			effetPotionMin = Clavier.entrerEntier(questionDruide.toString());
			questionDruide.append("Quel est la force de potion la plus forte que vous prouisez ?\n");
			effetPotionMax = Clavier.entrerEntier(questionDruide.toString());
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention ruide, vous vous êtes trompé entre le minimum et le maximum !");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
