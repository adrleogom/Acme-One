package acme.entities.quantity;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.entities.item.Item;

public class Quantity {
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
		// Attributes -------------------------------------------------------------
	
			@NotBlank
			@Positive
			protected Double number;
		
		// Relationships ----------------------------------------------------------
			@NotNull
			@Valid
			@ManyToOne(optional = false)
			protected Item item;
}
