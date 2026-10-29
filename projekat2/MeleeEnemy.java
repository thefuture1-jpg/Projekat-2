package projekat2;




public class MeleeEnemy extends PraviEnemy {

	public MeleeEnemy(String tip, int x, int y, int sirina, int visina, int damage, int zdravlje) {
		super(tip, x, y, sirina, visina, damage, zdravlje);
	}

	public String toString() {
		return "MeleeEnemy[" + getTip() + "] @ (" + getX() + "," + getY() + ") " + getSirina() + "x" + getVisina()
				+ " DMG=" + getDamage() + " HP=" + getZdravlje();
	}
}
