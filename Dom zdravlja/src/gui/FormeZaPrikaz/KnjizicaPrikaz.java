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
import gui.formeZaIzmenuIDodavanje.KnjizicaForma;
import osobe.Zdrastvena_knjizica;

public class KnjizicaPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable KnjizicaTabela;
	
	private Zdrastvo sistem;
	
	public KnjizicaPrikaz(Zdrastvo sistem) {
		this.sistem = sistem;
		setTitle("Zdrastvene knjizice");
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
		
		String[] zaglavlje = new String[] { "Br knjizice", "Datum isteka", "Kategorija"};
		Object[][] podatak = new Object[sistem.getKnjizice().size()][zaglavlje.length];
		for (int i = 0; i < sistem.getKnjizice().size(); i++) {
			Zdrastvena_knjizica knjizica = sistem.getKnjizice().get(i);
			podatak[i][0] = knjizica.getBroj_zdras_knjiz();
			podatak[i][1] = knjizica.getDatum_isteka();
			podatak[i][2] = knjizica.getKategorija();
		}
		tableModel = new DefaultTableModel(podatak, zaglavlje);
		KnjizicaTabela = new JTable(tableModel);
		KnjizicaTabela = new JTable(tableModel);
		KnjizicaTabela.setRowSelectionAllowed(true);
		KnjizicaTabela.setColumnSelectionAllowed(false);
		KnjizicaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		KnjizicaTabela.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(KnjizicaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjizicaForma kf= new KnjizicaForma(sistem, null);
				kf.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = KnjizicaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)KnjizicaTabela.getModel();
					String br = model.getValueAt(red, 0).toString();
					Zdrastvena_knjizica knjizica = sistem.pronadjiKnjizicu(br);
					if(knjizica != null) {
						KnjizicaForma kef = new KnjizicaForma(sistem, knjizica);
						kef.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu zdrastvenu knjizicu!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = KnjizicaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)KnjizicaTabela.getModel();
					String br = model.getValueAt(red, 0).toString();
					Zdrastvena_knjizica knjizica = sistem.pronadjiKnjizicu(br);
					if(knjizica != null) {
						int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete zdrastvenu knjizicu?", knjizica.getBroj_zdras_knjiz() + knjizica.getDatum_isteka() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							sistem.getKnjizice().remove(knjizica);
							model.removeRow(red);
							sistem.snimiKnjizicu("zdrastvenaKnjizica.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu zdrastvenu knjizicu!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}