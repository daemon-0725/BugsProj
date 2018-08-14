package com.intern.bugs;

class BugNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public BugNotFoundException(String id) {
        super(String.format("No bug found with id: <%s>", id));
    }
}