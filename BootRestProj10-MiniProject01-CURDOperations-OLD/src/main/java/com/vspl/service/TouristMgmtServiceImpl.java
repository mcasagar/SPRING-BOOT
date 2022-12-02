package com.vspl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.vspl.entity.Tourist;
import com.vspl.exception.TouristNotFoundException;
import com.vspl.repository.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTid(); //it actually returns same tourist object having dynamically generated identity value
		return "Tourist is register having the id value :: " + idVal;
	}
	@Override
	public List<Tourist> fetchAllTourist() {
		
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	
	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException {
		
		return touristRepo.findById(id)
						.orElseThrow(()-> new TouristNotFoundException(id + " Tourist Not Found"));
	}
	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if(optional.isPresent()) {
			touristRepo.save(tourist); // save(-) method performs either save obj or update obj operation 
			return tourist.getTid() + " Tourist is Updated...";
		}else {
			throw new TouristNotFoundException(tourist.getTid() + " Tourist not found");
		}
	}
	
	
	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		Optional< Tourist> opt = touristRepo.findById(tid);
		if(opt.isPresent()) {
			touristRepo.delete(opt.get()); //get() is optional class method it will give the object from optional object
			return tid + " Tourist Deleted...";
		}else {
			throw new TouristNotFoundException(tid + " Tourist not found");
		}
	}
	
	
	

}
