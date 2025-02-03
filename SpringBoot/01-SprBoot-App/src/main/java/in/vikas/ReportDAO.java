package in.vikas;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ReportDAO {

	public ReportDAO() {
	System.out.println("ReportDAO::Constructor..!");
	}
}
