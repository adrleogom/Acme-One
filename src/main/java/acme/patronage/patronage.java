package acme.patronage;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class patronage {
	
	protected static final long serialVersionUID = 1l;
	
	protected Status status;
	
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(min = 1, max = 256)
	protected String legalStuff;
	
	@Positive
	protected double budget;
	
	protected Date period;
	
	@URL
	protected String furtherInfo;
}
