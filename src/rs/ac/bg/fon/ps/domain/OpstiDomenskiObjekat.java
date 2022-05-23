/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getDeleteString();

    String getUpdateString();

    String getUpdateValues(OpstiDomenskiObjekat odo);

    String getInsertValues();

    String getInsertValues(int id);

    String getAlias();

    String getForeignKey();

    String getSecondForeignKey();

    String getPrimaryKey();

    void setId(int id);

    List<OpstiDomenskiObjekat> getList();

    List<OpstiDomenskiObjekat> readList(ResultSet rs) throws Exception;
}
