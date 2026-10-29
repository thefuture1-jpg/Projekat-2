package projekat2;




public class PraviEnemy extends GameObject {
	private String tip;
	private int damage;
	private int zdravlje;

	public PraviEnemy(String tip, int x, int y, int sirina, int visina, int damage, int zdravlje) {
		super(x, y, sirina, visina);   // x, y, sirina, visina postavlja GameObject
		setTip(tip);
		setDamage(damage);
		setZdravlje(zdravlje);
	}

	public String getTip() {
		return tip;
	}

	// Tip ne moze biti prazan
	public void setTip(String tip) {
		if (tip == null || tip.trim().isEmpty()) {
			System.out.println("Tip ne moze biti prazan.");
			this.tip = "Nepoznat";
		} else {
			this.tip = tip.trim();
		}
	}

	public int getDamage() {
		return damage;
	}

	// Damage mora biti izmedju 0 i 100
	public void setDamage(int damage) {
		if (damage < 0) {
			this.damage = 0;
		} else if (damage > 100) {
			this.damage = 100;
		} else {
			this.damage = damage;
		}
	}

	public int getZdravlje() {
		return zdravlje;
	}

	
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
		return "Enemy[" + tip + "] @ (" + getX() + "," + getY() + ") " + getSirina() + "x" + getVisina()
				+ " DMG=" + damage + " HP=" + zdravlje;
	}
}

