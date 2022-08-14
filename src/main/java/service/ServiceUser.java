package service;

import model.BeanUser;
import model.DaoUser;
import utils.ResultAction;

import java.util.List;

public class ServiceUser {
    DaoUser daoUser = new DaoUser();

    public List<BeanUser> getAll(){
        return daoUser.findAll();
    }
    public BeanUser getUser(int id){
        return daoUser.findOne(id);
    }
    public ResultAction save(BeanUser user){
        ResultAction result = new ResultAction();
        if (daoUser.save(user)){
            result.setResult(true);
            result.setMessage("USUARIO registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try {
            if (daoUser.delete(Integer.parseInt(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Usuario eliminado correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Ocurrio un error");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrio un error");
        }
        return result;
    }
}
