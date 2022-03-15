package acme.entities.announcement;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Annnouncement {
	
	// Serialisation Identifier-------------------------------------------------------------------
	
	protected static final long serialVersionUID=1l;
	
	// Attributes---------------------------------------------------------------------------------
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date moment;
	
	@NotBlank
	@Length(min=1, max=101)
	protected String title;
	
	@NotBlank
	@Length(min=1, max=256)
	protected String body;
	
	@NotNull
	protected Boolean flag;
	
	@URL
	protected String link;
	
	// Derived Attributes----------------------------------------------------------------------------
	
	
	// Relationships---------------------------------------------------------------------------------
}
