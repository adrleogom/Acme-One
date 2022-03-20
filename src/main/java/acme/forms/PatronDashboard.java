
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import acme.entities.stat.Stat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long					serialVersionUID	= 1L;

	protected Map<Status, Integer>					totalNumberOfPatronages;

	protected Map<Pair<Status, String>, Stat>	budgetOfPatronages;
}
