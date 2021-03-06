package brindi.beetle.sudoku;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@SuppressWarnings(value = { "serial" })
public class SudokuFormRow extends HorizontalLayout {

	private List<SudokuFormField> sudokuFormFields;

	public SudokuFormRow() {
		sudokuFormFields = new ArrayList<>();
		for (int column = 1; column <= SudokuForm.number_of_columns; column++) {
			SudokuFormField sudokuFormField =new SudokuFormField();
			sudokuFormFields.add(sudokuFormField);
			add(sudokuFormField);
		}
		setMargin(false);
		setSpacing(false);
		setPadding(false);
//		setHeight("100%");
		
	}
	
	public String getNumbers() {
		StringBuffer sb = new StringBuffer();
		for (SudokuFormField sudokuFormField : sudokuFormFields) {
			sb.append(sudokuFormField.getValue());
		}
		return sb.toString();
	}
	public void setNumbers(String numbers) {
		int offset = 0;
		for (SudokuFormField sudokuFormField : sudokuFormFields) {
			String c = numbers.substring(offset, offset + 1);
			sudokuFormField.setNumber(c);
			offset ++;
		}
	}
	
	
}
