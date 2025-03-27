package Java_base_hw5;

public class Project {
    private String projectName;
    private int duration;

    public Project(String name, int duration){
        this.projectName = name;
        this.duration = duration;
    }

    public String getName() {
        return projectName;
    }

    public void setName(String projectName){
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "[" + projectName + ", " + duration + "]";
    }
}
