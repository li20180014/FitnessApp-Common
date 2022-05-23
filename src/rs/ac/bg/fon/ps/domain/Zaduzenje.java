package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Korisnik
 */
public class Zaduzenje implements OpstiDomenskiObjekat {

    private TrenerKluba trenerKluba;
    private TreningGrupa treningGrupa;

    public Zaduzenje() {
    }

    public Zaduzenje(TrenerKluba trenerKluba, TreningGrupa treningGrupa) {
        this.trenerKluba = trenerKluba;
        this.treningGrupa = treningGrupa;
    }

    public TrenerKluba getTrenerKluba() {
        return trenerKluba;
    }

    public void setTrenerKluba(TrenerKluba trenerKluba) {
        this.trenerKluba = trenerKluba;
    }

    public TreningGrupa getTreningGrupa() {
        return treningGrupa;
    }

    public void setTreningGrupa(TreningGrupa treningGrupa) {
        this.treningGrupa = treningGrupa;
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
        final Zaduzenje other = (Zaduzenje) obj;
        if (!Objects.equals(this.trenerKluba, other.trenerKluba)) {
            return false;
        }
        if (!Objects.equals(this.treningGrupa, other.treningGrupa)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String getTableName() {
        return "zaduzenje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "trenerId, grupaId";
    }

    @Override
    public String getDeleteString() {
        return " trenerId=" + trenerKluba.getTrenerId() + " && grupaId=" + treningGrupa.getGrupaId();
    }

    @Override
    public String getUpdateString() {
        return " trenerId=" + trenerKluba.getTrenerId() + " && grupaId=" + treningGrupa.getGrupaId();
    }

    @Override
    public String getUpdateValues(OpstiDomenskiObjekat odo) {
        Zaduzenje zaduzenje = (Zaduzenje) odo;

        StringBuilder sb = new StringBuilder();
        sb.append(" trenerId=").append(zaduzenje.getTrenerKluba().getTrenerId()).append(", ")
                .append(" grupaId=").append(zaduzenje.getTreningGrupa().getGrupaId()).append(", ");

        return sb.toString();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(trenerKluba.getTrenerId()).append(",")
                .append(treningGrupa.getGrupaId());
        return sb.toString();
    }

    @Override
    public String getInsertValues(int id) {
        return "";
    }

    @Override
    public String getAlias() {
        return "z";
    }

    @Override
    public String getForeignKey() {
        return "trenerId";
    }

    @Override
    public String getSecondForeignKey() {
        return "grupaId";
    }

    @Override
    public String getPrimaryKey() {
        return "grupaId";
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> getList() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();

        while (rs.next()) {
            Zaduzenje z = new Zaduzenje();       

            TrenerKluba tk = new TrenerKluba();
            tk.setId(rs.getInt("trenerId"));
            tk.setUsername(rs.getString("username"));
            tk.setPassword(rs.getString("password"));
            tk.setIme(rs.getString("ime"));
            tk.setPrezime(rs.getString("prezime"));
            tk.setStarost(rs.getInt("starost"));
            z.setTrenerKluba(tk);

            TreningGrupa tg = new TreningGrupa();
            tg.setGrupaId(rs.getInt("grupaId"));
            tg.setNaziv(rs.getString("nazivGrupe"));
            z.setTreningGrupa(tg);

            list.add(z);
        }

        return list;
    }

}
