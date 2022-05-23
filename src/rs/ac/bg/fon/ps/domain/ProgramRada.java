package rs.ac.bg.fon.ps.domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ProgramRada implements OpstiDomenskiObjekat {

    private int programId;
    private String naziv;
    private String tezina;
    private List<Aktivnosti> listaAktivnosti;

    public ProgramRada() {
        listaAktivnosti = new ArrayList<>();
    }

    public ProgramRada(int programId, String naziv, String tezina) {
        this.programId = programId;
        this.naziv = naziv;
        this.tezina = tezina;
        
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public List<Aktivnosti> getListaAktivnosti() {
        return listaAktivnosti;
    }

    public void setListaAktivnosti(List<Aktivnosti> listaAktivnosti) {
        this.listaAktivnosti = listaAktivnosti;
    }

    @Override
    public String toString() {
        return naziv; 
    }

    @Override
    public String getTableName() {
        return "programrada";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "nazivPrograma, tezina";
    }

    @Override
    public String getDeleteString() {
        return " programId= " + programId;
    }

    @Override
    public String getUpdateString() {
        return " programId= " + programId;
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        ProgramRada pr = (ProgramRada) odo;
        StringBuilder sb = new StringBuilder();
        sb.append("programId=").append(pr.getProgramId()).append(", ")
                .append(" nazivPrograma='").append(pr.getNaziv()).append("', ")
                .append(" tezina='").append(pr.getTezina()).append("'");
        return sb.toString();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("', ")
                .append("'").append(tezina).append("'");
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        return "";
    }

    @Override
    public String getAlias() {
        return "pr";
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
        return "programId";
    }

    @Override
    public void setId(int id) {
        this.programId = id;
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
         List<OpstiDomenskiObjekat> list = new ArrayList<>();
        for(Aktivnosti a : listaAktivnosti){
            list.add((OpstiDomenskiObjekat) a);
        }
        return list;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new ProgramRada(rs.getInt("programId"),
                    rs.getString("nazivPrograma"),                   
                    rs.getString("tezina")
            ));
        }

        return list;
    }

}
