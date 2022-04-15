package acme.entities.patronage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	
	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------

	@Pattern(regexp = "^<[A-Z]{3}-[0-9]{3}(-[A-Z])?:[0-9]{4,6}>$")
	@Digits(integer=4, fraction=0)
	@Column(unique = true)
	protected Integer			sNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				creationMoment;
	
	@NotBlank
	@Length(min = 0, max = 255)
	@NotNull
	protected String 			memorandum;
	
	@URL
	protected String			furtherInfo;
	
	// Derived attributes -----------------------------------------------------
	public String sequenceNumber() {
		return this.patronage.getCode() + ":" + this.sNumber;
	}
	
	
	// Relationships ----------------------------------------------------------
	@NotNull
	@ManyToOne(optional=false)
	@Valid
	protected Patronage			patronage;
	
}
