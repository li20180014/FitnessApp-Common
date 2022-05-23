package rs.ac.bg.fon.ps.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Clan implements OpstiDomenskiObjekat {

    private int clanId;
    private String ime;
    private String prezime;
    private String email;
    private boolean clanarina;
    private int starost;
    private TreningGrupa grupa;

    public Clan() {
    }

    public Clan(int clanId, String ime, String prezime, String email, boolean clanarina, int starost, TreningGrupa grupa) {
        this.clanId = clanId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.clanarina = clanarina;
        this.starost = starost;
        this.grupa = grupa;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isClanarina() {
        return clanarina;
    }

    public void setClanarina(boolean clanarina) {
        this.clanarina = clanarina;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public TreningGrupa getGrupa() {
        return grupa;
    }

    public void setGrupa(TreningGrupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return ime + " " + prezime; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clan other = (Clan) obj;
        if (this.clanId != other.clanId) {
            return false;
        }
        if (this.clanarina != other.clanarina) {
            return false;
        }
        if (this.starost != other.starost) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "clan";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " ime, prezime, email, clanarina, starost, grupaId ";
    }

    @Override
    public String getDeleteString() {
        return " clanId= " + clanId;
    }

    @Override
    public String getUpdateString() {
        return " clanId= " + clanId;
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        Clan clan = (Clan) odo;
        StringBuilder sb = new StringBuilder();
        sb.append("clanId=").append(clan.getClanId()).append(", ")
                .append(" ime='").append(clan.getIme()).append("', ")
                .append(" prezime='").append(clan.getPrezime()).append("', ")
                .append(" email='").append(clan.getEmail()).append("',")
                .append(" clanarina=").append(clan.isClanarina()).append(",")
                .append(" starost=").append(clan.getStarost()).append(",")
                .append(" grupaId=").append(clan.getGrupa().getGrupaId());
        return sb.toString();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append("'").append(email).append("',")
                .append(clanarina).append(",")
                .append(starost).append(",")
                .append(grupa.getGrupaId());
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        return "";
    }

    @Override
    public String getAlias() {
        return "c";
    }

    @Override
    public String getForeignKey() {
        return "grupaId";
    }

    @Override
    public String getSecondForeignKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKey() {
        return "clanId";
    }

    @Override
    public void setId(int id) {
        this.clanId = id;
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
       List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            Clan clan = new Clan();
            clan.setId(rs.getInt("clanId"));
            clan.setIme(rs.getString("ime"));
            clan.setPrezime(rs.getString("prezime"));
            clan.setEmail(rs.getString("email"));
            clan.setClanarina(rs.getBoolean("clanarina"));
            clan.setStarost(rs.getInt("starost"));

            TreningGrupa treningGrupa = new TreningGrupa();
            treningGrupa.setId(rs.getInt("grupaId"));
            treningGrupa.setNaziv(rs.getString("nazivGrupe"));
            treningGrupa.setKapacitet(rs.getInt("kapacitet"));
            
            
            clan.setGrupa(treningGrupa);

            list.add(clan);
        }

        return list;
    }    

}
