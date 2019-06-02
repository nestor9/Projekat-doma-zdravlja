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
import osobe.Pacijent;
import osobe.Zdrastvena_knjizica;

public class PacijentForma extends JFrame {
	private String uloga= new String("Pacijent"); 
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
	private JLabel lblKorisnicko = new JLabel("Korisnicko ime");
	private JTextField txtKorisnicko = new JTextField(30);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfSifra = new JPasswordField(30);
	private JLabel lblIz_lekar= new JLabel("Izabrani lekar");
	private JTextField txtIz_lekar = new JTextField(30);
	private JLabel lblPodaci = new JLabel("Podaci knjizice");
	private JTextField txtPodaci = new JTextField(30);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Zdrastvo sistem;
	private Pacijent pacijent;

	public PacijentForma(Zdrastvo sistem,Pacijent pacijent){
		this.sistem=sistem;
		this.pacijent=pacijent;
		if(this.pacijent == null) {
			setTitle("Dodavanje pacijenta");
		}else {
			setTitle("Izmena podataka - " + this.pacijent.getKor_Ime());
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
		
		if (pacijent != null) {
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
		add(lblIz_lekar);
		add(txtIz_lekar);
		add(lblPodaci);
		add(txtPodaci);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popunjavanjePolja() {
		txtIme.setText(pacijent.getIme());
		txtPrezime.setText(pacijent.getPrezime());
		txtJMBG.setText(pacijent.getJmbg());
		cbPol.setSelectedItem(this.pacijent.getPol());
		txtAdresa.setText(pacijent.getAdresa());
		txtBrTelefona.setText(pacijent.getBr_tel());
		txtKorisnicko.setText(pacijent.getKor_Ime());
		pfSifra.setText(pacijent.getLozinka());
		pacijent.setUloga(uloga);
		txtIz_lekar.setText(String.valueOf(pacijent.getIzabrani_lekar()));
		txtPodaci.setText(String.valueOf(pacijent.getPodaci_knjizice()));
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
				Lekar izabraniLekar=new Lekar();
				izabraniLekar.setIme(txtIz_lekar.getText().trim());
				Zdrastvena_knjizica knjizica=new Zdrastvena_knjizica();
				knjizica.setBroj_zdras_knjiz(txtPodaci.getText().trim());
				TipOsobe pol = (TipOsobe) cbPol.getSelectedItem();
				if(pacijent == null) {
					Pacijent pacijent = new Pacijent(ime, prezime, jmbg, pol, adresa, br_tel, kor_ime, sifra, uloga,izabraniLekar,knjizica);
					sistem.getPacijenti().add(pacijent);
				}else {
					pacijent.setIme(ime);
					pacijent.setPrezime(prezime);
					pacijent.setJmbg(jmbg);
					pacijent.setPol(pol);
					pacijent.setAdresa(adresa);
					pacijent.setBr_tel(br_tel);
					pacijent.setKor_Ime(kor_ime);
					pacijent.setLozinka(sifra);
					pacijent.setUloga(uloga);
					pacijent.setIzabrani_lekar(izabraniLekar);
					pacijent.setPodaci_knjizice(knjizica);
				}
				sistem.snimiPacijente("pacijenti.txt");
				JOptionPane.showMessageDialog(null, "Snimljeno", "Obavestenje",
						JOptionPane.DEFAULT_OPTION);
				PacijentForma.this.dispose();
				PacijentForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PacijentForma.this.dispose();
				PacijentForma.this.setVisible(false);
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

