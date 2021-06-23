package parkour;

import parkour.metier.Jeu;
import parkour.IHM.CUI;
import parkour.utilitaires.Vector2;

import java.util.Scanner;

public class Controleur
{
	private Jeu metier;
    private CUI ihm;

	public Controleur()
	{
        this.metier = new Jeu();
		this.metier.placerJoueur(new Vector2(1, 11));
        this.ihm    = new CUI(this);

		int compteur = 0;

		while(!this.metier.verifierPlateau())
		{
			this.ihm.afficherPlateauJeu();

			this.ihm.afficherCoordJoueur();
	
			this.ihm.afficherMenuSaisie();
			char direction = this.getSaisie();
	
			while(this.metier.deplacerJoueur(direction))
				this.metier.deplacerJoueur(direction);

			compteur++;
		}

		System.out.println("Vous avez gagne en " + compteur + " coups.");
	}

	public char[][] getTabPlateau(){ return this.metier.getTabPlateau(); }

	public Vector2 getPlayerPos(){ return this.metier.getPlayerPos(); }

	public char getSaisie()
	{
		Scanner input = new Scanner(System.in);
		
		return input.nextLine().charAt(0);
	}

	public static void main(String[] args)
	{
        new Controleur();
	}
}