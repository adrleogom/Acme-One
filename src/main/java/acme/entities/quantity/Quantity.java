package acme.entities.quantity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
		// Attributes -------------------------------------------------------------
	

			@Positive
			protected Integer number;
		
		// Relationships ----------------------------------------------------------
			@NotNull
			@Valid
			@ManyToOne(optional = false)
			protected Item item;
			
			@NotNull
			@Valid
			@ManyToOne(optional=false)
			protected Toolkit toolkit;
			
}
