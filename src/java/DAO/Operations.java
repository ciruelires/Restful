
package DAO;
import MODEL.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author alfon
 */
public class Operations {
    public String registerHero(Hero hero, Connection connection){
        String name=hero.getName();
        String surname=hero.getSurname();
        String alias=hero.getAlias();
        String powers=hero.getPowers();
        String password=hero.getPassword();
        //The password given is crypted when we register it
        String query="insert into hero values (null, ?,?,?,?,AES_ENCRYPT(?,'bang'),'no')";
        /*We construct the query string*/
        String msg;
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, surname);
            stm.setString(3, alias);
            stm.setString(4, powers);
            stm.setString(5, password);
            //JOptionPane.showMessageDialog(null, stm,"",JOptionPane.INFORMATION_MESSAGE);
            stm.executeUpdate();
            msg= "Hero registered successfully!";
        }
        catch( Exception e){
            msg= "My hero... there was a problem, could not register";
        }
        return msg;
    }
    public Hero login(Hero hero, Connection connection){
        String alias=hero.getAlias();
        String password=hero.getPassword();
        //We decrypt the password field value
        String query="select * from hero where alias=? and AES_DECRYPT(password,'bang')=?";
        /*We construct the query string*/
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, alias);
            stm.setString(2, password);
            
            //We save the select's result and check its first row, if it is, the user exists
            ResultSet result =stm.executeQuery();
            if(result.first())return new Hero(result.getInt("id"), result.getString("name"), result.getString("surname"), result.getString("alias"), result.getString("powers"),  result.getString("password"),  result.getBoolean("voted"));
            else return null;
        }
        catch( Exception e){
            return null;
        }
    }
    public ArrayList<Affiliation> getTeams(Connection connection){
        String query="select * from affiliation";
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet result =stm.executeQuery();
            int i=0;
            ArrayList<Affiliation> teams=new ArrayList<Affiliation>();
            //We get the select's result in "result", so we iterate it to recover each row
            while(result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                String logoSrc=result.getString("logoSrc");
                int votes=result.getInt("votes");
                //We construct the affiliation object inside the array
                teams.add(new Affiliation(id,name, logoSrc, votes));  
                i++;
            }
            return teams;
        }
        catch( Exception e){
            return null;
        }
    }
    public ArrayList<Hero> getHeroes(Connection connection){
        String query="select * from hero";
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet result =stm.executeQuery();
            int i=0;
            ArrayList<Hero> heroes=new ArrayList<Hero>();
            //We get the select's result in "result", so we iterate it to recover each row
            while(result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                String surname=result.getString("surname");
                String alias=result.getString("alias");
                String powers=result.getString("Powers");
                boolean voted=result.getBoolean("voted");
                //We construct the affiliation object inside the array
                heroes.add(new Hero(id,name, surname, alias, powers,null,voted));  
                i++;
            }
            return heroes;
        }
        catch( Exception e){
            return null;
        }
    }
    public String join(String idTeam, int idHero, Connection connection){
        String heroVote="update hero set voted='yes' where id="+idHero;
        String affiliationVotes="update affiliation set votes=votes+1 where id="+idTeam;
        String nameTeam="select name from affiliation where id="+idTeam;
        String msg="error";
        try {
            PreparedStatement stm = connection.prepareStatement(nameTeam);
            ResultSet resultName=stm.executeQuery(nameTeam);
            resultName.first();
            String name=resultName.getString("name");

            //We avoid autocommit
            connection.setAutoCommit(false);
            stm = connection.prepareStatement(heroVote);
            int result =stm.executeUpdate();
            if(result>0){
                stm = connection.prepareStatement(affiliationVotes);
                result =stm.executeUpdate();
                if(result>0){
                    connection.commit();
                    msg=name;
                }
                else{
                    msg="error";
                    connection.rollback();
                }
            }
            else{
                connection.rollback();
                msg="error";
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    public Affiliation getWinner(Connection connection){
        //This will query the first affiliation ordered by votes
        String query="select * from affiliation order by votes desc limit 1";

        Affiliation team=null;
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet result=stm.executeQuery(query);
            result.first();
            int id=result.getInt("id");
            String name=result.getString("name");
            String logoSrc=result.getString("logoSrc");
            int votes=result.getInt("votes");
            team= new Affiliation(id,name, logoSrc, votes);
        }
        catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }
    public String deleteUser(Hero hero, Connection connection){
        String alias=hero.getAlias();
        String password=hero.getPassword();
        String query="delete from hero where alias=? and AES_DECRYPT(password,'bang')=?";
        /*We construct the query string*/
        String msg;
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, alias);
            stm.setString(2, password);
            int result =stm.executeUpdate();
            if(result>0)msg="User deleted.<br>Good bye "+alias+".";
            else msg="Could not delete that user.";
        }
        catch( Exception e){
            msg="Could not delete that user.";
        }
        return msg;
    }
}
