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
import enumeracija.StatusPregleda;
import net.miginfocom.swing.MigLayout;
import osobe.Lekar;
import osobe.Pacijent;
import pregledPacijenta.PregledPacijenta;

public class PregledForma extends JFrame {
	private JLabel lblPacijent = new JLabel("Pacijent");
	private JTextField txtPacijent = new JTextField(30);
	private JLabel lblLekar = new JLabel("Lekar");
	private JTextField txtLekar = new JTextField(30);
	private JLabel lblBr_pregleda = new JLabel("Broj pregleda");
	private JTextField txtBr_pregleda = new JTextField(30);
	private JLabel lblTermin = new JLabel("Termin pregleda");
	private JTextField txtTermin = new JTextField(30);
	private JLabel lblBr_sobe= new JLabel("Broj sobe");
	private JTextField txtBr_sobe = new JTextField(30);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(30);
	private JLabel lblSt_pregleda = new JLabel("Status pregleda");
	private JComboBox<StatusPregleda> cbStatus = new JComboBox<StatusPregleda>(StatusPregleda.values());

	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Zdrastvo sistem;
	private PregledPacijenta pregled;

	public PregledForma(Zdrastvo sistem,PregledPacijenta pregled){
		this.sistem=sistem;
		this.pregled=pregled;
		if(this.pregled == null) {
			setTitle("Dodavanje pregleda pacijenta");
		}else {
			setTitle("Izmena podataka - " + this.pregled.getBr_pregleda());
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
		
		if (pregled != null) {
			popunjavanjePolja();
		}
		
		add(lblPacijent);
		add(txtPacijent);
		add(lblLekar);
		add(txtLekar);
		add(lblBr_pregleda);
		add(txtBr_pregleda);
		add(lblTermin);
		add(txtTermin);
		add(lblBr_sobe);
		add(txtBr_sobe);
		add(lblOpis);
		add(txtOpis);
		add(lblSt_pregleda);
		add(cbStatus);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popunjavanjePolja() {
		txtPacijent.setText(String.valueOf(pregled.getPacijent()));
		txtLekar.setText(String.valueOf(pregled.getLekar()));
		txtBr_pregleda.setText(pregled.getBr_pregleda());
		txtTermin.setText(pregled.getTermin());
		txtBr_sobe.setText(pregled.getBr_sobe());
		txtOpis.setText(pregled.getOpis());
		cbStatus.setSelectedItem(pregled.getStatus_pregleda());
	}
	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
				Lekar izabraniLekar=new Lekar();
				izabraniLekar.setIme(txtLekar.getText().trim());
				Pacijent pacijent=new Pacijent();
				pacijent.setIme(txtPacijent.getText().trim());
				String br_pregleda=txtBr_pregleda.getText().trim();
				String termin=txtTermin.getText().trim();
				String br_sobe=txtBr_sobe.getText().trim();
				String opis=txtOpis.getText().trim();
				StatusPregleda status = (StatusPregleda) cbStatus.getSelectedItem();
				if(pregled == null) {
					PregledPacijenta pregled = new PregledPacijenta(pacijent, izabraniLekar, br_pregleda, termin, br_sobe, opis, status);
					sistem.getPregledi().add(pregled);
				}else {
					pregled.setLekar(izabraniLekar);
					pregled.setPacijent(pacijent);
					pregled.setBr_pregleda(br_pregleda);
					pregled.setTermin(termin);
					pregled.setBr_sobe(br_sobe);
					pregled.setOpis(opis);
					pregled.setStatus_pregleda(status);
				}
				sistem.snimiPreglede("pregled.txt");
				JOptionPane.showMessageDialog(null, "Snimljeno", "Obavestenje",
						JOptionPane.DEFAULT_OPTION);
				PregledForma.this.dispose();
				PregledForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledForma.this.dispose();
				PregledForma.this.setVisible(false);
			}
		});
	}
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtPacijent.getText().trim().equals("")) {
			poruka += "- Unesite ime pacijenta\n";
			ok = false;
		}
		if(txtLekar.getText().trim().equals("")) {
			poruka += "- Unesite ime lekara\n";
			ok = false;
		}
		if(txtBr_pregleda.getText().trim().equals("")) {
			poruka += "- Unesite broj pregleda\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}

