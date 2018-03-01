package com.nea.sm.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.YonetimKurs;
import com.nea.sm.web.repository.KursRepository;

@Controller("kursConverter")
@Scope(value="request")
public class KursConverter implements Converter {

	@Autowired
	private KursRepository kursRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				YonetimKurs kurs = kursRepository.findOne(new Long(value));
				return kurs;
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
		if (value != null && !value.equals("null") && value instanceof YonetimKurs ) {
			return String.valueOf(((YonetimKurs)value).getId());
		} else {
			return null;
		}
	}
}
