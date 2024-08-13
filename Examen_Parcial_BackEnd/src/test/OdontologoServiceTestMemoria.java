package test;

import dao.impl.DaoEnMemoria;
import model.Odontologo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;


import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestMemoria {
    OdontologoService odontologoService = new OdontologoService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que un Odontologo fue cargado correctamente")
    void caso1(){
        //Dado
        Odontologo odontologo = new Odontologo("1452368795","Maria", "Flores");
        //cuando
        Odontologo odontologoDesdeDb = odontologoService.guardarOdontologo(odontologo);
        // entonces
        assertNotNull(odontologoDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que un Odontologo pueda acceder por id")
    void caso2(){
        //Dado
        Integer id = 1;
        //cuando
        Odontologo odontologo = new Odontologo("2548974677","Noel", "Suares");
        //cuando
        odontologoService.guardarOdontologo(odontologo);
        Odontologo odontologoDesdeDb = odontologoService.buscarPorId(id);
        // entonces
        assertEquals(id, odontologoDesdeDb.getId());
    }

}