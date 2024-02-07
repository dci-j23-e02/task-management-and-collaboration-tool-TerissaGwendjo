public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    REVIEW("Review"),
    COMPLETED("Completed");

    private final String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

