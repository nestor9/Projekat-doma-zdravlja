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
import osobe.Zdrastvena_knjizica;

public class KnjizicaForma extends JFrame {
	private JLabel lblBrKnjizice = new JLabel("Broj knjizice");
	private JTextField txtBrKnjizice = new JTextField(30);
	private JLabel lblDatumIsteka = new JLabel("Datum isteka");
	private JTextField txtDatumIsteka = new JTextField(30);
	private JLabel lblKategorija = new JLabel("Kategorija");
	private JTextField txtKategorija = new JTextField(30);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Zdrastvo sistem;
	private Zdrastvena_knjizica knjizica;

	public KnjizicaForma(Zdrastvo sistem,Zdrastvena_knjizica knjizica){
		this.sistem=sistem;
		this.knjizica=knjizica;
		if(this.knjizica == null) {
			setTitle("Dodavanje zdrastvenih knjizica");
		}else {
			setTitle("Izmena podataka - " + this.knjizica.getBroj_zdras_knjiz());
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
		
		if (knjizica != null) {
			popunjavanjePolja();
		}
		
		add(lblBrKnjizice);
		add(txtBrKnjizice);
		add(lblDatumIsteka);
		add(txtDatumIsteka);
		add(lblKategorija);
		add(txtKategorija);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popunjavanjePolja() {
		txtBrKnjizice.setText(knjizica.getBroj_zdras_knjiz());
		txtDatumIsteka.setText(knjizica.getDatum_isteka());
		txtKategorija.setText(String.valueOf(knjizica.getKategorija()));
	}
	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
				String brKnjizice = txtBrKnjizice.getText().trim();
				String DtIsteka=txtDatumIsteka.getText().trim();
				int kategorija=Integer.parseInt(txtKategorija.getText().trim());
				if(knjizica == null) {
					Zdrastvena_knjizica knjizica = new Zdrastvena_knjizica(brKnjizice, DtIsteka, kategorija);
					sistem.getKnjizice().add(knjizica);
				}else {
					knjizica.setBroj_zdras_knjiz(brKnjizice);
					knjizica.setDatum_isteka(DtIsteka);
					knjizica.setKategorija(kategorija);
				}
				sistem.snimiKnjizicu("zdrastvenaKnjizica.txt");
				JOptionPane.showMessageDialog(null, "Snimljeno", "Obavestenje",
						JOptionPane.DEFAULT_OPTION);
				KnjizicaForma.this.dispose();
				KnjizicaForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjizicaForma.this.dispose();
				KnjizicaForma.this.setVisible(false);
			}
		});
	}
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtBrKnjizice.getText().trim().equals("")) {
			poruka += "- Unesite broj knjizice\n";
			ok = false;
		}
		if(txtDatumIsteka.getText().trim().equals("")) {
			poruka += "- Unesite datum isteka\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}

