package repository.interfice_repository;
import model.facility.Facility;

import java.util.Map;
public interface IFacilityRepository{
    public void add(Facility facility);
    public Map<Facility,Integer> getAll();

}
