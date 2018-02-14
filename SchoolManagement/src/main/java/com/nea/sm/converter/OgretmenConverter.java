package com.nea.sm.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Ogretmen;
import com.nea.sm.repository.OgretmenRepository;

@Controller("ogretmenConverter")
@Scope(value="request")
public class OgretmenConverter implements Converter{
	
	@Autowired
	private OgretmenRepository ogretmenRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Ogretmen ogretmen = ogretmenRepository.findOne(new Long(value));
				return ogretmen;
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
		if (value != null && !value.equals("null") && value instanceof Ogretmen ) {
			return String.valueOf(((Ogretmen)value).getId());
		} else {
			return null;
		}
	}

}
