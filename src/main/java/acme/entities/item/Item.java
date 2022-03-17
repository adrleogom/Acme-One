package acme.entities.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item extends AbstractEntity{
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;
	
		// Attributes -------------------------------------------------------------

		protected ItemType			itemType;
		
		@NotBlank
		@Length(min=1,max=100)
		protected String			name;
		
		@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$") 
		@Column
		protected String			code;
	
		@NotBlank
		@Length(min=1,max=100)
		protected String			technology;
	
		@NotBlank
		@Length(min=1,max=255)
		protected String			description;
		
		@Positive
		protected Double			retailPrice;
		
		@URL
		protected String			link;
		
	
		// Derived attributes -----------------------------------------------------
	
		// Relationships ----------------------------------------------------------
		
}
