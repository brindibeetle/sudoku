package brindi.beetle.sudoku;

import com.vaadin.flow.component.textfield.TextField;

@SuppressWarnings(value = { "serial" })
public class SudokuFormField extends TextField {

//	private final static String fatBorder = "1px solid black";
	private final static String thinBorder = "0.5px solid darkgray";
//	private final static String fatSpace = "31.5px";
	private final static String thinSpace = "32px";

	public SudokuFormField() {
		super();
		setMaxLength(1);
		setPattern("[1-9]");

		getStyle().set("border-top", thinBorder).set("border-bottom", thinBorder)
			.set("background-color", "light-gray");
		setHeight(thinSpace);
		getStyle().set("border-left", thinBorder).set("border-right", thinBorder);
		setWidth(thinSpace);

		getStyle().set("padding", "0").set("v-align", "center").set("background-color", "light-yellow");

	}
	
	public String getNumber() {
		String s = super.getValue();
		if (s == null || s.length() == 0)
			return "#";
		else if (s.length() == 1) 
			return s;
		else
			return s.substring(s.length() -1, s.length());
	}
	public void setNumber(String number) {
		setValue(number);
	}

}
