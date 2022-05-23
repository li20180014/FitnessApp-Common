package rs.ac.bg.fon.ps.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class TreningGrupa implements OpstiDomenskiObjekat {

    private int grupaId;
    private String nazivGrupe;
    private int kapacitet;
    private ProgramRada program;
    private List<TrenerKluba> zaduzeniTreneri;
    private String status;

    public TreningGrupa() {
    }

    public TreningGrupa(String nazivGrupe, int kapacitet, ProgramRada program) {
        this.nazivGrupe = nazivGrupe;
        this.kapacitet = kapacitet;
        this.program = program;
    }

    public List<TrenerKluba> getZaduzeniTreneri() {
        return zaduzeniTreneri;
    }

    public void setZaduzeniTreneri(List<TrenerKluba> zaduzeniTreneri) {
        this.zaduzeniTreneri = zaduzeniTreneri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public int getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(int grupaId) {
        this.grupaId = grupaId;
    }

    public String getNaziv() {
        return nazivGrupe;
    }

    public void setNaziv(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public ProgramRada getProgram() {
        return program;
    }

    public void setProgram(ProgramRada program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return nazivGrupe; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        return "treninggrupa";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "nazivGrupe, kapacitet, programId";
    }

    @Override
    public String getDeleteString() {
        return "grupaId=" + grupaId;
    }

    @Override
    public String getUpdateString() {
        return "grupaId=" + grupaId;
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        TreningGrupa tr = (TreningGrupa) odo;
        StringBuilder sb = new StringBuilder();
        sb.append(" nazivGrupe='").append(tr.getNaziv()).append("', ")
                .append(" kapacitet=").append(tr.getKapacitet()).append(", ")
                .append(" programId=").append(tr.getProgram().getProgramId());
        return sb.toString();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(nazivGrupe).append("',")
                .append(kapacitet).append(",")
                .append(program.getProgramId());
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAlias() {
        return "tg";
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
        return "grupaId";
    }

    @Override
    public void setId(int id) {
        this.grupaId = id;
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            TreningGrupa treningGrupa = new TreningGrupa();
            treningGrupa.setId(rs.getInt("grupaId"));
            treningGrupa.setNaziv(rs.getString("nazivGrupe"));

            treningGrupa.setKapacitet(rs.getInt("kapacitet"));

            ProgramRada pr = new ProgramRada();
            pr.setProgramId(rs.getInt("programId"));
            pr.setNaziv(rs.getString("nazivPrograma"));
            pr.setTezina(rs.getString("tezina"));
            treningGrupa.setProgram(pr);

            list.add(treningGrupa);
        }

        return list;
    }

}
