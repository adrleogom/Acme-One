package acme.entities.tool;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tool extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		@NotBlank
		@Max(100)
		protected String			name;
		
		@Pattern(regexp = "^[A-Z]{3}-[0-\r\n"+ "9]{3}(-[A-Z])?$")
		@Column
		protected String			code;

		@NotBlank
		@Max(100)
		protected String			tecnology;

		@NotBlank
		@Max(255)
		protected String			description;
		
		@Positive
		protected Double			retailPrice;
		
		@URL
		protected String			link;
		

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		
		//@NotNull
		//@Valid
		//@ManyToOne(optional = false)
		//protected Component component;

}



