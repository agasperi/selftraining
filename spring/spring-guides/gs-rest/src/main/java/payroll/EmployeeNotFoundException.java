package payroll;

class EmployeeNotFoundException extends RuntimeException {

	static final long serialVersionUID = 1L;

	EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
