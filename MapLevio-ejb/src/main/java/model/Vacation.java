package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Vacations database table.
 * 
 */
@Entity
@Table(name="Vacations")
@NamedQuery(name="Vacation.findAll", query="SELECT v FROM Vacation v")
public class Vacation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VacationId")
	private int vacationId;

	private Timestamp endDate;

	private Timestamp startDate;

	public Vacation() {
	}

	public int getVacationId() {
		return this.vacationId;
	}

	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

}