package brindi.beetle.sudoku;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUDOKU")
@SuppressWarnings("serial")
public class Sudoku implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="numbers")
	private String numbersString;

	public Sudoku() {
	}
	
	public Sudoku(String numbersString) {
		super();
		this.numbersString = numbersString;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumbersString() {
		return numbersString;
	}

	public void setNumbersString(String numbersString) {
		this.numbersString = numbersString;
	}	
}
