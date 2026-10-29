package projekat2;





import java.util.ArrayList;

public class Game {
	private PraviPlayer igrac;
	private ArrayList<PraviEnemy> neprijatelji = new ArrayList<PraviEnemy>();
	private ArrayList<String> eventLog = new ArrayList<String>();

	public Game(PraviPlayer igrac) {
		this.igrac = igrac;
	}

	// da li se igrac i neprijatelj preklapaju, koristi intersects() iz GameObject
	public boolean checkCollision(PraviPlayer p, PraviEnemy e) {
		return p.intersects(e);
	}

	// smanjuje zdravlje igraca i pise u eventlog-u :D
	// ako je BossEnemy, steta se mnozi sa 2
	public void decreaseHealth(PraviPlayer p, PraviEnemy e) {
		int steta = e.getDamage();
		if (e instanceof BossEnemy) {
			steta = steta * 2;
		}

		int staroZdravlje = p.getZdravlje();
		int novoZdravlje = staroZdravlje - steta;

		if (novoZdravlje < 0) {
			novoZdravlje = 0;
		}
		p.setZdravlje(novoZdravlje);

		String poruka = "HIT: " + p.getIme() + " by " + e.getTip() + " for " + steta;
		poruka = poruka + " -> HP " + staroZdravlje + " -> " + novoZdravlje;
		eventLog.add(poruka);
	}

	
	public void addEnemy(PraviEnemy e) {
		neprijatelji.add(e);
		eventLog.add("ADD: " + e);
	}

	
	public ArrayList<PraviEnemy> findByType(String tekst) {
		ArrayList<PraviEnemy> rezultat = new ArrayList<PraviEnemy>();
		for (PraviEnemy e : neprijatelji) {
			if (e.getTip().toLowerCase().contains(tekst.toLowerCase())) {
				rezultat.add(e);
			}
		}
		return rezultat;
	}

	// daje nam neprijatelje koji se sudaraju sa igracem
	public ArrayList<PraviEnemy> collidingWithPlayer() {
		ArrayList<PraviEnemy> rezultat = new ArrayList<PraviEnemy>();
		for (PraviEnemy e : neprijatelji) {
			if (checkCollision(igrac, e)) {
				rezultat.add(e);
			}
		}
		return rezultat;
	}


	public void resolveCollisions() {
		for (PraviEnemy e : neprijatelji) {
			if (checkCollision(igrac, e)) {
				decreaseHealth(igrac, e);
			}
		}
	}

	public static void main(String[] args) {
		PraviPlayer p = new PraviPlayer("  robert       maljevic ", 10, 5, 32, 32, 85);
		Game igra = new Game(p);

		// prvi neprijatelj smo napravili rucno 
		igra.addEnemy(new MeleeEnemy("Skeleton", 50, 50, 20, 20, 10, 60));

		
		String linija = "Goblin;12,5;16x16;20;boss";
		String[] dijelovi = linija.split(";"); //goblin se odvaja u sektore, "Goblin", "12,5", "16x16", "20", "boss"
		String[] pozicija = dijelovi[1].split(",");
		String[] velicina = dijelovi[2].split("x");
		String tip = dijelovi[0];
		int x = Integer.parseInt(pozicija[0]);
		int y = Integer.parseInt(pozicija[1]);
		int sirina = Integer.parseInt(velicina[0]);
		int visina = Integer.parseInt(velicina[1]);
		int damage = Integer.parseInt(dijelovi[3]);
		String vrsta = dijelovi[4];

		PraviEnemy goblin;
		if (vrsta.equals("boss")) {
			goblin = new BossEnemy(tip, x, y, sirina, visina, damage, 100);
		} else {
			goblin = new MeleeEnemy(tip, x, y, sirina, visina, damage, 100);
		}
		igra.addEnemy(goblin);

		System.out.println("Svi neprijatelji:");
		for (PraviEnemy e : igra.neprijatelji) {
			System.out.println(e);
		}

		System.out.println("\nPretraga za gob-om:");
		for (PraviEnemy e : igra.findByType("gob")) {
			System.out.println(e);
		}

		System.out.println("\nSudari:");
		for (PraviEnemy e : igra.collidingWithPlayer()) {
			System.out.println(e);
		}

		System.out.println("\nPrije:   " + p);
		igra.resolveCollisions();
		System.out.println("Poslije: " + p);

		System.out.println("\nEvent log:");
		for (String poruka : igra.eventLog) {
			System.out.println(poruka);
		}
	}
}

