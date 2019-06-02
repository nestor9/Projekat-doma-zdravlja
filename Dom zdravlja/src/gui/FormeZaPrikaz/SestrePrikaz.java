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
import gui.formeZaIzmenuIDodavanje.SestraForma;
import osobe.Med_sestra;

public class SestrePrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable SestreTabela;
	
	private Zdrastvo sistem;
	
	public SestrePrikaz(Zdrastvo sistem) {
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
				"Lozinka", "Uloga", "Plata", "Sluzba" };
		Object[][] podatak = new Object[sistem.getSestre().size()][zaglavlje.length];
		for (int i = 0; i < sistem.getSestre().size(); i++) {
			Med_sestra sestra = sistem.getSestre().get(i);
			podatak[i][0] = sestra.getIme();
			podatak[i][1] = sestra.getPrezime();
			podatak[i][2] = sestra.getJmbg();
			podatak[i][3] = sestra.getPol();
			podatak[i][4] = sestra.getAdresa();
			podatak[i][5] = sestra.getBr_tel();
			podatak[i][6] = sestra.getKor_Ime();
			podatak[i][7] = sestra.getLozinka();
			podatak[i][8] = sestra.getUloga();
			podatak[i][9] = sestra.getPlata();
			podatak[i][10] = sestra.getSluzba();
		}
		tableModel = new DefaultTableModel(podatak, zaglavlje);
		SestreTabela = new JTable(tableModel);
		SestreTabela = new JTable(tableModel);
		SestreTabela.setRowSelectionAllowed(true);
		SestreTabela.setColumnSelectionAllowed(false);
		SestreTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SestreTabela.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(SestreTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SestraForma sf=new SestraForma(sistem, null);
				sf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = SestreTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)SestreTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Med_sestra sestra = sistem.pronadjiSestru(jmbg);
					if(sestra != null) {
						SestraForma sef = new SestraForma(sistem, sestra);
						sef.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu medicinsku sestru!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = SestreTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)SestreTabela.getModel();
					String jmbg = model.getValueAt(red, 2).toString();
					Med_sestra sestra = sistem.pronadjiSestru(jmbg);
					if(sestra != null) {
						int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete lekara?", sestra.getIme()+sestra.getPrezime() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							sistem.getLekari().remove(sestra);
							model.removeRow(red);
							sistem.snimiLekare("lekari.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu medicinsku sestru!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}
