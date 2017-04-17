package MODEL;
public class Affiliation {

    
    private int id;
    private String name;
    private String logoSrc;
    private int votes;
    
    public Affiliation(int id, String name, String logoSrc, int votes){
        setId(id);
        setName(name);
        setLogoSrc(logoSrc);
        setVotes(votes);
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the logoSrc
     */
    public String getLogoSrc() {
        return logoSrc;
    }

    /**
     * @param logoSrc the logoSrc to set
     */
    public void setLogoSrc(String logoSrc) {
        this.logoSrc = logoSrc;
    }
    /**
     * @return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }
    
}
