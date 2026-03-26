package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean veneurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!veneurReconnu) {
			StringBuilder message = new StringBuilder();
			message.append("Mais vous n'êtes pas inscrit sur notre marché aujour'hui !");
			System.err.println(message);
			
		} else {
			StringBuilder message = new StringBuilder();
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			message.append("Vous avez vendu ");
			message.append(donneesEtal[4]);
			message.append(" sur ");
			message.append(donneesEtal[3]);
			message.append(" ");
			message.append(donneesEtal[2]);
			message.append("\nAu revoir ");
			message.append(donneesEtal[1]);
			message.append(" , passez une bonne journe.");
			System.out.println(message.toString());
		}
	}

}
