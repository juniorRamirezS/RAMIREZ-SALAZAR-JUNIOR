package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DaoEnMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(DaoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologos.size()+1);
        odontologos.add(odontologo);
        logger.info("Odontologo guardado en memoria " +odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Odontologo odontologoARetornar = null;
        for(Odontologo odontologo : odontologos){
            if(odontologo.getId()== id){
                odontologoARetornar = odontologo;
            }
        }
        if(odontologoARetornar!=null){
            logger.info("Odontologo encontrado "+ odontologoARetornar);
        }else logger.info("Odontologo no encontrado");
        return odontologoARetornar;
    }

    @Override
    public List<Odontologo> listaTodos() {
        return null;
    }
}
