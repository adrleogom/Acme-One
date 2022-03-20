package acme.entitites.stat;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Stat implements Serializable{
	
	protected static final long	serialVersionUID	= 1L;
	
	Double average;
	Double deviation;
	Double min;
	Double man;

}
