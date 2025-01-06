
public class Task {
    private String id;
    private String description;

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task)) return false;
        Task task = (Task) obj;
        return id.equals(task.id) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return id.hashCode() + description.hashCode();
    }
}
