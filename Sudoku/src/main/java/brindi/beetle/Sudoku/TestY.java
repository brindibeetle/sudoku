package brindi.beetle.Sudoku;

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
		Sudoku sudoku = new Sudoku();
		add(sudoku);
		sudoku.getElement().getStyle()
		.set("display", "block")
		.set("width", "10%")
		.set("margin", "auto")
		.set("height", "10%")
		;
		
//		setHorizontalComponentAlignment(Alignment.CENTER, sudoku);
	}

}
