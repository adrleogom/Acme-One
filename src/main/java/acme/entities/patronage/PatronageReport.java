package acme.entities.patronage;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport {

	// Serialisation identifier -----------------------------------------------
	
	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^<[A-Z]{3}-[0-9]{3}(-[A-Z])?:[0-9]{4,6}>$")
	@Column(unique = true)
	protected String			sequenceNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date				creationMoment;
	
	@NotBlank
	@Length(min = 0, max = 255)
	protected String 			memorandum;
	
	@URL
	protected String			link;
	
	// Derived attributes -----------------------------------------------------

	
	// Relationships ----------------------------------------------------------
	@JoinColumn(name = "patronageId", referencedColumnName = "id")
	protected Patronage			patronage;
	
}
