package com.nea.sm.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Salon;
import com.nea.sm.repository.SalonRepository;

@Controller("salonConverter")
@Scope("request")
public class SalonConverter implements Converter {

	@Autowired
	private SalonRepository salonRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Salon salon = salonRepository.findOne(new Long(value));
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
		if (value != null && value instanceof Salon && !value.equals("null")) {
			return String.valueOf(((Salon)value).getId());
		} else {
			return null;
		}
	}

}
