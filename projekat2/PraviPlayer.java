package projekat2;


public class PraviPlayer extends GameObject {
	private String ime;
	private int zdravlje;

	public PraviPlayer(String ime, int x, int y, int sirina, int visina, int zdravlje) {
		super(x, y, sirina, visina);   // x, y, sirina, visina postavlja GameObject
		setIme(ime);
		setZdravlje(zdravlje);
	}

	public String getIme() {
		return ime;
	}

	// Ime ne smije biti prazno, brisemo visak razmaka
	// i svaku rijec pocinjemo velikim slovom
	public void setIme(String ime) {
		String[] rijeci = ime.split(" ");
		String novoIme = "";

		for (int i = 0; i < rijeci.length; i++) {
			String r = rijeci[i];
			if (r.length() > 0) {
				if (novoIme.length() > 0) {
					novoIme = novoIme + " ";
				}
				novoIme = novoIme + r.substring(0, 1).toUpperCase() + r.substring(1).toLowerCase();
			}
		}

		if (novoIme.length() == 0) {
			novoIme = "Igrac";
		}
		this.ime = novoIme;
	}

	public int getZdravlje() {
		return zdravlje;
	}

	// Health poeni moraju biti izmedju 0 i 100, inace je nerealisticno
	public void setZdravlje(int zdravlje) {
		if (zdravlje < 0) {
			this.zdravlje = 0;
		} else if (zdravlje > 100) {
			this.zdravlje = 100;
		} else {
			this.zdravlje = zdravlje;
		}
	}

	public String toString() {
		return "Player[" + ime + "] @ (" + getX() + "," + getY() + ") " + getSirina() + "x" + getVisina()
				+ " HP=" + zdravlje;
	}
}
