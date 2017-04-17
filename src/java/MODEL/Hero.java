package MODEL;

public class Hero {

    
    private int id;
    private String name;
    private String surname;
    private String alias;
    private String powers;
    private String password;
    private boolean voted;
    
    public Hero(int id, String name, String surname, String alias, String powers, String password, boolean voted){
        setId(id);
        setName(name);
        setSurname(surname);
        setAlias(alias);
        setPassword(password);
        setVoted(voted);
        setPowers(powers);
    }
    public Hero(String alias, String password){
        setAlias(alias);
        setPassword(password);
        setId(0);
        setName(null);
        setSurname(null);
        setPowers(null);
        setVoted(false);
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
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    /**
     * @return the powers
     */
    public String getPowers() {
        return powers;
    }

    /**
     * @param powers the powers to set
     */
    public void setPowers(String powers) {
        this.powers = powers;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the voted
     */
    public boolean isVoted() {
        return voted;
    }

    /**
     * @param voted the voted to set
     */
    public void setVoted(boolean voted) {
        this.voted = voted;
    }
}
