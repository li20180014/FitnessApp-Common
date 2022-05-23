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
public class Aktivnosti implements OpstiDomenskiObjekat {

    private ProgramRada program;
    private int aktivnostId;
    private String nazivAktivnosti;
    private String opis;
    private int trajanjeAktivnosti;
    private String dodatneNapomene;

    public Aktivnosti() {
    }

    public Aktivnosti(ProgramRada program, int aktivnostId, String nazivAktivnosti, String opis, int trajanjeAktivnosti, String dodatneNapomene) {
        this.program = program;
        this.aktivnostId = aktivnostId;
        this.nazivAktivnosti = nazivAktivnosti;
        this.opis = opis;
        this.trajanjeAktivnosti = trajanjeAktivnosti;
        this.dodatneNapomene = dodatneNapomene;
    }

    public ProgramRada getProgram() {
        return program;
    }

    public void setProgram(ProgramRada program) {
        this.program = program;
    }

    public int getAktivnostId() {
        return aktivnostId;
    }

    public void setAktivnostId(int aktivnostId) {
        this.aktivnostId = aktivnostId;
    }

    public String getNazivAktivnosti() {
        return nazivAktivnosti;
    }

    public void setNazivAktivnosti(String nazivAktivnosti) {
        this.nazivAktivnosti = nazivAktivnosti;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getTrajanjeAktivnosti() {
        return trajanjeAktivnosti;
    }

    public void setTrajanjeAktivnosti(int trajanjeAktivnosti) {
        this.trajanjeAktivnosti = trajanjeAktivnosti;
    }

    public String getDodatneNapomene() {
        return dodatneNapomene;
    }

    public void setDodatneNapomene(String dodatneNapomene) {
        this.dodatneNapomene = dodatneNapomene;
    }

    @Override
    public String toString() {
        return nazivAktivnosti + ", Trajanje aktivnosti: " + trajanjeAktivnosti; //To change body of generated methods, choose Tools | Templates.
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
        final Aktivnosti other = (Aktivnosti) obj;
        if (this.aktivnostId != other.aktivnostId) {
            return false;
        }
        if (this.trajanjeAktivnosti != other.trajanjeAktivnosti) {
            return false;
        }
        if (!Objects.equals(this.nazivAktivnosti, other.nazivAktivnosti)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.dodatneNapomene, other.dodatneNapomene)) {
            return false;
        }
        if (!Objects.equals(this.program, other.program)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "aktivnosti";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "programId,nazivAktivnosti,opis,trajanje,dodatneNapomene ";

    }

    @Override
    public String getDeleteString() {
        return " aktivnostiId=" + aktivnostId;
    }

    @Override
    public String getUpdateString() {
        return " aktivnostiId=" + aktivnostId;
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(program.getProgramId()).append(",")
                .append("'").append(nazivAktivnosti).append("',")
                .append("'").append(opis).append("',")
                .append(trajanjeAktivnosti).append(",")
                .append("'").append(dodatneNapomene).append("'");
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(nazivAktivnosti).append("',")
                .append("'").append(opis).append("',")
                .append(trajanjeAktivnosti).append(",")
                .append("'").append(dodatneNapomene).append("'");
        return sb.toString();
    }

    @Override
    public String getAlias() {
        return " a";
    }

    @Override
    public String getForeignKey() {
        return "programId";
    }

    @Override
    public String getSecondForeignKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKey() {
        return "aktivnostId";
    }

    @Override
    public void setId(int id) {
        this.aktivnostId = id;
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            Aktivnosti a = new Aktivnosti();
            a.setAktivnostId(rs.getInt("aktivnostId"));

            a.setNazivAktivnosti(rs.getString("nazviAktivnosti"));
            a.setOpis(rs.getString("opis"));
            a.setDodatneNapomene(rs.getString("dodatneNapomene"));

            ProgramRada pr = new ProgramRada();
            pr.setId(rs.getInt("programId"));
            a.setProgram(pr);

            list.add(a);
        }

        return list;
    }

}
