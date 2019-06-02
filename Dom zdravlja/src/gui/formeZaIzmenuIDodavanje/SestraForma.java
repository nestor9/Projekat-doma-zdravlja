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
import osobe.Med_sestra;

public class SestraForma extends JFrame {
	private String uloga= new String("Medicinska sestra"); 
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
	private JLabel lblSluzba = new JLabel("Sluzba");
	private JTextField txtSluzba = new JTextField(30);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Zdrastvo sistem;
	private Med_sestra sestra;

	public SestraForma(Zdrastvo sistem,Med_sestra sestra){
		this.sistem=sistem;
		this.sestra=sestra;
		if(this.sestra == null) {
			setTitle("Dodavanje medicinske sestre");
		}else {
			setTitle("Izmena podataka - " + this.sestra.getKor_Ime());
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
		
		if (sestra != null) {
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
		add(lblSluzba);
		add(txtSluzba);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popunjavanjePolja() {
		txtIme.setText(sestra.getIme());
		txtPrezime.setText(sestra.getPrezime());
		txtJMBG.setText(sestra.getJmbg());
		cbPol.setSelectedItem(this.sestra.getPol());
		txtAdresa.setText(sestra.getAdresa());
		txtBrTelefona.setText(sestra.getBr_tel());
		txtKorisnicko.setText(sestra.getKor_Ime());
		pfSifra.setText(sestra.getLozinka());
		sestra.setUloga(uloga);
		txtPlata.setText(String.valueOf(sestra.getPlata()));
		txtSluzba.setText(sestra.getSluzba());
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
				String sluzba=txtSluzba.getText().trim();
				TipOsobe pol = (TipOsobe) cbPol.getSelectedItem();
				if(sestra == null) {
					Med_sestra sestra = new Med_sestra(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, sifra,uloga, plata, sluzba);
					sistem.getSestre().add(sestra);
				}else {
					sestra.setIme(ime);
					sestra.setPrezime(prezime);
					sestra.setJmbg(jmbg);
					sestra.setPol(pol);
					sestra.setAdresa(adresa);
					sestra.setBr_tel(br_tel);
					sestra.setKor_Ime(kor_ime);
					sestra.setLozinka(sifra);
					sestra.setUloga(uloga);
					sestra.setPlata(plata);
					sestra.setSluzba(sluzba);
				}
				sistem.snimiSestre("medicinskeSestre.txt");
				JOptionPane.showMessageDialog(null, "Snimljeno", "Obavestenje",
						JOptionPane.DEFAULT_OPTION);
				SestraForma.this.dispose();
				SestraForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SestraForma.this.dispose();
				SestraForma.this.setVisible(false);
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
