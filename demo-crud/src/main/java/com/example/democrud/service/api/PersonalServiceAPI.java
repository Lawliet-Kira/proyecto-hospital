package com.example.democrud.service.api;

import com.example.democrud.commons.GenericServiceAPI;
import com.example.democrud.model.Personal;
import com.example.democrud.model.dto.PersonalDTO;

public interface PersonalServiceAPI extends GenericServiceAPI<Personal, Long> {
	
	public Personal createPersonal(PersonalDTO personal);

}
