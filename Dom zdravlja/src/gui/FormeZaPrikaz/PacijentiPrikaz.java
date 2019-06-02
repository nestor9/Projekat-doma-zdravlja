package gui.FormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domZdravlja.Zdrastvo;
import gui.formeZaIzmenuIDodavanje.PacijentForma;
import osobe.Pacijent;

public class PacijentiPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable PacijentTabela;
	
	private Zdrastvo sistem;
	
	public PacijentiPrikaz(Zdrastvo sistem) {
		this.sistem = sistem;
		setTitle("Pacijenti");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		mainToolbar.add(btnAdd);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		mainToolbar.add(btnEdit);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlje = new String[] { "Ime", "Prezime", "JMBG", "Pol ", "Adresa", "Broj telefona", "Korisnicko",
				"Lozinka", "Uloga", "Izabrani lekar", "Podaci knjizice" };
		Object[][] podatak = new Object[sistem.getPacijenti().size()][zaglavlje.length];
		for (int i = 0; i < sistem.getPacijenti().size(); i++) {
			Pacijent pacijent = sistem.getPacijenti().get(i);
			podatak[i][0] = pacijent.getIme();
			podatak[i][1] = pacijent.getPrezime();
			podatak[i][2] = pacijent.getJmbg();
			podatak[i][3] = pacijent.getPol();
			podatak[i][4] = pacijent.getAdresa();
			podatak[i][5] = pacijent.getBr_tel();
			podatak[i][6] = pacijent.getKor_Ime();
			podatak[i][7] = pacijent.getLozinka();
			podatak[i][8] = pacijent.getUloga();
			podatak[i][9] = pacijent.getIzabrani_lekar();
			podatak[i][10] = pacijent.getPodaci_knjizice();
		}
		tableModel = new DefaultTableModel(podatak, zaglavlje);
		PacijentTabela = new JTable(tableModel);
		PacijentTabela = new JTable(tableModel);
		PacijentTabela.setRowSelectionAllowed(true);
		PacijentTabela.setColumnSelectionAllowed(false);
		PacijentTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PacijentTabela.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(PacijentTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PacijentForma pf=new PacijentForma(sistem, null);
				pf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = PacijentTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)PacijentTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Pacijent pacijent = sistem.pronadjiPacijenta(jmbg);
					if(pacijent != null) {
						PacijentForma paf = new PacijentForma(sistem, pacijent);
						paf.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog lekara!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = PacijentTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)PacijentTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Pacijent pacijent = sistem.pronadjiPacijenta(jmbg);
					if(pacijent != null) {
						int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete pacijenta?", pacijent.getIme()+pacijent.getPrezime() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							sistem.getLekari().remove(pacijent);
							model.removeRow(red);
							sistem.snimiPacijente("pacijenti.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog pacijenta!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}

