package parkour.metier;

import parkour.utilitaires.Vector2;

public class Jeu
{

	private char[][] tabPlateau = { {'#', '#', '#', '#', '#', '#', '#', '#' },
	                                {'#', '#', 'o', 'o', 'o', 'o', '#', '#' },
	                                {'#', '#', 'o', '#', '#', 'o', '#', '#' },
	                                {'#', 'o', 'o', '#', '#', 'o', 'o', '#' },
									{'#', 'o', 'o', 'o', 'o', 'o', 'o', '#' },
									{'#', 'o', '#', '#', '#', '#', 'o', '#' },
									{'#', 'o', 'o', 'o', 'o', 'o', 'o', '#' },
									{'#', 'o', 'o', '#', '#', 'o', 'o', '#' },
									{'#', '#', 'o', '#', '#', 'o', '#', '#' },
									{'#', 'o', 'o', '#', '#', 'o', 'o', '#' },
									{'#', 'o', 'o', '#', '#', 'o', 'o', '#' },
									{'#', 'o', 'o', 'o', 'o', 'o', 'o', '#' },
									{'#', '#', '#', '#', '#', '#', '#', '#' } };

	public Jeu()
	{
	}

	public void placerJoueur(Vector2 pos)
	{
		this.tabPlateau[pos.getY()][pos.getX()]= 'P';
	}

	public boolean verifierPlateau()
	{
		for(int y = 0; y < this.tabPlateau.length; y++)
		{
			for(int x = 0; x < this.tabPlateau[0].length; x++)
			{
				if(this.tabPlateau[y][x] == 'o')return false;
			}
		}
		return true;
	}

	public Vector2 getPlayerPos()
	{
		for(int y = 0; y < this.tabPlateau.length; y++)
		{
			for(int x = 0; x < this.tabPlateau[0].length; x++)
			{
				if(this.tabPlateau[y][x] == 'P')return new Vector2(x, y);
			}
		}

		return null;
	}

	public boolean deplacerJoueur(char direction)
	{
		Vector2 posJoueur = this.getPlayerPos();

		switch(direction)
		{
			case 'S' -> 
			{
				if(this.tabPlateau[posJoueur.getY() + 1][posJoueur.getX()] == '#')return false;

				this.tabPlateau[posJoueur.getY()][posJoueur.getX()] = 'r';
				this.tabPlateau[posJoueur.getY() + 1][posJoueur.getX()] = 'P';

				return true;
			}

			case 'E' ->
			{
				if(this.tabPlateau[posJoueur.getY()][posJoueur.getX() + 1] == '#')return false;

				this.tabPlateau[posJoueur.getY()][posJoueur.getX()] = 'r';
				this.tabPlateau[posJoueur.getY()][posJoueur.getX() + 1] = 'P';

				return true;
			}

			case 'O' ->
			{
				if(this.tabPlateau[posJoueur.getY()][posJoueur.getX() - 1] == '#')return false;

				this.tabPlateau[posJoueur.getY()][posJoueur.getX()] = 'r';
				this.tabPlateau[posJoueur.getY()][posJoueur.getX() - 1] = 'P';

				return true;
			}

			case 'N' ->
			{
				if(this.tabPlateau[posJoueur.getY() - 1][posJoueur.getX()] == '#')return false;

				this.tabPlateau[posJoueur.getY()][posJoueur.getX()] = 'r';
				this.tabPlateau[posJoueur.getY() - 1][posJoueur.getX()] = 'P';

				return true;
			}
		}

		return true;
	}

	public char[][] getTabPlateau(){ return this.tabPlateau; }
}