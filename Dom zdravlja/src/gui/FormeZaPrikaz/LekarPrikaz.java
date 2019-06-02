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
import gui.formeZaIzmenuIDodavanje.LekarForma;
import osobe.Lekar;

public class LekarPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable LekarTabela;
	
	private Zdrastvo sistem;
	
	public LekarPrikaz(Zdrastvo sistem) {
		this.sistem = sistem;
		setTitle("Lekari");
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
				"Lozinka", "Uloga", "Plata", "Specijalizacija", "Sluzba" };
		Object[][] podatak = new Object[sistem.getLekari().size()][zaglavlje.length];
		for (int i = 0; i < sistem.getLekari().size(); i++) {
			Lekar lekar = sistem.getLekari().get(i);
			podatak[i][0] = lekar.getIme();
			podatak[i][1] = lekar.getPrezime();
			podatak[i][2] = lekar.getJmbg();
			podatak[i][3] = lekar.getPol();
			podatak[i][4] = lekar.getAdresa();
			podatak[i][5] = lekar.getBr_tel();
			podatak[i][6] = lekar.getKor_Ime();
			podatak[i][7] = lekar.getLozinka();
			podatak[i][8] = lekar.getUloga();
			podatak[i][9] = lekar.getPlata();
			podatak[i][10] = lekar.getSpecijalizacija();
			podatak[i][11] = lekar.getSluzba();
		}
		tableModel = new DefaultTableModel(podatak, zaglavlje);
		LekarTabela = new JTable(tableModel);
		LekarTabela = new JTable(tableModel);
		LekarTabela.setRowSelectionAllowed(true);
		LekarTabela.setColumnSelectionAllowed(false);
		LekarTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		LekarTabela.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(LekarTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LekarForma lf=new LekarForma(sistem, null);
				lf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = LekarTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)LekarTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Lekar lekar = sistem.pronadjiLekara(jmbg);
					if(lekar != null) {
						LekarForma lef = new LekarForma(sistem, lekar);
						lef.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog lekara!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = LekarTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)LekarTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Lekar lekar = sistem.pronadjiLekara(jmbg);
					if(lekar != null) {
						int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete lekara?", lekar.getIme()+lekar.getPrezime() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							sistem.getLekari().remove(lekar);
							model.removeRow(red);
							sistem.snimiLekare("lekari.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog lekara!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}
