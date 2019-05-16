package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.OlderMapper;
import project.example.demo.model.Older;

import java.util.List;

@Service
public class OlderServiceImp implements  OlderService {
  @Autowired
    private OlderMapper olderMapper;
  @Override
   public  List<Older> findAllOlder(){
       List<Older> olderList=olderMapper.findAllOlders();
       return  olderList;
   }
   @Override
    public Older findById(int id){
      Older older=olderMapper.findById(id);
      return older;
    }

    @Override
    public void insertOlder(Older older){
      olderMapper.insertOlder(older);
    }

    @Override
    public List<Older> findBySex(String sex){
        List<Older>olderList=olderMapper.findBySex(sex);
        return  olderList;
    }
    @Override
    public List<Older>findByHealthyState(String healthyState) {
        List<Older>olderList=olderMapper.findByHealthyState(healthyState);
        return olderList;
    }
    @Override
    public void deleteOlder(int id){
      olderMapper.deleteOlder(id);
    }
}
