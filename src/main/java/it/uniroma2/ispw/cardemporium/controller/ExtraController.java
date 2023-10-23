package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.ExtraBeanG;
import it.uniroma2.ispw.cardemporium.dao.GetExtraDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

public class ExtraController {

    public static ExtraBeanG getEXTRA(int id) throws ExceptionDBerror {

        GetExtraDAO extra = new GetExtraDAO();

        return extra.getExtra(id);
    }

}
