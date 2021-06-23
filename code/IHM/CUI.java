package parkour.IHM;

import parkour.Controleur;
import parkour.utilitaires.Vector2;

public class CUI
{
    private Controleur controleur;

	public CUI(Controleur controleur)
	{
        this.controleur = controleur;
	}

	public void afficherPlateauJeu()
	{
		String sRet = "";
		char[][] tabPlateau = this.controleur.getTabPlateau();
		
		for( int lig = 0; lig < tabPlateau.length; lig++ )
		{
			for( int col = 0; col < tabPlateau[0].length; col++ )
			{
				sRet += tabPlateau[lig][col];
			}
			sRet += "\n";
		}

		System.out.println(sRet);
	}

	public void afficherMenuSaisie()
	{
		System.out.println("Veuillez saisir une direction");
	}

	public void afficherCoordJoueur()
	{
		Vector2 posJoueur = this.controleur.getPlayerPos();

		System.out.println("Joueur en coordonnees : ");
		System.out.println("X : " + posJoueur.getX());
		System.out.println("Y : " + posJoueur.getY());
	}

}