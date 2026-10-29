package projekat2;




public class BossEnemy extends PraviEnemy {

	public BossEnemy(String tip, int x, int y, int sirina, int visina, int damage, int zdravlje) {
		super(tip, x, y, sirina, visina, damage, zdravlje);
	}

	
	public String toString() {
		return "BossEnemy[" + getTip() + "] @ (" + getX() + "," + getY() + ") " + getSirina() + "x" + getVisina()
				+ " DMG=" + getDamage() + "x2 HP=" + getZdravlje();
	}
}

