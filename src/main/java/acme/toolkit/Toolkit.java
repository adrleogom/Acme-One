package acme.toolkit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity{

	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column
	protected String			code;

	@NotBlank
	@Max(101)
	protected String			title;

	@NotBlank
	@Max(256)
	protected String			description;

	@NotBlank
	@Max(256)
	protected String			assemblyNotes;
	
	@URL
	protected String			link;
	
}
