package brindi.beetle.Sudoku;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@SuppressWarnings(value = "serial")
public class Sudoku extends VerticalLayout implements HasSize {

	public static final String TITLE = "Sudoku";
	private List<SudokuFormRow> sudokuFormRows;
	
	public Sudoku() {

		setMargin(false);
		setSpacing(false);
		setPadding(false);
		
		sudokuFormRows = new ArrayList<>();
		for (int row = 1; row <= 3; row++) {
			SudokuFormRow sudokuFormRow = new SudokuFormRow();
			add(sudokuFormRow);
			sudokuFormRows.add(sudokuFormRow);
		}
		
		Button button = new Button("Save");
		button.addClickListener(this::save);
		add(button);
	}
	public String getValue() {
		StringBuffer sb = new StringBuffer();
		for (SudokuFormRow sudokuFormRow : sudokuFormRows) {
			sb.append(sudokuFormRow.getValue());
		}
		return sb.toString();
	}
	
	public void save(ClickEvent<Button> clickEvent) {
		System.out.println("Save ...  " + getValue());
	}

}
