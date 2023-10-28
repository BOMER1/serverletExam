package Model;

public class GeekUsers {
    private int geekUserId;
    private int numberOfPosts;
    private String geekUserName, technologiesPreferred;

    public int getId() { return geekUserId; }

    public void setId(int id) { this.geekUserId = id; }

    public String getName() { return geekUserName; }

    public void setName(String name)
    {
        this.geekUserName = name;
    }

    public int getNumberOfPosts() { return numberOfPosts; }

    public void setNumberOfPosts(int numberOfPosts)
    {
        this.numberOfPosts = numberOfPosts;
    }

    public String gettechnologiesPreferred()
    {
        return technologiesPreferred;
    }

    public void
    setTechnologiesPreferred(String technologiesPreferred)
    {
        this.technologiesPreferred = technologiesPreferred;
    }
}