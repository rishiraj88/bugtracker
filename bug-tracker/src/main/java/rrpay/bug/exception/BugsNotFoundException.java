package rrpay.bug.exception;

public class BugsNotFoundException extends RuntimeException {
    public BugsNotFoundException() {
        super("No bugs could be found for the query at the moment. Check the search criteria and try again.");
    }public BugsNotFoundException(String bugCode) {
        super("No bugs with the code "+bugCode+" could be found. Check the code again and then query.");
    }
}
