package projekat2;



//Clanovi grupe: Danis Surovic 25/122 FIST, Anan Mulic 25/078 FIST, Robert Maljevic 25/011
// i Emil Rizvanovic 25/059
//Osnovna klasa iz koje nasljedjuju igrac i neprijatelji.
//Svaki objekat u igri je pravougaonik sa pozicijom (x, y) i dimenzijama.

public class GameObject {
	private int x, y;
	private int sirina, visina;

	public GameObject(int x, int y, int sirina, int visina) {
		setX(x);
		setY(y);
		setSirina(sirina);
		setVisina(visina);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSirina() {
		return sirina;
	}

	
	public void setSirina(int sirina) {
		if (sirina > 0) {
			this.sirina = sirina;
		} else {
			System.out.println("Sirina mora biti veca od nule.");
			this.sirina = 1;
		}
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		if (visina > 0) {
			this.visina = visina;
		} else {
			System.out.println("Visina mora biti veca od nule.");
			this.visina = 1;
		}
	}

	
	public boolean intersects(GameObject other) {
		if (x + sirina <= other.x) {
			return false;
		}
		if (x >= other.x + other.sirina) {
			return false;
		}
		if (y + visina <= other.y) {
			return false;
		}
		if (y >= other.y + other.visina) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "GameObject @ (" + x + "," + y + ") " + sirina + "x" + visina;
	}
}
