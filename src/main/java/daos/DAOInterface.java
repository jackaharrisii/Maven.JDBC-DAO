package daos;

import java.util.List;

public interface DAOInterface {
    public Car findById(int id);
    public List findAll();
    public Car update (Car dto);
    public Car create (Car dto);
    public boolean delete (int id);

//    public Integer getId(){
//        return this.id;
//    }
}
