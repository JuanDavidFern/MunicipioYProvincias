package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MunicipioController;
import controller.ProvinciaController;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtfiltrar;
	private JTextField jtfNombreDelMunicipio;
	private JComboBox<Municipio> jcbSelec;
	private JComboBox<Provincia> jcbProvincia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		jtfiltrar = new JTextField();
		GridBagConstraints gbc_jtfiltrar = new GridBagConstraints();
		gbc_jtfiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfiltrar.gridx = 0;
		gbc_jtfiltrar.gridy = 0;
		contentPane.add(jtfiltrar, gbc_jtfiltrar);
		jtfiltrar.setColumns(10);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();

			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);

		jcbSelec = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbSelec = new GridBagConstraints();
		gbc_jcbSelec.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSelec.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSelec.gridx = 0;
		gbc_jcbSelec.gridy = 1;
		contentPane.add(jcbSelec, gbc_jcbSelec);

		JButton btnSelec = new JButton("Seleccionar");
		btnSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec();
			}
		});
		GridBagConstraints gbc_btnSelec = new GridBagConstraints();
		gbc_btnSelec.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelec.gridx = 1;
		gbc_btnSelec.gridy = 1;
		contentPane.add(btnSelec, gbc_btnSelec);

		JLabel lblNewLabel = new JLabel("Municipio Seleccionado:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0 };
//		gbl_panel.columnWidths = new int[]{0};
//		gbl_panel.rowHeights = new int[]{0};
//		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombreDelMunicipio = new JTextField();
		GridBagConstraints gbc_jtfNombreDelMunicipio = new GridBagConstraints();
		gbc_jtfNombreDelMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombreDelMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombreDelMunicipio.gridx = 1;
		gbc_jtfNombreDelMunicipio.gridy = 0;
		panel.add(jtfNombreDelMunicipio, gbc_jtfNombreDelMunicipio);
		jtfNombreDelMunicipio.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Provincia del municipio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbProvincia = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		
		cargarJcb();
	}
	
	private void guardar() {
		Municipio m = (Municipio) jcbSelec.getSelectedItem();
		Provincia p = (Provincia) jcbProvincia.getSelectedItem();
		m.setNombre(jtfNombreDelMunicipio.getText());
		m.setProvincia(p);
		MunicipioController.update(m);
	}
	
	private void cargarJcb() {
		for (Provincia x : ProvinciaController.findAll()) {
			jcbProvincia.addItem(x);
		}
	}

	private void filtrar() {
		try {
			jcbSelec.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (Municipio x : MunicipioController.findByDesc(jtfiltrar.getText())) {
			jcbSelec.addItem(x);
		}
	}

	private void selec() {
		Municipio m = (Municipio) jcbSelec.getSelectedItem();
		jtfNombreDelMunicipio.setText(m.toString());
		jcbProvincia.setSelectedItem(m.getProvincia());
	}
}
