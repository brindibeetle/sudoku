package brindi.beetle.sudoku;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = TestY.ROUTE)
@SuppressWarnings(value = "serial")
public class TestY extends VerticalLayout implements HasSize {

	public static final String ROUTE = "emile";
	public static final String TITLE = "Sudoku";

	public TestY() {
		
		getElement().getStyle().set("height","100%");
		SudokuForm sudokuForm = new SudokuForm();
		add(sudokuForm);
		sudokuForm.getElement().getStyle()
		.set("display", "block")
		.set("width", "1%")
		.set("margin", "auto")
		.set("height", "1%")
		;
		sudokuForm.setNumbers("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
		
		
//		setHorizontalComponentAlignment(Alignment.CENTER, sudoku);
	}

}
