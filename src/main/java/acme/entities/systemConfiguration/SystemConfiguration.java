package acme.entities.systemConfiguration;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class SystemConfiguration  extends AbstractEntity {
	
	// Serialisation Identifier-------------------------------------------------------------------
	
	protected static final long serialVersionUID=1l;
	
	// Attributes---------------------------------------------------------------------------------
	
	@NotBlank
	protected String acceptedCurrencies;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}?$")
	protected String systemCurrency;
	
	@NotBlank
	protected String strongSpamWords;
	
	@Range(min=0, max=100)
	@Digits(integer=3, fraction=2)
	protected double strongSpamThreshold;
	
	@NotBlank
	protected String weakSpamWords;
	
	@Range(min=0, max=100)
	@Digits(integer=3, fraction=2)
	protected double weakSpamThreshold;
	
	// Derived Attributes----------------------------------------------------------------------------
	
	
	// Relationships---------------------------------------------------------------------------------

}
