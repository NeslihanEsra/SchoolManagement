package com.nea.sm.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.Salon;
import com.nea.sm.web.repository.SalonRepository;

@Controller("salonConverter")
@Scope(value="request")
public class SalonConverter implements Converter {

	@Autowired
	private SalonRepository salonRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Salon salon = salonRepository.findOne(new Long(value));
				return salon;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("null") && value instanceof Salon ) {
			return String.valueOf(((Salon)value).getId());
		} else {
			return null;
		}
	}

}
