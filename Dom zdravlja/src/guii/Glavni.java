package guii;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.Zdrastvo;
import gui.FormeZaPrikaz.LekarPrikaz;
import gui.FormeZaPrikaz.PacijentiPrikaz;
import gui.FormeZaPrikaz.PregledPrikaz;
import gui.FormeZaPrikaz.SestrePrikaz;
import osobe.Korisnik;
import osobe.Lekar;

public class Glavni extends JFrame {
	private JMenuBar mainMenu;
	private JMenu PregledMenu;
	private JMenuItem pregledItem;
	private JMenu korisniciMenu;
	private JMenuItem lekariItem;
	private JMenuItem sestreItem;
	private JMenuItem pacijentiItem;
	
	private Zdrastvo sistem;
	private Korisnik korisnik;
	
	public Glavni(Zdrastvo sistem, Korisnik korisnik) {
		this.sistem = sistem;
		this.korisnik = korisnik;
		setTitle("Dom zdravlja - " + korisnik.getKor_Ime());
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		this.mainMenu = new JMenuBar();
		this.PregledMenu = new JMenu("Pregledi");
		this.pregledItem = new JMenuItem("Prikaži preglede pacijenata");
		this.korisniciMenu = new JMenu("Korisnici");
		this.lekariItem = new JMenuItem("Prikaži lekare");
		this.sestreItem = new JMenuItem("Prikaži sestre");
		this.pacijentiItem = new JMenuItem("Prikaži pacijente");
		
		this.PregledMenu.add(pregledItem);
		this.korisniciMenu.add(lekariItem);
		this.korisniciMenu.add(sestreItem);
		this.korisniciMenu.add(pacijentiItem);
		
		this.mainMenu.add(PregledMenu);
		this.mainMenu.add(korisniciMenu);
		
		setJMenuBar(this.mainMenu);
	}
	
	private void initActions() {
		/*pregledItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledPrikaz pp = new PregledPrikaz(sistem);
				pp.setVisible(true);
			}
		});*/
		lekariItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LekarPrikaz lpt = new LekarPrikaz(sistem);
				lpt.setVisible(true);
			}
		});
		/*sestreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SestrePrikaz sp = new SestrePrikaz(sistem);
				sp.setVisible(true);
			}
		});*/
		/*pacijentiItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PacijentiPrikaz pap = new PacijentiPrikaz(sistem);
				pap.setVisible(true);
			}
		});*/
	}
}
