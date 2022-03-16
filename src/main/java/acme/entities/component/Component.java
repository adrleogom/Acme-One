package acme.entities.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.toolkit.Toolkit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------


	@NotBlank
	@Max(100)
	protected String				name;

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String				code;
	
	@NotBlank
	@Length(min=1,max=100)
	protected String				technology;
	
	@NotBlank
	@Length(min=1,max=255)
	protected String				description;
	
	@NotBlank
	@Positive
	protected Double				retailPrice;
	
	
	@URL
	protected String				link;
	
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@OneToMany
	protected Component             component;
	
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Toolkit               toolkit;
	
}
