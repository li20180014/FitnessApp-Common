package rs.ac.bg.fon.ps.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TrenerKluba implements OpstiDomenskiObjekat {

    private int trenerId;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private int starost;
    Date datumLogovanja;

    public TrenerKluba() {
    }

    public TrenerKluba(int trenerId, String username, String password, String ime, String prezime, int starost) {
        this.trenerId = trenerId;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
    }

    public void setDatumLogovanja(Date datumLogovanja) {
        this.datumLogovanja = datumLogovanja;
    }

    public Date getDatumLogovanja() {
        return datumLogovanja;
    }
    

    public int getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(int trenerId) {
        this.trenerId = trenerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String toString() {
        return ime + " " + prezime; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final TrenerKluba other = (TrenerKluba) obj;
        if (this.trenerId != other.trenerId) {
            return false;
        }
        if (this.starost != other.starost) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "trenerkluba";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " username, password, ime, prezime, starost ";
    }

    @Override
    public String getDeleteString() {
        return " trenerId= " + trenerId;
    }

    @Override
    public String getUpdateString() {
        return " trenerId= " + trenerId;
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        TrenerKluba trener = (TrenerKluba) odo;
        StringBuilder sb = new StringBuilder();
        sb.append("trenerId=").append(trener.getTrenerId()).append(", ")
                .append(" username='").append(trener.getUsername()).append("', ")
                .append(" password='").append(trener.getPassword()).append("', ")
                .append(" ime='").append(trener.getIme()).append("',")
                .append(" prezime='").append(trener.getPrezime()).append("',")
                .append(" starost=").append(trener.getStarost());
        return sb.toString();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(username).append("',")
                .append("'").append(password).append("',")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append(starost);
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        return "";
    }

    @Override
    public String getAlias() {
        return "t";
    }

    @Override
    public String getForeignKey() {
        return "";
    }

    @Override
    public String getSecondForeignKey() {
        return "";
    }

    @Override
    public String getPrimaryKey() {
        return "trenerId";
    }

    @Override
    public void setId(int id) {
        this.trenerId = id;
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new TrenerKluba(rs.getInt("trenerId"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getInt("starost")
            ));
        }

        return list;
    }

}
