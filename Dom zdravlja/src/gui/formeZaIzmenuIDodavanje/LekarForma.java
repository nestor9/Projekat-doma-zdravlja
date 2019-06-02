package gui.formeZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domZdravlja.Zdrastvo;
import enumeracija.TipOsobe;
import net.miginfocom.swing.MigLayout;
import osobe.Lekar;

public class LekarForma extends JFrame {
	private String uloga= new String("Lekar"); 
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(30);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(30);
	private JLabel lblJMBG = new JLabel("JMBG");
	private JTextField txtJMBG = new JTextField(30);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<TipOsobe> cbPol = new JComboBox<TipOsobe>(TipOsobe.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(30);
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(30);
	private JLabel lblKorisnicko = new JLabel("Korisnicko");
	private JTextField txtKorisnicko = new JTextField(30);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfSifra = new JPasswordField(30);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(30);
	private JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
	private JTextField txtSpecijalizacija = new JTextField(30);
	private JLabel lblSluzba = new JLabel("Sluzba");
	private JTextField txtSluzba = new JTextField(30);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Zdrastvo sistem;
	private Lekar lekar;

	public LekarForma(Zdrastvo sistem,Lekar lekar){
		this.sistem=sistem;
		this.lekar=lekar;
		if(this.lekar == null) {
			setTitle("Dodavanje lekara");
		}else {
			setTitle("Izmena podataka - " + this.lekar.getKor_Ime());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
	}
	
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		
		if (lekar != null) {
			popunjavanjePolja();
		}
		
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJMBG);
		add(txtJMBG);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblBrTelefona);
		add(txtBrTelefona);
		add(lblKorisnicko);
		add(txtKorisnicko);
		add(lblLozinka);
		add(pfSifra);
		add(lblPlata);
		add(txtPlata);
		add(lblSpecijalizacija);
		add(txtSpecijalizacija);
		add(lblSluzba);
		add(txtSluzba);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popunjavanjePolja() {
		txtIme.setText(lekar.getIme());
		txtPrezime.setText(lekar.getPrezime());
		txtJMBG.setText(lekar.getJmbg());
		cbPol.setSelectedItem(this.lekar.getPol());
		txtAdresa.setText(lekar.getAdresa());
		txtBrTelefona.setText(lekar.getBr_tel());
		txtKorisnicko.setText(lekar.getKor_Ime());
		pfSifra.setText(lekar.getLozinka());
		lekar.setUloga(uloga);
		txtPlata.setText(String.valueOf(lekar.getPlata()));
		txtSpecijalizacija.setText(lekar.getSpecijalizacija());
		txtSluzba.setText(lekar.getSluzba());
	}
	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
				String ime = txtIme.getText().trim();
				String prezime=txtPrezime.getText().trim();
				String jmbg=txtJMBG.getText().trim();
				String adresa=txtAdresa.getText().trim();
				String br_tel=txtBrTelefona.getText().trim();
				String kor_ime=txtKorisnicko.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				double plata=Double.parseDouble(txtPlata.getText().trim());
				String specijalizacija=txtSpecijalizacija.getText().trim();
				String sluzba=txtSluzba.getText().trim();
				TipOsobe pol = (TipOsobe) cbPol.getSelectedItem();
				if(lekar == null) {
					Lekar lekar = new Lekar(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, sifra,uloga, plata, specijalizacija, sluzba);
					sistem.getLekari().add(lekar);
				}else {
					lekar.setIme(ime);
					lekar.setPrezime(prezime);
					lekar.setJmbg(jmbg);
					lekar.setPol(pol);
					lekar.setAdresa(adresa);
					lekar.setBr_tel(br_tel);
					lekar.setKor_Ime(kor_ime);
					lekar.setLozinka(sifra);
					lekar.setUloga(uloga);
					lekar.setPlata(plata);
					lekar.setSpecijalizacija(specijalizacija);
					lekar.setSluzba(sluzba);
				}
				sistem.snimiLekare("lekari.txt");
				JOptionPane.showMessageDialog(null, "Snimljeno", "Obavestenje",
						JOptionPane.DEFAULT_OPTION);
				LekarForma.this.dispose();
				LekarForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LekarForma.this.dispose();
				LekarForma.this.setVisible(false);
			}
		});
	}
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime\n";
			ok = false;
		}
		if(txtKorisnicko.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}
		String sifra = new String(pfSifra.getPassword()).trim();
		if(sifra.trim().equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}

