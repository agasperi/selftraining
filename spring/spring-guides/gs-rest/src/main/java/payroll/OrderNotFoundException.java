package payroll;

class OrderNotFoundException extends RuntimeException {

	static final long serialVersionUID = 1L;

	OrderNotFoundException(Long id) {
		super("Could not find Order " + id);
	}
}
