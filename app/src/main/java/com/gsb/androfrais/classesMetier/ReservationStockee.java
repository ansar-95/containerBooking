package com.gsb.androfrais.classesMetier;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public interface ReservationStockee {

    public Date getDateFinEffective(Date datedebut, int nbJoursStockee);
    public Pile setPile(JSONObject jsonObject);
    public int setEmplacementDepart(int emplacement);
}
