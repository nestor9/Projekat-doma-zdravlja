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
import gui.formeZaIzmenuIDodavanje.PregledForma;
import pregledPacijenta.PregledPacijenta;

public class PregledPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable PregledTabela;
	
	private Zdrastvo sistem;
	
	public PregledPrikaz(Zdrastvo sistem) {
		this.sistem = sistem;
		setTitle("Pregledi");
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
		
		String[] zaglavlje = new String[] { "Pacijent", "Lekar", "Broj pregleda", "Termin", "Broj sobe", "Opis", "Status pregleda"};
		Object[][] podatak = new Object[sistem.getPregledi().size()][zaglavlje.length];
		for (int i = 0; i < sistem.getPregledi().size(); i++) {
			PregledPacijenta pregled = sistem.getPregledi().get(i);
			podatak[i][0] = pregled.getPacijent();
			podatak[i][1] = pregled.getLekar();
			podatak[i][2] = pregled.getBr_pregleda();
			podatak[i][3] = pregled.getTermin();
			podatak[i][4] = pregled.getBr_sobe();
			podatak[i][5] = pregled.getOpis();
			podatak[i][6] = pregled.getStatus_pregleda();
		}
		tableModel = new DefaultTableModel(podatak, zaglavlje);
		PregledTabela = new JTable(tableModel);
		PregledTabela = new JTable(tableModel);
		PregledTabela.setRowSelectionAllowed(true);
		PregledTabela.setColumnSelectionAllowed(false);
		PregledTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PregledTabela.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(PregledTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledForma pf=new PregledForma(sistem, null);
				pf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = PregledTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)PregledTabela.getModel();
					       //ako ne bude radiolo umesto ispod gde pise model ide PregledTabela
					String br_pregleda = model.getValueAt(red, 2).toString();
					PregledPacijenta pregled = sistem.pronadjiPregled(br_pregleda);
					if(pregled != null) {
						PregledForma pef = new PregledForma(sistem, pregled);
						pef.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabrani pregled pacijenta!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = PregledTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)PregledTabela.getModel();
					String br_pregleda = model.getValueAt(red, 2).toString();
					PregledPacijenta pregled = sistem.pronadjiPregled(br_pregleda);
					if(pregled != null) {
						int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete pregled?", pregled.getPacijent()+pregled.getBr_pregleda() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							sistem.getPregledi().remove(pregled);
							model.removeRow(red);
							sistem.snimiPreglede("pregled.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabrani pregled pacijenta!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}

