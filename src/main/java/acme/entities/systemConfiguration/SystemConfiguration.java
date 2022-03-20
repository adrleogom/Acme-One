package acme.entities.systemConfiguration;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

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
	protected String acceptedCurrencies = "EUR, USD, GBP";
	
	@NotBlank
	protected String systemCurrency = "EUR";
	
	@NotBlank
	protected String strongSpamWords = "sex, sexo, hard core, viagra, cialis";
	
	@NotBlank
	@Range(min=0, max=100)
	@Digits(integer=2, fraction=2)
	protected Double strongSpamThreshold = 10.00;
	
	@NotBlank
	protected String weakSpamWords = "sexy, nigeria, you've won, has ganado, one million, un millón";
	
	@NotBlank
	@Range(min=0, max=100)
	@Digits(integer=2, fraction=2)
	protected Double weakSpamThreshold = 25.00;
	
	// Derived Attributes----------------------------------------------------------------------------
	
	
	// Relationships---------------------------------------------------------------------------------

}
