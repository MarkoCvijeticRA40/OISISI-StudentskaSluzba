package views;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog {

	private static final long serialVersionUID = -3653742172536866910L;
	private static HelpDialog dialog;
	
	private HelpDialog() {
		this.setTitle("Help");
		this.setModal(true);
		
		JPanel container = new JPanel();
		
		String text = "Pri pokretanju programa otvara se glavni prozor za rukovanje studentima, predmetima i profesorima.\n"
				+ "Glavni prozor se sastoji iz menubar-a, toolbar-a i tab-va\n\n"
				+ "Odabirom nekog taba dobijate tabelu izabranog entiteta (student, profesor, predmet)\n\n"
				+ "Tabovi: menjanje tabova je moguce pritiskom na zaglanje istog ili putem precica: "
				+ "ALT+F + ALT+O + (CTRL+S ili CTRL+P ili CTRL+R)\n\n"
				+ "Dodavanje: dodavanje novog entita vrsi se putem dugmeta iz menubar-a, toolbar-a ili precice CTRL+D\n"
				+ "Zatim, otvara se dialog za dodavanje gde je neophodno popuniti podatke.\n"
				+ "Dugme dodaj se moze stisnuti iskljucivo u slucaju gde su svi podaci validni.\n\n"
				+ "Izmena: izmena entiteta vrsi se putem dugmeta iz menubar-a, toolbar-a ili precice CTRL+E\n"
				+ "Sama izmena funkcionise slicno kao dodavanje, u ovom slucaju polja su vec popunjena postojucim podacima.\n"
				+ "Dugme izmeni moguce je stisnuti samo ukoliko su uneti podaci validni.\n\n"
				+ "Brisanje: vrsi se pomocu dugmeta iz menubar-a, toolbar-a ili precice CTRL+D\n"
				+ "Pre brisanja otvara se poruka gde potvrdjujete brisanje.\n"
				+ "Ukoliko entite kojeg zelite da obriste ima neku referencu/vezu u drugom delu aplikacije, brisanje se nece desiti.\n\n"
				+ "Pretraga: moguce je vrsiti pretragu sva tri entiteta. Vrsi se nad entitetom nad kojim je otvoren tab.\n"
				+ "Profesor: 1 parametar - prezime, 2 parametra - prezime, ime\n"
				+ "Predmet: 1 parametar - id, 2 parametra - id, naziv\n"
				+ "Student: 1 parametar - prezime, 2 parametra - prezime, ime, 3 parametra - index, prezime, ime\n\n"
				+ "Sortiranje: moguce je sortiranje svake tabele po svakoj koloni.\n\n"
				+ "Akcije nad studentom: dodavanje predmeta, uklanjanje predmeta, polaganje predmeta, brisanje polozenog predmeta\n\n"
				+ "Akcije nad profesorom: dodavanje predmeta profesoru, brisanje predmeta profesoru\n\n"
				+ "Akcije nad predmetom: dodavanje predmetnog profesora\n\n"
				+ "Perzistencija sistema vrsi se pri zatvaranju aplikacije ili klikom na dugme Save u menubar-u.";
		
			JTextArea txt = new JTextArea();
			txt.setEditable(false);
			txt.setText(text);
			
			container.add(txt);
			
			this.add(container);
			this.pack();
			this.setResizable(false);
			this.setLocationRelativeTo(MainFrame.getInstance());
			this.setVisible(true);
	}
	
	public static HelpDialog getInstance() {
		if (dialog == null)
			dialog = new HelpDialog();
		return dialog;
	}

}
