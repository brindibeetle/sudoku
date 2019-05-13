package brindi.beetle.sudoku;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@SuppressWarnings(value = "serial")
public class SudokuForm extends VerticalLayout implements HasSize {

	public static final String TITLE = "Sudoku";
	public static final int number_of_rows = 3;
	public static final int number_of_columns = 3;
	private List<SudokuFormRow> sudokuFormRows;
	
	public SudokuForm() {

		setMargin(false);
		setSpacing(false);
		setPadding(false);
		
		sudokuFormRows = new ArrayList<>();
		for (int row = 1; row <= number_of_rows; row++) {
			SudokuFormRow sudokuFormRow = new SudokuFormRow();
			add(sudokuFormRow);
			sudokuFormRows.add(sudokuFormRow);
		}
		
		HorizontalLayout hl =  new HorizontalLayout();
		
		Button saveButton = new Button("Save");
		saveButton.addClickListener(this::save);
		Button loadButton = new Button("Load");
		loadButton.addClickListener(this::load);
		hl.add(saveButton, loadButton);
		add(hl);
	}
	public String getNumbers() {
		StringBuffer sb = new StringBuffer();
		for (SudokuFormRow sudokuFormRow : sudokuFormRows) {
			sb.append(sudokuFormRow.getNumbers());
		}
		return sb.toString();
	}
	
	public void setNumbers(String numbers) {
		int offset = 0;
		for (SudokuFormRow sudokuFormRow : sudokuFormRows) {
			int newoffset = offset + number_of_columns;
			String numbersRow = numbers.substring(offset, newoffset);
			offset = newoffset;
			sudokuFormRow.setNumbers(numbersRow);
		}
	}
	
	public void load(ClickEvent<Button> clickEvent) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("brindi.beetle.sudoku");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		
		Sudoku sudoku = entityManager.find(Sudoku.class, 1l);
		
		if (sudoku == null)
			sudoku = new Sudoku();
		else
			setNumbers(sudoku.getNumbersString());
		
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Load ...  " + getNumbers());
	}
	public void save(ClickEvent<Button> clickEvent) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("brindi.beetle.sudoku");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Sudoku sudoku = entityManager.find(Sudoku.class, 1l);
		
		sudoku.setNumbersString(getNumbers());

		entityManager.persist(sudoku);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Save ...  " + getNumbers());
	}

}
